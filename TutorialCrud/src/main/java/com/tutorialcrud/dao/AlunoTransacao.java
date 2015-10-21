package com.tutorialcrud.dao;

import java.io.Serializable;
import java.util.List;

import com.tutorialcrud.dominio.Aluno;

public class AlunoTransacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private AlunoDAO dominioDAO = new AlunoDAO();
    
    public void createDominio(Aluno dominio) {
    	dominioDAO.beginTransaction();
    	dominioDAO.save(dominio);
    	dominioDAO.commitAndCloseTransaction();
    }
    
    public void updateDominio(Aluno dominio) {
    	dominioDAO.beginTransaction();    	
        Aluno persistedDominio = dominioDAO.find(dominio.getId());
        persistedDominio.setNome(dominio.getNome());
        persistedDominio.setEmail(dominio.getEmail());
        persistedDominio.setTelefone(dominio.getTelefone());      
        dominioDAO.commitAndCloseTransaction();
    }
    
    public void deleteDominio(Aluno dominio){
    	dominioDAO.beginTransaction();
        Aluno persistedDominioWithIdOnly = dominioDAO.findReferenceOnly(dominio.getId());
        dominioDAO.delete(persistedDominioWithIdOnly);
        dominioDAO.commitAndCloseTransaction();
 
    }
    
    public Aluno findDominio(Long dominioId) {
    	dominioDAO.beginTransaction();
        Aluno dominio = dominioDAO.find(dominioId);
        dominioDAO.closeTransaction();
        return dominio;
    }
    
    
    public List<Aluno> listAll() {
    	dominioDAO.beginTransaction();
        List<Aluno> result = dominioDAO.findAll();
        dominioDAO.closeTransaction();
 
        return result;
    }
    
    
    
    
 
    
    
}
