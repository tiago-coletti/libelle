package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "localidade")
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "estado", nullable = false,  length = 2)
    private String estado;

    @Column(name = "latitude", precision = 10, scale = 8)
    private String latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private String longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_aprovacao", nullable = false)
    private StatusModeracao statusAprovacao = StatusModeracao.PENDENTE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public StatusModeracao getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setStatusAprovacao(StatusModeracao statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }
}
