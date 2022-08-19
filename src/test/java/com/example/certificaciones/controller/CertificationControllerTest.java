package com.example.certificaciones.controller;

import com.example.certificaciones.modelo.Curso;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.hibernate.service.spi.InjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.certicaciones.service.CertificationService;
import com.example.certificaciones.modelo.CursoA;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CertificationControllerTest {
	@Mock
	private CertificationService service;
	@InjectMocks
	private CertificationController controller;
	
	/**
	 * Pruebas unitarias para la clase de certificaciones controller y todos
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

	@Test
	public void getCursos(){
		List<CursoA> cursos = new ArrayList<>();

		CursoA curso1 = new CursoA();
		curso1.setIdCurso(1);
		curso1.setNombreCurso("Curso Test");
		curso1.setDescripcion("Curso de prueba 1");
		curso1.setUrl("https://nourlavailable.org");

		CursoA curso2 = new CursoA();
		curso2.setIdCurso(2);
		curso2.setNombreCurso("Curso Test");
		curso2.setDescripcion("Curso de prueba 2");
		curso2.setUrl("https://nourlavailable.org");


		CursoA curso3 = new CursoA();
		curso3.setIdCurso(3);
		curso3.setNombreCurso("Curso Test");
		curso3.setDescripcion("Curso de prueba 3");
		curso3.setUrl("https://nourlavailable.org");


		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);

		when(service.getListCursos()).thenReturn(cursos);

		List<CursoA> newCurso = controller.getListCursos();

		assertEquals(cursos.size(), newCurso.size());
		assertEquals(cursos.get(0).getIdCurso(), newCurso.get(0).getIdCurso());
	}

	@Test
	public void getCursosFromDB(){

		List<CursoA> cursos = new ArrayList<>();

		List<CursoA> cursosDB = controller.getListCursos();

		assertNotNull(cursosDB);
		assertEquals(cursos.getClass(), cursosDB.getClass());

	}

}
