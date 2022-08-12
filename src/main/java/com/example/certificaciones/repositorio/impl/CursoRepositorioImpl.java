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
	public String deleteCurso(int idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String updateCurso(CursoA curso) {
		Query queryUpdate = gestor.createNativeQuery("update cursos set nombre_curso = :nombre, url = :url, descripcion = :descripcion where id_curso = :id", CursoA.class);
		queryUpdate.setParameter("nombre", curso.getNombreCurso());
		queryUpdate.setParameter("url", curso.getUrl());
		queryUpdate.setParameter("descripcion", curso.getDescripcion());
		queryUpdate.setParameter("id", curso.getIdCurso());
		int lineas = queryUpdate.executeUpdate();
		log.info("Elementos actualizados >>>> {} {}",lineas, curso.toString());
		return null;
	}

	@Override
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
