package com.example.certificaciones.service.impl;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.Curso;
import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificationServiceImpl implements CertificationService {
   @Autowired
    CursoRepositorio cursorepositorio;

  @Override
    public List<Curso> getCursos() {
        List<Curso> listaCurso = new ArrayList<>();
      try{
          listaCurso.add(new Curso(1, "Curso para tomar curso", "https://softitlan.com/taskmanager/login/", "Bienvenido al curso, ya no seras calvo" ));
          listaCurso.add(new Curso(2, "Curso para tomar curso 2.0", "https://softitlan.com/taskmanager/login/", "Bienvenido al curso, ya no seras calvo" ));
          if (listaCurso.equals(null) ){
              throw new Exception("No hay, no existen datos");
          }
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
        return listaCurso;
    }

    public String insertCurso (){
        CursoA nuevocurso = new CursoA();

        nuevocurso.setNombrecurso("Curso para tomar curso");
        nuevocurso.setDescripcion("Bienvenido al curso, ya no seras calvo" );
        nuevocurso.setUrl("https://softitlan.com/taskmanager/login/");

        return cursorepositorio.insertarCurso(nuevocurso);
    }
}
