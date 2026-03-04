package br.com.hunsriqueano.libelle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hunsriqueano.libelle.entity.NivelAcesso;
import br.com.hunsriqueano.libelle.entity.Usuario;
import br.com.hunsriqueano.libelle.repository.OrtografiaRepository;
import br.com.hunsriqueano.libelle.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final OrtografiaRepository ortografiaRepository;

    public UsuarioService(UsuarioRepository repository,
                        PasswordEncoder passwordEncoder,
                        OrtografiaRepository ortografiaRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.ortografiaRepository = ortografiaRepository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario cadastrar(Usuario usuario) {

        if (usuario.getId() != null) {
            throw new IllegalArgumentException("Para cadastrar, o ID deve ser nulo.");
        }

        if (repository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este e-mail.");
        }

        if (usuario.getSenhaHash() == null || usuario.getSenhaHash().isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }

        if (usuario.getPreferenciaOrtografia() == null 
            || usuario.getPreferenciaOrtografia().getId() == null) {
            throw new IllegalArgumentException("Selecione uma preferência ortográfica.");
        }

        var ortografia = ortografiaRepository
                .findById(usuario.getPreferenciaOrtografia().getId())
                .orElseThrow(() -> 
                    new IllegalArgumentException("Ortografia inválida.")
                );

        usuario.setPreferenciaOrtografia(ortografia);

        usuario.setNivelAcesso(NivelAcesso.USUARIO);

        String senhaPura = usuario.getSenhaHash();
        usuario.setSenhaHash(passwordEncoder.encode(senhaPura));

        return repository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario usuarioDadosNovos) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        usuarioExistente.setNomeCompleto(usuarioDadosNovos.getNomeCompleto());
        usuarioExistente.setLocalidade(usuarioDadosNovos.getLocalidade());
        usuarioExistente.setAnoNascimento(usuarioDadosNovos.getAnoNascimento());
        usuarioExistente.setPreferenciaOrtografia(usuarioDadosNovos.getPreferenciaOrtografia());

        String novaSenha = usuarioDadosNovos.getSenhaHash();

        if (novaSenha != null && !novaSenha.isEmpty()) {
            usuarioExistente.setSenhaHash(passwordEncoder.encode(novaSenha));
        }
        return repository.save(usuarioExistente);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}