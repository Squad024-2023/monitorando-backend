package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id") // usado para gerar
																								// identidade durante
																								// serialização e
																								// deserialização
@Table(name = "disciplinas")
public class Disciplina extends Entidade {

	@Column(nullable = false)
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "disciplinas_professores", joinColumns = @JoinColumn(name = "disciplina_id_fk"), inverseJoinColumns = @JoinColumn(name = "professor_id_fk"))
	private Set<Professor> professores = new HashSet<Professor>();

	@OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
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
