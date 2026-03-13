package br.com.hunsriqueano.libelle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hunsriqueano.libelle.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Usuario> findByTokenVerificacao(String tokenVerificacao);

    @Modifying
    @Transactional
    @Query(value = """
    DELETE FROM usuario
    WHERE email_verificado = 0
    AND data_cadastro < NOW() - INTERVAL 1 DAY
    """, nativeQuery = true)
    void deletarUsuariosNaoConfirmados();
}