package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import br.com.hunsriqueano.libelle.repository.VariacaoOrtograficaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariacaoOrtograficaService {

    private final VariacaoOrtograficaRepository repository;

    public VariacaoOrtograficaService(VariacaoOrtograficaRepository repository) {
        this.repository = repository;
    }

    public List<VariacaoOrtografica> listarTodos() {
        return repository.findAll();
    }

    public Optional<VariacaoOrtografica> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public VariacaoOrtografica salvar(VariacaoOrtografica variacao) {
        return repository.save(variacao);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}