package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariacaoOrtograficaRepository extends JpaRepository<VariacaoOrtografica, Integer> {

    List<VariacaoOrtografica> findByCodigoFonetico(String codigoFonetico);

    List<VariacaoOrtografica> findByGrafiaAlternativa(String grafia);

    @Query("SELECT v FROM VariacaoOrtografica v JOIN FETCH v.ortografia WHERE v.verbete.id = :verbeteId")
    List<VariacaoOrtografica> findAllByVerbeteId(@Param("verbeteId") Integer verbeteId);

    // Busca por prefixo (autocomplete) ignorando maiúsculas/minúsculas
    List<VariacaoOrtografica> findByGrafiaAlternativaStartingWithIgnoreCase(String prefix);

}