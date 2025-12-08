package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Audio;
import br.com.hunsriqueano.libelle.repository.AudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudioService {

    private final AudioRepository repository;

    public AudioService(AudioRepository repository) {
        this.repository = repository;
    }

    public List<Audio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Audio> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Audio salvar(Audio audio) {
        return repository.save(audio);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}