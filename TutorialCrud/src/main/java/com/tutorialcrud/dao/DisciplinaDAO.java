package com.tutorialcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.tutorialcrud.dominio.Disciplina;
import com.tutorialcrud.util.JpaUtil;

public class DisciplinaDAO {
	
	
	
	public Disciplina buscar(Long id){
		EntityManager manager = JpaUtil.getEntityManager();
		Disciplina disciplina = manager.find(Disciplina.class, id);
		return disciplina;
	}
	
	public Disciplina buscarNome(String nome){
		EntityManager manager = JpaUtil.getEntityManager();
		Disciplina disciplina = manager.find(Disciplina.class, nome);
		return disciplina;
	}
	
	
	public void persistir(Disciplina disciplina){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		manager.persist(disciplina);
		trx.begin();		
		trx.commit();



	}
	
	

}
