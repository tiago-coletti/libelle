package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Ortografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtografiaRepository extends JpaRepository<Ortografia, Integer> {
}