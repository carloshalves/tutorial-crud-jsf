package com.tutorialcrud.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.NamedQueries;

@Entity // significa que � uma classe de persistencia
@Table(name="tbl_professores") //mapear a classe na tabela
@NamedQueries({@NamedQuery(name = "Professor.listar", query = "SELECT professor FROM Professor professor"),
	@NamedQuery(name = "Professor.buscarPorCodigo", query = "SELECT professor FROM Professor professor WHERE professor.codigo = :codigo")}) //HQL para facilitar, vetor  e dentro o objeto
public class Professor {
	
	@Id  //especifica que � o pk e 
	@GeneratedValue(strategy = GenerationType.AUTO) // AUTOINCREMENTO
	
	@Column(name="prof_codigo")
	private Long codigo;
	
	@NotEmpty(message = "O campo nome � obrigat�rio")
	@Size(min = 2, max = 50, message = "Nome deve ter no m�ximo 50 caracteres")
	@Column(name="prof_nome", length = 50, nullable = false) // mapeamento das colunas, tamanho da string, nullable false = o campo � obrigat�rio 
	private String nome;
	
	@Email(message = "email inv�lido")
	@Column(name="prof_email" , length = 50)
	private String email;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Professor [codigo=" + codigo + ", nome=" + nome + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
}
