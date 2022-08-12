package com.example.certificaciones.controller;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.Curso;
import com.example.certificaciones.modelo.CursoA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/CertificationController")
public class CertificationController {

    @Autowired
    CertificationService certificationService;

    @GetMapping("/getCourses")
    public String getCursos(){
       List<Curso> curso = null;
       try{
           curso = certificationService.getCursos();
       } catch (Exception e){
    	   log.error("Error al obtener cursos", e.getMessage());
       }
       return curso.toString();
    }

    @PostMapping("/insertCurso")
    public String insertCurso(@RequestBody Map<String,String> curso){

        String mensaje ="Sin ejecutar";

        try{
            mensaje = certificationService.insertCurso(curso);
            log.info("Éxito >>>>", mensaje);
        } catch (Exception e){
        	log.error("Error al obtener cursos: >>>>>> {}",e.getMessage());
        }
          return mensaje;
    }
    
    @GetMapping("/getCursoById")
    public CursoA getCursoById(@RequestParam(value = "id") int idCurso){
    	CursoA curso = new CursoA();
    	curso = certificationService.getCursoById(idCurso);
    	return curso;    	
    }
    
    @GetMapping("/getListCursos")
    public List<CursoA> getListCursos(){
    	List<CursoA> listaCursos = new ArrayList<>();
    	listaCursos = certificationService.getListCursos();
    	return listaCursos;
    }
    
    @PostMapping("/updateCurso")
    public void updateCurso(@RequestBody Map<String,String> newCurso) {
    	certificationService.updateCurso(newCurso);
    }

    @GetMapping("/deleteCurso")
    public int deleteCurso(@RequestParam(value = "id") int idCurso){
        return  certificationService.deleteCurso(idCurso);
    }

}
