package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplinas")
public class Disciplina extends Entidade {
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="disciplinas_professores",
	joinColumns = @JoinColumn(name = "disciplina_id_fk"),
	inverseJoinColumns = @JoinColumn(name = "professor_id_fk")
	)
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
