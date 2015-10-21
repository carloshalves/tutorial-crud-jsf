package com.tutorialcrud.regras;

import com.tutorialcrud.dao.DisciplinaDAO;
import com.tutorialcrud.dominio.Disciplina;

public class DisciplinaRegras {
	
	public void salvar(Disciplina disciplina){
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		try{
		Disciplina existente = disciplinaDAO.buscar(disciplina.getId());
		if(existente != null && !existente.equals(disciplina)){
			throw new RuntimeException("Já existe uma disciplina cadastrada no banco");
		}
		}catch(RuntimeException e){
			
		}
		disciplinaDAO.persistir(disciplina);		
	}
	
	public void salvar2(Disciplina disciplina){
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		try{
		Disciplina existente = disciplinaDAO.buscarNome(disciplina.getNome());
		if(existente != null && !existente.equals(disciplina)){
			throw new RuntimeException("Já existe uma disciplina cadastrada com esse nome no banco");
		}
		}catch(RuntimeException e){
			
		}
		disciplinaDAO.persistir(disciplina);		
	}

}
