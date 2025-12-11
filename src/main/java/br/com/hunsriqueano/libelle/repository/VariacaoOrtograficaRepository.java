package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariacaoOrtograficaRepository extends JpaRepository<VariacaoOrtografica, Integer> {

    List<VariacaoOrtografica> findByCodigoFonetico(String codigoFonetico);

}