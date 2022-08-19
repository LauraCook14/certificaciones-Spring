package com.example.certificaciones.service;

import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.CursoRepositorio;
import com.example.certificaciones.service.impl.CertificationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CertificationServiceTest {

    @Mock
    private CursoRepositorio repositorio;
    @InjectMocks
    private CertificationServiceImpl service;




    @Test
    public void getCursoByIdTest() {

        CursoA cursoa = new CursoA();
        cursoa.setIdCurso(1);
        cursoa.setNombreCurso("Curso Test");
        cursoa.setDescripcion("Curso de prueba 1");
        cursoa.setUrl("https://nourlavailable.org");
        when(repositorio.getCursoById(ArgumentMatchers.anyInt())).thenReturn(cursoa);

        CursoA newCurso = service.getCursoById(1);

        assertEquals(cursoa, newCurso);
        assertEquals("Curso Test",newCurso.getNombreCurso());
    }

    @Test
    public void deleteCursoTest(){

        int resultado = 0;

        when(repositorio.deleteCurso(ArgumentMatchers.anyInt())).thenReturn(resultado);

        int deleteCurso = service.deleteCurso(1);

        assertEquals(resultado , deleteCurso);
    }

    @Test
    public void getListCursoTest(){

        List<CursoA> list = new ArrayList<>();

        CursoA cursoa = new CursoA();

        cursoa.setIdCurso(1);
        cursoa.setNombreCurso("Curso Test");
        cursoa.setDescripcion("Curso de prueba 1");
        cursoa.setUrl("https://nourlavailable.org");

        CursoA cursob = new CursoA();
        cursob.setIdCurso(1);
        cursob.setNombreCurso("Curso Test");
        cursob.setDescripcion("Curso de prueba 1");
        cursob.setUrl("https://nourlavailable.org");

        list.add(cursoa);
        list.add(cursob);

        when(service.getListCursos()).thenReturn(list);

        List<CursoA> list1 = repositorio.getListCursos();

        assertEquals(list , list1);

    }

   @Test

    public void insertCursoTest(){
       Map<String, String> cursoa = new HashMap<>();

       cursoa.put("nombre","Curso Test");
       cursoa.put("url","https://nourlavailable.org");
       cursoa.put("descripcion","Curso de prueba 1");


       String str = "hola";
       
       when(repositorio.insertarCurso(ArgumentMatchers.any())).thenReturn(str);

       String curso = service.insertCurso(cursoa);

       assertEquals(curso, str);
   }

    @Test
    public void updateTest(){
        Map<String, String> cursoa = new HashMap<>();

        cursoa.put("id","1");
        cursoa.put("nombre","Curso Hula ;v");

        String mensaje = "Elemento Actualozado :D";

        CursoA cursob = new CursoA();
        cursob.setIdCurso(1);
        cursob.setNombreCurso("Curso Test");
        cursob.setDescripcion("Curso de prueba 1");
        cursob.setUrl("https://nourlavailable.org");

        when(repositorio.getCursoById(ArgumentMatchers.anyInt())).thenReturn(cursob);

        when(repositorio.updateCurso(ArgumentMatchers.any())).thenReturn(mensaje);

        String responseMensaje = service.updateCurso(cursoa);

        assertEquals(mensaje, responseMensaje);
    }





}
