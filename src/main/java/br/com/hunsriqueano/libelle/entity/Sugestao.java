package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sugestao")
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sugestao", nullable = false)
    private TipoSugestao tipoSugestao;

    @ManyToOne
    @JoinColumn(name = "verbete_id_associado")
    private Verbete verbeteAssociado;

    @Column(name = "texto_principal", nullable = false)
    private String textoPrincipal;

    @Column(name = "texto_secundario")
    private String textoSecundario;

    @Column(name = "contexto_sugestao", columnDefinition = "TEXT")
    private String contextoSugestao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_moderacao", nullable = false)
    private StatusModeracao statusModeracao = StatusModeracao.PENDENTE;

    @Column(name = "data_envio", insertable = false, updatable = false)
    private LocalDateTime dataEnvio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoSugestao getTipoSugestao() {
        return tipoSugestao;
    }

    public void setTipoSugestao(TipoSugestao tipoSugestao) {
        this.tipoSugestao = tipoSugestao;
    }

    public Verbete getVerbeteAssociado() {
        return verbeteAssociado;
    }

    public void setVerbeteAssociado(Verbete verbeteAssociado) {
        this.verbeteAssociado = verbeteAssociado;
    }

    public String getTextoPrincipal() {
        return textoPrincipal;
    }

    public void setTextoPrincipal(String textoPrincipal) {
        this.textoPrincipal = textoPrincipal;
    }

    public String getTextoSecundario() {
        return textoSecundario;
    }

    public void setTextoSecundario(String textoSecundario) {
        this.textoSecundario = textoSecundario;
    }

    public String getContextoSugestao() {
        return contextoSugestao;
    }

    public void setContextoSugestao(String contextoSugestao) {
        this.contextoSugestao = contextoSugestao;
    }

    public StatusModeracao getStatusModeracao() {
        return statusModeracao;
    }

    public void setStatusModeracao(StatusModeracao statusModeracao) {
        this.statusModeracao = statusModeracao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}