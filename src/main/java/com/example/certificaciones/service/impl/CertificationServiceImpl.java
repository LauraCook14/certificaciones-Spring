package com.example.certificaciones.service.impl;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.controller.CertificationController;
import com.example.certificaciones.modelo.Curso;
import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.CursoRepositorio;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
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
  
	@Override
	public int deleteCurso(int idCurso) {
	  return cursorepositorio.deleteCurso(idCurso);
	}

	@Override
	public void updateCurso(Map<String,String> newCurso) {
		CursoA curso = new CursoA(); 
		if(newCurso.get("id")!=null) {
			curso = getCursoById(Integer.valueOf(newCurso.get("id")));
			if(!curso.equals(newCurso)) {
				if(newCurso.containsKey("nombre")) curso.setNombreCurso(newCurso.get("nombre"));
				if(newCurso.containsKey("url")) curso.setUrl(newCurso.get("url"));
				if(newCurso.containsKey("descripcion")) curso.setDescripcion(newCurso.get("descripcion"));
				cursorepositorio.updateCurso(curso);
			}else {
				log.error("No hay cambios en el registro");
			}
			
		}else {
			log.info("Missing param {id}");
		}
		
	}

	@Override
	public List<CursoA> getListCursos() {
		List<CursoA> listaCursos = new ArrayList<>();
		listaCursos = cursorepositorio.getListCursos();
		return listaCursos;
	}

	@Override
	public CursoA getCursoById(int idCurso) {
		CursoA curso = new CursoA();
		curso = cursorepositorio.getCursoById(idCurso);
		return curso;
	}

	@Override
	public String insertCurso(Map<String,String> curso) {
		CursoA nuevocurso = new CursoA();
		try {
			nuevocurso.setNombreCurso(curso.get("nombre"));
	        nuevocurso.setUrl(curso.get("url"));
	        nuevocurso.setDescripcion(curso.get("descripcion"));
		}catch(Exception e) {
			log.error("Error de parametros",e.getStackTrace());
		}
        return cursorepositorio.insertarCurso(nuevocurso);
	}
}
