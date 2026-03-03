package br.com.hunsriqueano.libelle.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.repository.OrtografiaRepository;

@Controller
public class CadastroController {

    private final OrtografiaRepository ortografiaRepository;

    public CadastroController(OrtografiaRepository ortografiaRepository) {
        this.ortografiaRepository = ortografiaRepository;
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("ortografias", ortografiaRepository.findAll());
        return "cadastro";
    }
}