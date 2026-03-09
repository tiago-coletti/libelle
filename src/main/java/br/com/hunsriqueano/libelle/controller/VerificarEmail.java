package br.com.hunsriqueano.libelle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.repository.UsuarioRepository;

@Controller
public class VerificarEmail {

    private final UsuarioRepository repository;

    public VerificarEmail(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/verificar-email")
    public String verificarEmail(@RequestParam String token) {

        Usuario usuario = repository.findByTokenVerificacao(token);

        if (usuario != null) {
            usuario.setEmailVerificado(true);
            usuario.setTokenVerificacao(null);

            repository.save(usuario);
        }

        return "email-confirmado";
    }
}