package br.com.hunsriqueano.libelle.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.hunsriqueano.libelle.repository.UsuarioRepository;

@Service
public class LimpezaUsuarioService {

    private final UsuarioRepository repository;

    public LimpezaUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 0 * * * *") // roda a cada 1 hora
    public void limparUsuariosNaoConfirmados() {

        repository.deletarUsuariosNaoConfirmados();
    }
}