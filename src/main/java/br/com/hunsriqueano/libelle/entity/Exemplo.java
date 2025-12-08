package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exemplo")
public class Exemplo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "verbete_id", nullable = false)
    private Verbete verbete;

    @ManyToOne
    @JoinColumn(name = "usuario_autor_id",  nullable = false)
    private Usuario usuarioAutor;

    @Column(name = "texto_original", nullable = false, columnDefinition = "TEXT")
    private String textoOriginal;

    @Column(name = "texto_traducao", columnDefinition = "TEXT")
    private String textoTraducao;

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

    public Verbete getVerbete() {
        return verbete;
    }

    public void setVerbete(Verbete verbete) {
        this.verbete = verbete;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoTraducao() {
        return textoTraducao;
    }

    public void setTextoTraducao(String textoTraducao) {
        this.textoTraducao = textoTraducao;
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
