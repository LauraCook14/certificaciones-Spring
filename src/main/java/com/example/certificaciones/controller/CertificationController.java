package com.example.certificaciones.controller;

import com.example.certicaciones.service.CertificationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CertificationController")

public class CertificationController {

    CertificationService certificationService;

    @GetMapping("/getCourses")

    public String getCourses(){

    }

}
