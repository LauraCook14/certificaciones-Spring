package com.example.certificaciones.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.CursoA;


@RunWith(MockitoJUnitRunner.class)
public class CertificationControllerTest {
	@Mock
	private CertificationService service;
	@InjectMocks
	private CertificationController controller;
	
	/**
	 * Pruebas unitarias para el clase de certificaciones controller y todos
	 * sus métodos, en casos de éxito y error.
	 */
	
	// Casos de éxito
	@Test
	public void getCursoByIdTest() {
		CursoA curso = new CursoA();
		curso.setIdCurso(1);
		curso.setNombreCurso("Curso Test");
		curso.setDescripcion("Curso de prueba 1");
		curso.setUrl("https://nourlavailable.org");
		
		when(service.getCursoById(ArgumentMatchers.anyInt())).thenReturn(curso);
		
		CursoA newCurso = controller.getCursoById(3);
		assertEquals(curso, newCurso);
	}

}
