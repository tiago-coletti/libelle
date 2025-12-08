package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
}