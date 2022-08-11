package com.example.certificaciones.controller;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.Curso;

import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/CertificationController")

public class CertificationController {
	
	Logger log = Logger.getLogger("MyLog");
    @Autowired
    CertificationService certificationService;

    @GetMapping("/getCourses")
    public String getCursos(){
       List<Curso> curso = null;
       try{
           curso = certificationService.getCursos();
       } catch (Exception e){
           log.warning(e.getMessage());
       }
       return curso.toString();
    }

    @PostMapping("/insertCurso")
    public String insertCurso(){

        String mensaje ="Sin ejecutar";

        try{
            mensaje = certificationService.insertCurso();
        } catch (Exception e){
        	log.warning(e.getMessage());
        }
          return mensaje;
    }

}
