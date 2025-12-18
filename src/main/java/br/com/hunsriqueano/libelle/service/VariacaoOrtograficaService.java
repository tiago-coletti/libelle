package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Exemplo;
import br.com.hunsriqueano.libelle.entity.Traducao;
import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import br.com.hunsriqueano.libelle.entity.Verbete;
import br.com.hunsriqueano.libelle.repository.ExemploRepository;
import br.com.hunsriqueano.libelle.repository.TraducaoRepository;
import br.com.hunsriqueano.libelle.repository.VariacaoOrtograficaRepository;
import org.apache.commons.codec.language.ColognePhonetic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariacaoOrtograficaService {

    private final VariacaoOrtograficaRepository variacaoRepo;
    private final TraducaoRepository traducaoRepo;
    private final ExemploRepository exemploRepo;
    private final ColognePhonetic algoritmoFonetico;

    public VariacaoOrtograficaService(VariacaoOrtograficaRepository variacaoRepo,
                                      TraducaoRepository traducaoRepo,
                                      ExemploRepository exemploRepo,
                                      ColognePhonetic algoritmoFonetico) {
        this.variacaoRepo = variacaoRepo;
        this.traducaoRepo = traducaoRepo;
        this.exemploRepo = exemploRepo;
        this.algoritmoFonetico = algoritmoFonetico;
    }

    public Verbete buscarVerbete(String termo) {
        if (termo == null || termo.trim().isEmpty()) return null;

        List<VariacaoOrtografica> exatas = variacaoRepo.findByGrafiaAlternativa(termo);
        if (!exatas.isEmpty()) {
            return exatas.get(0).getVerbete();
        }

        String codigo = algoritmoFonetico.encode(termo);
        List<VariacaoOrtografica> aproximadas = variacaoRepo.findByCodigoFonetico(codigo);
        if (!aproximadas.isEmpty()) {
            return aproximadas.get(0).getVerbete();
        }

        List<Traducao> traducoes = traducaoRepo.findByTextoTraducaoContainingIgnoreCase(termo);
        if (!traducoes.isEmpty()) {
            return traducoes.get(0).getVerbete();
        }

        return null;
    }

    public List<Traducao> buscarTraducoesDoVerbete(Integer verbeteId) {
        return traducaoRepo.findByVerbeteId(verbeteId);
    }

    public List<Exemplo> buscarExemplosDoVerbete(Integer verbeteId) {
        return exemploRepo.findByVerbeteId(verbeteId);
    }

    public List<VariacaoOrtografica> buscarVariacoesDoVerbete(Integer verbeteId) {
        return variacaoRepo.findAllByVerbeteId(verbeteId);
    }
}