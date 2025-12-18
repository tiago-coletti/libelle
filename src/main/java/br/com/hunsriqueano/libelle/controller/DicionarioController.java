package br.com.hunsriqueano.libelle.controller;

import br.com.hunsriqueano.libelle.entity.Exemplo;
import br.com.hunsriqueano.libelle.entity.Traducao;
import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import br.com.hunsriqueano.libelle.entity.Verbete;
import br.com.hunsriqueano.libelle.service.VariacaoOrtograficaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DicionarioController {

    private final VariacaoOrtograficaService service;

    public DicionarioController(VariacaoOrtograficaService service) {
        this.service = service;
    }

    @GetMapping("/dicionario")
    public String paginaBusca() {
        return "dicionario";
    }

    @GetMapping("/resultado")
    public String pesquisar(@RequestParam("q") String query, Model model) {
        Verbete verbete = service.buscarVerbete(query);

        if (verbete == null) {
            return "redirect:/dicionario?error=notfound";
        }

        List<Traducao> traducoes = service.buscarTraducoesDoVerbete(verbete.getId());
        List<Exemplo> exemplos = service.buscarExemplosDoVerbete(verbete.getId());
        List<VariacaoOrtografica> variacoes = service.buscarVariacoesDoVerbete(verbete.getId());

        model.addAttribute("verbete", verbete);
        model.addAttribute("exemplos", exemplos);

        if (!traducoes.isEmpty()) {
            model.addAttribute("traducaoPrincipal", traducoes.get(0).getTextoTraducao());
        } else {
            model.addAttribute("traducaoPrincipal", "Sem tradução");
            model.addAttribute("definicao", "Definição não disponível.");
        }

        Map<String, String> mapaOrtografia = new HashMap<>();
        String palavraPadrao = query;

        for (VariacaoOrtografica vo : variacoes) {
            String sistema = vo.getOrtografia().getNomeSistema();
            mapaOrtografia.put(sistema, vo.getGrafiaAlternativa());

            if (vo.getIsPrincipal()) {
                palavraPadrao = vo.getGrafiaAlternativa();
            }
        }

        model.addAttribute("palavraPrincipal", palavraPadrao);
        model.addAttribute("mapaOrtografia", mapaOrtografia);

        return "resultado";
    }
}