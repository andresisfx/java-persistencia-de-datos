package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
@Entity //le dice a java que con este modelo se va a crear una tabla
@Table(name="series")// con esto le cambiamos el nombe a la tabla si queremos sino se podra por defecto el nobre de la clase
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;

    private Integer totalTemporadas;
    private Double evaluacion;
    private String poster;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String actores;
    private String sinopsis;
    @Transient //ignora la realciones con episodios
    private List<Episodio>episodios;
    public Serie(DatosSerie datosSeries) {
        this.titulo= datosSeries.titulo();
        this.totalTemporadas=datosSeries.totalTemporadas();
        this.evaluacion= OptionalDouble.of(Double.valueOf(datosSeries.evaluacion())).orElse(0);
        this.poster=datosSeries.poster();
        this.genero=Categoria.fromString(datosSeries.genero().split(",")[0].trim());
        this.actores= datosSeries.actores();
        this.sinopsis=datosSeries.sinopsis();


    }

    @Override
    public String toString() {
        return  ", genero= " + genero +
                "  titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'';

    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
