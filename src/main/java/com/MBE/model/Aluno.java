package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno extends Usuarios{
	
	@ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
	private Set<Turma> turmas = new HashSet<Turma>();

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	
}