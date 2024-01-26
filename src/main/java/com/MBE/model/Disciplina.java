package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "disciplinas")
public class Disciplina extends Entidade {

	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "disciplinas", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	private Set<Professor> professores = new HashSet<Professor>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}
	
	public void addProfessor(Professor professor) {
		professores.add(professor);
		professor.getDisciplinas().add(this);
	}

	public void removeProfessor(Professor professor) {
		professores.remove(professor);
		professor.getDisciplinas().remove(this);
	}

}
