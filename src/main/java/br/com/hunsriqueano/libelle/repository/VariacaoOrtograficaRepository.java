package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariacaoOrtograficaRepository extends JpaRepository<VariacaoOrtografica, Integer> {
}