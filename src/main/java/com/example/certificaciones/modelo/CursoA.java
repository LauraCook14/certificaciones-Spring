package com.example.certificaciones.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cursos")
public class CursoA {
   @Id
   @Column(nullable = true)
   private Integer idCurso;

   @Column(name = "nombreCurso")
   private String nombreCurso;
   private String url;
   private String descripcion;

    public CursoA() {

    }



    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CursoA(Integer idCurso, String nombreCurso, String url, String descripcion) {
        this.idCurso = idCurso; 
        this.nombreCurso = nombreCurso;
        this.url = url;
        this.descripcion = descripcion;
    }
}
