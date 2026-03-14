package br.com.hunsriqueano.libelle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VerificacaoController {

    @GetMapping("/verificar_email")
    public String verificarEmail() {
        return "verificar_email";
    }

}