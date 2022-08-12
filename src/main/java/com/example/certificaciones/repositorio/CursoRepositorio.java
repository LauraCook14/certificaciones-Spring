package com.example.certificaciones.repositorio;

import com.example.certificaciones.modelo.CursoA;

import java.util.List;
import java.util.Map;

public interface CursoRepositorio {

    List<CursoA> listaCurso();

    String insertarCurso (CursoA curso);
    
    int deleteCurso(int idCurso);
    
    String updateCurso(CursoA curso);
    
    List<CursoA> getListCursos();
    
    CursoA getCursoById(int idCurso);
}
