package com.example.certificaciones.repositorio.impl;

import com.example.certificaciones.modelo.CursoA;
import com.example.certificaciones.repositorio.CursoRepositorio;
import com.example.certificaciones.service.impl.CertificationServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Repository
public class CursoRepositorioImpl implements CursoRepositorio {
	
    @PersistenceContext
    EntityManager gestor;


    @Override
    public List<CursoA> listaCurso() {
        String queryString = "select * from cursos";
        TypedQuery<CursoA> queryCursos = (TypedQuery<CursoA>) gestor.createNativeQuery(queryString, CursoA.class);
        return queryCursos.getResultList();
    }

    @Override
    @Transactional
    public String insertarCurso(CursoA curso) {
        gestor.persist(curso);
        return "Elemento insertado";
    }

	@Override
	@Transactional
	public int deleteCurso(int idCurso) {
		int line = gestor.createNativeQuery("DELETE FROM cursos WHERE id = "+idCurso, CursoA.class).executeUpdate();
		if (line != 0)
			log.info("Elementos actualizados");
		else
			log.info("No se pudo ");

		return line;
	}

	@Override
	@Transactional
	public String updateCurso(CursoA curso) {
		Query genericQuery = gestor.createNativeQuery("update cursos set nombre_curso = '"+curso.getNombreCurso()+"', url = '"+curso.getUrl()+"', descripcion = '"+curso.getDescripcion()+"' where id_curso = "+curso.getIdCurso(), CursoA.class);
		int lineas = genericQuery.executeUpdate();
		log.info("Elementos actualizados >>>> {} {}",lineas, curso.toString());
		return "Registros afectados: "+lineas;
	}

	@Override
	@Transactional
	public List<CursoA> getListCursos() {
		String queryString = "select * from cursos";
        TypedQuery<CursoA> queryCursos = (TypedQuery<CursoA>) gestor.createNativeQuery(queryString, CursoA.class);
        return queryCursos.getResultList();
	}

	@Override
	public CursoA getCursoById(int idCurso) {
		String queryString = "select * from cursos where id_curso = "+idCurso;
        TypedQuery<CursoA> queryCursos = (TypedQuery<CursoA>) gestor.createNativeQuery(queryString, CursoA.class);
        return queryCursos.getSingleResult();
	}


}
