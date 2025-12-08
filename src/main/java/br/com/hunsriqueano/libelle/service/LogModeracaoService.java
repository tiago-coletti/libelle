package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.AcaoModeracao;
import br.com.hunsriqueano.libelle.entity.LogModeracao;
import br.com.hunsriqueano.libelle.entity.TipoAlvo;
import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.repository.LogModeracaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogModeracaoService {

    private final LogModeracaoRepository repository;

    public LogModeracaoService(LogModeracaoRepository repository) {
        this.repository = repository;
    }

    public List<LogModeracao> listarHistorico() {
        return repository.findAll();
    }

    public void registrarAcao(Usuario moderador, AcaoModeracao acao, TipoAlvo tipo, Integer idAlvo) {
        LogModeracao log = new LogModeracao();
        log.setUsuarioModerador(moderador);
        log.setAcao(acao);
        log.setTipoAlvo(tipo);
        log.setIdAlvo(idAlvo);
        repository.save(log);
    }
}