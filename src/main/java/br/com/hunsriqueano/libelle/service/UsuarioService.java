package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null && repository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este e-mail.");
        }
        return repository.save(usuario);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}