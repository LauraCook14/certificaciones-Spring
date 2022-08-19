package com.example.certificaciones.repository;


import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.impl.CursoRepositorioImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CertificationRepositoryTest {
    @Mock
    private EntityManager gestor;
    @InjectMocks
    private CursoRepositorioImpl repositorio;

    @Test
    public void listaCursoTest(){
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

        TypedQuery query = mock(TypedQuery.class);

        when(gestor.createNativeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.<Class<CursoA>>any())).thenReturn(query);

        when(query.getResultList()).thenReturn(list);

        List<CursoA> list2 = repositorio.listaCurso();

        assertNotNull(list2);
        assertEquals(list2.size(),list.size());
    }

    @Test
    public void insertarCursoTest(){

      CursoA cursoa = new CursoA();

      cursoa.setIdCurso(1);
      //Cando no se espera return de una llamada no es 
      //necesario colocar la sentencia when**
      String mensaje = repositorio.insertarCurso(cursoa);
      
      assertNotNull(mensaje);
      assertEquals(mensaje, "Elemento insertado");

    }

    @Test
    public void deleteCursoTest(){
        TypedQuery queryDelete = mock(TypedQuery.class);

        when(gestor.createNativeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.<Class<CursoA>>any())).thenReturn(queryDelete);
        when(queryDelete.executeUpdate()).thenReturn(1);
        
        int rowAfected = repositorio.deleteCurso(6);
        assertNotNull(rowAfected);
        assertEquals(rowAfected, 1);
    }

    @Test
    public void updateCursoTest(){
    	CursoA curso = new CursoA();
    	curso.setIdCurso(1);
    	curso.setNombreCurso("Nombre");
    	curso.setDescripcion("Descripción");
    	curso.setUrl("URl");
    	TypedQuery query = mock(TypedQuery.class);
    	when(gestor.createNativeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.<Class<CursoA>>any())).thenReturn(query);
    	when(query.executeUpdate()).thenReturn(1);
    	String mensaje = repositorio.updateCurso(curso);
    	assertNotNull(mensaje);
    	assertEquals(mensaje,"Registros afectados: 1");
    }

    @Test
    public void getCursoById(){
    	CursoA curso = new CursoA();
    	TypedQuery query = mock(TypedQuery.class);
    	when(gestor.createNativeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.<Class<CursoA>>any())).thenReturn(query);
    	when(query.getSingleResult()).thenReturn(curso);
    	CursoA resultCurso = repositorio.getCursoById(1);
    	
    	assertNotNull(resultCurso);
    	assertEquals(resultCurso,curso);
    }
}
