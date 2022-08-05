package com.example.certificaciones.service.impl;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificationServiceImpl implements CertificationService {
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
}
