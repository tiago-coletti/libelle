package br.com.hunsriqueano.libelle.controller;

import br.com.hunsriqueano.libelle.entity.Traducao;
import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import br.com.hunsriqueano.libelle.repository.TraducaoRepository;
import br.com.hunsriqueano.libelle.repository.VariacaoOrtograficaRepository;
import org.apache.commons.codec.language.ColognePhonetic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/dicionario")
public class DicionarioRestController {

    private static final Logger logger = LoggerFactory.getLogger(DicionarioRestController.class);

    private final VariacaoOrtograficaRepository variacaoRepo;
    private final TraducaoRepository traducaoRepo;
    private final ColognePhonetic cologne;

    public DicionarioRestController(VariacaoOrtograficaRepository variacaoRepo,
                                    TraducaoRepository traducaoRepo,
                                    ColognePhonetic cologne) {
        this.variacaoRepo = variacaoRepo;
        this.traducaoRepo = traducaoRepo;
        this.cologne = cologne;
    }

    @GetMapping("/sugerir")
    public List<String> sugerir(@RequestParam String termo,
                                @RequestParam(required = false, defaultValue = "de") String idioma) {
        if (termo == null) return Collections.emptyList();
        termo = termo.toLowerCase().trim();
        if (termo.isEmpty()) return Collections.emptyList();

        List<String> sugestoes = new ArrayList<>();

        if ("pt".equalsIgnoreCase(idioma)) {
            // Primeiro: buscar por traduções que contenham o termo (sugestões em português)
            List<Traducao> traducoesPesquisa = traducaoRepo.findByTextoTraducaoContainingIgnoreCase(termo);
            if (!traducoesPesquisa.isEmpty()) {
                for (Traducao t : traducoesPesquisa) {
                    if (t.getTextoTraducao() != null) {
                        sugestoes.add(t.getTextoTraducao().trim());
                    }
                    if (sugestoes.size() >= 10) break;
                }
                List<String> finalList = sugestoes.stream().distinct().limit(10).collect(Collectors.toList());
                logger.info("Sugestões (traducoes-prioridade) para idioma='{}' e termo='{}': {}", idioma, termo, finalList);
                return finalList;
            }

            // fallback para fonética (tenta encontrar verbetes/variacoes foneticamente semelhantes)
            String codigo = cologne.encode(termo);
            List<VariacaoOrtografica> foneticas = variacaoRepo.findByCodigoFonetico(codigo);
            sugestoes = foneticas.stream()
                    .map(VariacaoOrtografica::getGrafiaAlternativa)
                    .map(String::trim)
                    .distinct()
                    .limit(10)
                    .collect(Collectors.toList());
            if (!sugestoes.isEmpty()) {
                logger.info("Sugestões (fonetic-fallback) para idioma='{}' e termo='{}': {}", idioma, termo, sugestoes);
                return sugestoes;
            }

            // último recurso: grafias relacionadas por verbete
            List<Traducao> traducoes = traducaoRepo.findByTextoTraducaoContainingIgnoreCase(termo);
            if (!traducoes.isEmpty()) {
                List<String> fromTraducoes = new ArrayList<>();
                for (Traducao t : traducoes) {
                    if (t.getVerbete() == null) continue;
                    Integer vid = t.getVerbete().getId();
                    List<VariacaoOrtografica> variacoes = variacaoRepo.findAllByVerbeteId(vid);
                    String grafia = variacoes.stream()
                            .filter(v -> Boolean.TRUE.equals(v.getIsPrincipal()))
                            .map(VariacaoOrtografica::getGrafiaAlternativa)
                            .findFirst()
                            .orElseGet(() -> variacoes.isEmpty() ? null : variacoes.get(0).getGrafiaAlternativa());
                    if (grafia != null) fromTraducoes.add(grafia.trim());
                    if (fromTraducoes.size() >= 10) break;
                }
                List<String> finalList = fromTraducoes.stream().distinct().collect(Collectors.toList());
                logger.info("Sugestões (traducoes->grafia) para idioma='{}' e termo='{}': {}", idioma, termo, finalList);
                return finalList;
            }

            return Collections.emptyList();
        }

        // idioma != pt (ex: 'de'): prioriza grafias (autocomplete)
        List<VariacaoOrtografica> prefix = variacaoRepo.findByGrafiaAlternativaStartingWithIgnoreCase(termo);
        for (VariacaoOrtografica vo : prefix) {
            sugestoes.add(vo.getGrafiaAlternativa().trim());
            if (sugestoes.size() >= 10) break;
        }
        sugestoes = sugestoes.stream().distinct().limit(10).collect(Collectors.toList());
        if (!sugestoes.isEmpty()) {
            logger.info("Sugestões (grafia-prioridade) para idioma='{}' e termo='{}': {}", idioma, termo, sugestoes);
            return sugestoes;
        }

        // fonética como fallback para outros idiomas
        String codigo = cologne.encode(termo);
        List<VariacaoOrtografica> foneticas = variacaoRepo.findByCodigoFonetico(codigo);
        sugestoes = foneticas.stream()
                .map(VariacaoOrtografica::getGrafiaAlternativa)
                .map(String::trim)
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
        if (!sugestoes.isEmpty()) {
            logger.info("Sugestões (fonetic) para idioma='{}' e termo='{}': {}", idioma, termo, sugestoes);
            return sugestoes;
        }

        return Collections.emptyList();
    }

}
