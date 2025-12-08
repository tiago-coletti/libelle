package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Ortografia;
import br.com.hunsriqueano.libelle.repository.OrtografiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtografiaService {

    private final OrtografiaRepository repository;

    public OrtografiaService(OrtografiaRepository repository) {
        this.repository = repository;
    }

    public List<Ortografia> listarTodos() {
        return repository.findAll();
    }

    public Optional<Ortografia> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Ortografia salvar(Ortografia ortografia) {
        return repository.save(ortografia);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}