package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Integer> {
}