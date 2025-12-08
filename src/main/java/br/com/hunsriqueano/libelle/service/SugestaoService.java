package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Sugestao;
import br.com.hunsriqueano.libelle.repository.SugestaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SugestaoService {

    private final SugestaoRepository repository;

    public SugestaoService(SugestaoRepository repository) {
        this.repository = repository;
    }

    public List<Sugestao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Sugestao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Sugestao salvar(Sugestao sugestao) {
        return repository.save(sugestao);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}