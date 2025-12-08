package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Verbete;
import br.com.hunsriqueano.libelle.repository.VerbeteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VerbeteService {

    private final VerbeteRepository repository;

    public VerbeteService(VerbeteRepository repository) {
        this.repository = repository;
    }

    public List<Verbete> listarTodos() {
        return repository.findAll();
    }

    public Optional<Verbete> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Verbete salvar(Verbete verbete) {
        return repository.save(verbete);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}