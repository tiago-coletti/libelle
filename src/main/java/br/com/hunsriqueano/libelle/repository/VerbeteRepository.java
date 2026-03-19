package br.com.hunsriqueano.libelle.repository;

import br.com.hunsriqueano.libelle.entity.Verbete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VerbeteRepository extends JpaRepository<Verbete, Integer> {
    // Busca verbetes por grafia alternativa (prefixo) via VariacaoOrtografica.grafiaAlternativa
    @Query("SELECT vo.verbete FROM VariacaoOrtografica vo WHERE LOWER(vo.grafiaAlternativa) LIKE LOWER(CONCAT(:prefix, '%'))")
    List<Verbete> findByGrafiaAlternativaStartingWith(@Param("prefix") String prefix);
}