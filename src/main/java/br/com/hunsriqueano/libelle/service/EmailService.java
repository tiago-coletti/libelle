package br.com.hunsriqueano.libelle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailVerificacao(String email, String token) {

        String link = "http://paraverificar/verificar-email?token=" + token;

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(email);
        mensagem.setSubject("Verificação de conta - Libelle");
        mensagem.setText(
                "Bem-vindo ao Libelle!\n\n" +
                "Clique no link abaixo para confirmar seu e-mail:\n\n" +
                link + "\n\n" +
                "Se você não criou esta conta, ignore este e-mail."
        );

        mailSender.send(mensagem);
    }
}