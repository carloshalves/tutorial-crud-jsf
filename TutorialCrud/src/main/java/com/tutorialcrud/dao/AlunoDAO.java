package com.tutorialcrud.dao;

import com.tutorialcrud.dominio.Aluno;

public class AlunoDAO extends GenericDAO<Aluno>{
	private static final long serialVersionUID = 1L;
	
	public AlunoDAO() {
		super(Aluno.class);		
	}
	
	  public void delete(Aluno aluno) {
          super.delete(aluno.getId(), Aluno.class);
  }

	

}
