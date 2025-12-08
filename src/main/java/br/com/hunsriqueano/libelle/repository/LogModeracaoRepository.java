package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.LogModeracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogModeracaoRepository extends JpaRepository<LogModeracao, Integer> {
}