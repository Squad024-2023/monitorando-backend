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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Disciplina.class) // usado para gerar
																								// identidade durante
																								// serialização e
																								// deserialização
@Table(name = "disciplinas")
public class Disciplina extends Entidade {

	@Column(nullable = false)
	private String nome;


	@ManyToMany(mappedBy = "disciplinas", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	private Set<Professor> professores = new HashSet<Professor>();
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	private Set<Turma> turmas = new HashSet<>();

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
	
	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
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
