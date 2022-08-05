package com.example.certificaciones.controller;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
           throw new RuntimeException();
       }
       return curso.toString();
    }

}
