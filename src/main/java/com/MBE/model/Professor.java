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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name = "professores")
public class Professor extends Usuarios {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profDescricao;
	
	
	//@JsonManagedReference
	@ManyToMany(mappedBy = "professores", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	
	public String getProfDescricao() {
		return profDescricao;
	}

	public void setProfDescricao(String profDescricao) {
		this.profDescricao = profDescricao;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}