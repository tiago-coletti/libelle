package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_moderacao")
public class LogModeracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_moderador_id",  nullable = false)
    private Usuario usuarioModerador;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_alvo", nullable = false)
    private TipoAlvo tipoAlvo;

    @Column(name = "id_alvo", nullable = false)
    private Integer idAlvo;

    @Enumerated(EnumType.STRING)
    @Column(name = "acao", nullable = false)
    private AcaoModeracao acao;

    @Column(name = "data_acao", insertable = false, updatable = false)
    private LocalDateTime dataAcao;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Usuario getUsuarioModerador() {
        return usuarioModerador;
    }

    public void setUsuarioModerador(Usuario usuarioAutor) {
        this.usuarioModerador = usuarioAutor;
    }

    public TipoAlvo getTipoAlvo() {
        return tipoAlvo;
    }

    public void setTipoAlvo(TipoAlvo tipoAlvo) {
        this.tipoAlvo = tipoAlvo;
    }

    public Integer getIdAlvo() {
        return idAlvo;
    }

    public void setIdAlvo(Integer idAlvo) {
        this.idAlvo = idAlvo;
    }

    public AcaoModeracao getAcao() {
        return acao;
    }

    public void setAcao(AcaoModeracao acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(LocalDateTime dataAcao) {
        this.dataAcao = dataAcao;
    }
}
