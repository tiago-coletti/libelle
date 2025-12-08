package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Verbete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerbeteRepository extends JpaRepository<Verbete, Integer> {
}