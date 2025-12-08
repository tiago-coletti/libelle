package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ortografia")
public class Ortografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_sistema", nullable = false, unique = true, length = 100)
    private String nomeSistema;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}