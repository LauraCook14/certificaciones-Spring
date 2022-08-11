package com.example.certificaciones.repositorio;

import com.example.certificaciones.modelo.CursoA;

import java.util.List;

public interface CursoRepositorio {

    List<CursoA> listaCurso();

    String insertarCurso (CursoA curso);
}
