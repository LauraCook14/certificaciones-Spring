package com.example.certificaciones.modelo;
import javax.persistence.*;


@Entity
@Table(name="cursos")
public class CursoA {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
   private int id;

   private String nombrecurso;
   private String url;
   private String descripcion;

    public CursoA() {

    }

    public int getIdCurso() {
        return id;
    }

    public void setIdCurso(int idCurso) {
        this.id = idCurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombreCurso) {
        this.nombrecurso = nombreCurso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
