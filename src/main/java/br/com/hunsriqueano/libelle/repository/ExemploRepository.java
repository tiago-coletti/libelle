package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Exemplo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemploRepository extends JpaRepository<Exemplo, Integer> {
}