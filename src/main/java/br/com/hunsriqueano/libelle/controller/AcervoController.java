package br.com.hunsriqueano.libelle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hunsriqueano.libelle.service.UsuarioService;

@Controller
public class AcervoController {
    private final UsuarioService service;

        public AcervoController (UsuarioService service) {
        this.service = service;
    } 

        @GetMapping("/acervo")
        public String paginaBusca() {
            return "acervo";
    }

}
