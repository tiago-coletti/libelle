package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Exemplo;
import br.com.hunsriqueano.libelle.repository.ExemploRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemploService {

    private final ExemploRepository repository;

    public ExemploService(ExemploRepository repository) {
        this.repository = repository;
    }

    public List<Exemplo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Exemplo> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Exemplo salvar(Exemplo exemplo) {
        return repository.save(exemplo);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}