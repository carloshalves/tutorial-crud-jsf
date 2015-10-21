package com.tutorialcrud.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.tutorialcrud.dao.AlunoTransacao;
import com.tutorialcrud.dominio.Aluno;

@ViewScoped
@ManagedBean
public class AlunoBean extends AbstractMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final String SELECTED_ALUNO = "selectedAluno";
	
	private Aluno aluno;
	private List<Aluno> alunos;
	private AlunoTransacao alunoTransacao;
	
	public void createAluno() {
		try {
			getAlunoTransacao().createDominio(aluno);
			closeDialog();
			displayInfoMessageToUser("Created With Sucess");
			loadAlunos();
			resetAluno();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}
	}

	public void updateAluno() {
		try {
			getAlunoTransacao().updateDominio(aluno);
			closeDialog();
			displayInfoMessageToUser("Updated With Sucess");
			loadAlunos();
			resetAluno();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}
	}

	public void deleteAluno() {
		try {
			getAlunoTransacao().deleteDominio(aluno);
			closeDialog();
			displayInfoMessageToUser("Deleted With Sucess");
			loadAlunos();
			resetAluno();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}
	}

	

	public Aluno getAluno() {
		if (aluno == null) {
			aluno = new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAllAlunos() {
		if (alunos == null) {
			loadAlunos();
		}
		return alunos;
	}

	private void loadAlunos() {
		alunos = getAlunoTransacao().listAll();
	}

	public void resetAluno() {
		aluno = new Aluno();
	}


	public AlunoTransacao getAlunoTransacao() {
		if (alunoTransacao == null) {
			alunoTransacao = new AlunoTransacao();
		}
		return alunoTransacao;
	}

	public void setAlunoTransacao(AlunoTransacao alunoTransacao) {
		this.alunoTransacao = alunoTransacao;
	}

}
