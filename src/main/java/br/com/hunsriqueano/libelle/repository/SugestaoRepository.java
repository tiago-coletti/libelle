package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Integer> {
}