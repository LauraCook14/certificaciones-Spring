package com.example.certicaciones.service;

import com.example.certificaciones.modelo.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CertificationService {

    public List<Curso> getCursos();

}
