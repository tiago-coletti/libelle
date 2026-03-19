package br.com.hunsriqueano.libelle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailVerificacao(String email, String codigo) {

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(email);
        mensagem.setSubject("🔐 Código de verificação - Libelle");

        mensagem.setText(
            "Olá!\n\n" +

            "Seja bem-vindo ao Libelle 📚\n\n" +

            "Use o código abaixo para verificar seu e-mail:\n\n" +

            "━━━━━━━━━━━━━━━━━━━\n" +
            "   CÓDIGO: " + codigo + "\n" +
            "━━━━━━━━━━━━━━━━━━━\n\n" +

            "Digite esse código na tela de verificação.\n\n" +

            "⚠️ Este código expira em alguns minutos.\n\n" +

            "Se você não criou uma conta, ignore este e-mail.\n\n" +

            "— Equipe Libelle"
        );

        mailSender.send(mensagem);
    }
}