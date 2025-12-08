package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "traducao")
public class Traducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "verbete_id", nullable = false)
    private Verbete verbete;

    @Column(name = "texto_traducao", nullable = false)
    private String textoTraducao;

    @Column(name = "contexto", length = 100)
    private String contexto;

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

    public String getTextoTraducao() {
        return textoTraducao;
    }

    public void setTextoTraducao(String textoTraducao) {
        this.textoTraducao = textoTraducao;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}