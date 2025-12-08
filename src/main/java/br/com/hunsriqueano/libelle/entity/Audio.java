package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audio")
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_autor_id", nullable = false)
    private Usuario usuarioAutor;

    @Column(name = "caminho_arquivo", nullable = false, unique = true)
    private String caminhoArquivo;

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

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
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