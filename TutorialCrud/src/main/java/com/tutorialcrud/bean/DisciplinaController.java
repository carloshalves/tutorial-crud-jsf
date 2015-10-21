package com.tutorialcrud.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.tutorialcrud.dao.DisciplinaRepository;
import com.tutorialcrud.dominio.Disciplina;
import com.tutorialcrud.regras.DisciplinaRegras;
import com.tutorialcrud.util.JpaUtil;

@ManagedBean
@SessionScoped
public class DisciplinaController {
	
	private Disciplina disciplina;
	private List<Disciplina>listaDisciplinas;
	
	EntityManager manager = JpaUtil.getEntityManager();
	
	public void iniciarTela(){
		this.disciplina = new Disciplina();
	}
	
	public void salvar(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			DisciplinaRegras disciplinaRegras = new DisciplinaRegras();
			disciplinaRegras.salvar2(this.disciplina);
			facesContext.addMessage(null, new FacesMessage("Disciplina: "+this.disciplina.getNome()+" cadastrado com sucesso!"));
			this.disciplina = new Disciplina();
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, facesMessage);
		}		
	}
	
	public void validarEspacoBranco(FacesContext contexto, UIComponent componente, Object valor){
		String valorString = (String)valor;
		if(valorString.trim().equals("")){
			((UIInput)componente).setValid(false);
			String mensagem = componente.getAttributes().get("label")
					+":Valor inválido prechencha com caracteres diferentes de espaço";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
			contexto.addMessage(componente.getClientId(contexto), facesMessage);
		}
	}
	
	

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public void consultar() {
		EntityManager manager = com.tutorialcrud.util.JpaUtil.getEntityManager();
		DisciplinaRepository disciplinaRepository = new DisciplinaRepository(manager);
		this.listaDisciplinas = disciplinaRepository.todos();		
		manager.close();
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
	public void remover(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			DisciplinaRepository repository = new DisciplinaRepository(manager);
			repository.porId(this.disciplina.getId()); 
			manager.remove(this.disciplina);
			context.addMessage(null, new FacesMessage("Dados da Disciplina removido com sucesso!"));
			manager.flush();
			}catch(Exception e){
				trx.rollback();
				FacesMessage mensagem = new FacesMessage(e.getMessage());
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
			}
		}
	
	public void excluir(Disciplina disciplina){
		this.manager.remove(disciplina);
	}


}
