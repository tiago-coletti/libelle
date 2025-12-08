package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Traducao;
import br.com.hunsriqueano.libelle.repository.TraducaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraducaoService {

    private final TraducaoRepository repository;

    public TraducaoService(TraducaoRepository repository) {
        this.repository = repository;
    }

    public List<Traducao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Traducao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Traducao salvar(Traducao traducao) {
        return repository.save(traducao);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}