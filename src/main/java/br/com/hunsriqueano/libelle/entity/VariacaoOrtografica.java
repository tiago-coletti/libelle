package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "variacao_ortografica")
public class VariacaoOrtografica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "verbete_id", nullable = false)
    private Verbete verbete;

    @ManyToOne
    @JoinColumn(name = "ortografia_id", nullable = false)
    private Ortografia ortografia;

    @Column(name = "grafia_alternativa", nullable = false)
    private String grafiaAlternativa;

    @Column(name = "is_principal", nullable = false)
    private Boolean isPrincipal = false;

    @Column(name = "codigo_fonetico")
    private String codigoFonetico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Verbete getVerbete() {
        return verbete;
    }

    public void setVerbete(Verbete verbete) {
        this.verbete = verbete;
    }

    public Ortografia getOrtografia() {
        return ortografia;
    }

    public void setOrtografia(Ortografia ortografia) {
        this.ortografia = ortografia;
    }

    public String getGrafiaAlternativa() {
        return grafiaAlternativa;
    }

    public void setGrafiaAlternativa(String grafiaAlternativa) {
        this.grafiaAlternativa = grafiaAlternativa;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public String getCodigoFonetico() {
        return codigoFonetico;
    }

    public void setCodigoFonetico(String codigoFonetico) {
        this.codigoFonetico = codigoFonetico;
    }
}