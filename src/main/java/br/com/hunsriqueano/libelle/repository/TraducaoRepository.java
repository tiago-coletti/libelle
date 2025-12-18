package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Traducao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraducaoRepository extends JpaRepository<Traducao, Integer> {
    List<Traducao> findByVerbeteId(Integer verbeteId);

    List<Traducao> findByTextoTraducaoContainingIgnoreCase(String termo);
}