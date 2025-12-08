package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Localidade;
import br.com.hunsriqueano.libelle.repository.LocalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    private final LocalidadeRepository repository;

    public LocalidadeService(LocalidadeRepository repository) {
        this.repository = repository;
    }

    public List<Localidade> listarTodos() {
        return repository.findAll();
    }

    public Optional<Localidade> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Localidade salvar(Localidade localidade) {
        return repository.save(localidade);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}