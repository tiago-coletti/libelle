package br.com.hunsriqueano.libelle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Usuario usuario,
                            Model model) {
        try {
            service.cadastrar(usuario);
            return "redirect:/cadastro?sucesso";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
            return "cadastro";
        }
    }
}