package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id") //usado para gerar identidade durante serialização e deserialização
@Table(name = "alunos")
public class Aluno extends Usuarios{
	
	@ManyToMany(mappedBy = "alunos", fetch = FetchType.EAGER)
	private Set<Turma> turmas = new HashSet<Turma>();

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	
}