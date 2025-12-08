package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Traducao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraducaoRepository extends JpaRepository<Traducao, Integer> {
}