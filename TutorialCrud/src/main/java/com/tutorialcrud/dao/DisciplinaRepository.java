package com.tutorialcrud.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tutorialcrud.dominio.Disciplina;

public class DisciplinaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public DisciplinaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Disciplina> todos() {
		TypedQuery<Disciplina> query = manager.createQuery("from Disciplina", Disciplina.class);
		return query.getResultList();
	}
	
	public Disciplina porId(Long id) {
		return manager.find(Disciplina.class, id);
		}
	
	public void adicionar(Disciplina disciplina) {
		this.manager.persist(disciplina);
		}
	

}
