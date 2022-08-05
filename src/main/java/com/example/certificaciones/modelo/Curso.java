package com.example.certificaciones.modelo;

public class Curso {
    private int Id;
    private String nombreCurso;
    private String url;
    private String descripcionCurso;

    public Curso(int id, String nombreCurso, String url, String descripcionCurso) {
        Id = id;
        this.nombreCurso = nombreCurso;
        this.url = url;
        this.descripcionCurso = descripcionCurso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Id=" + Id +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", url='" + url + '\'' +
                ", descripcionCurso='" + descripcionCurso + '\'' +
                '}';
    }
}
