package com.example.certificaciones.repository;


import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.CursoRepositorio;
import com.example.certificaciones.repositorio.impl.CursoRepositorioImpl;
import com.example.certificaciones.service.impl.CertificationServiceImpl;
import org.hamcrest.Matchers;
import org.hibernate.query.NativeQuery;
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

        List<CursoA> list2 = repositorio .listaCurso();

        assertNotNull(list2);
        assertEquals(list2.size(),list.size());
    }

    @Test
    public void insertarCursoTest(){

      CursoA cursoa = new CursoA();

      cursoa.setIdCurso(1);

       // when(gestor.persist(ArgumentMatchers.isA())).thenReturn();

    }

    @Test
    public void deleteCursoTest(){

    }

    @Test
    public void updateCursoTest(){

    }

    @Test
    public void getListCursosTest(){

    }

    @Test
    public void getCursoById(){

    }
}
