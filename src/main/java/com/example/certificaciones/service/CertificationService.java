package com.example.certificaciones.service;

import com.example.certificaciones.modelo.Curso;
import com.example.certificaciones.modelo.CursoA;

import java.util.List;
import java.util.Map;

public interface CertificationService {

    public List<Curso> getCursos();
    
    public String insertCurso(Map<String,String> curso);
    
    public int deleteCurso(int idCurso);
    
    public String updateCurso(Map<String,String> newCurso);
    
    public List<CursoA> getListCursos();
    
    public CursoA getCursoById(int idCurso);

}
