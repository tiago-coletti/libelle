package br.com.hunsriqueano.libelle.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "verbete")
public class Verbete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "classe_gramatical", length = 50)
    private String classeGramatical;

    @Column(name = "genero", length = 10)
    private String genero;

    @Column(name = "notas_linguisticas", columnDefinition = "TEXT")
    private String notasLinguisticas;

    @ManyToMany
    @JoinTable(
            name = "audio_verbete",
            joinColumns = @JoinColumn(name = "verbete_id"),
            inverseJoinColumns = @JoinColumn(name = "audio_id")
    )
    private List<Audio> audios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasseGramatical() {
        return classeGramatical;
    }

    public void setClasseGramatical(String classeGramatical) {
        this.classeGramatical = classeGramatical;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNotasLinguisticas() {
        return notasLinguisticas;
    }

    public void setNotasLinguisticas(String notasLinguisticas) {
        this.notasLinguisticas = notasLinguisticas;
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }
}