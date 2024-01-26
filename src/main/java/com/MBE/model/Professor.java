package com.MBE.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "professores")
public class Professor extends Usuarios {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profDescricao;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinTable(name = "professor_disciplina", joinColumns = @JoinColumn(name = "professor_id_fk"), inverseJoinColumns = @JoinColumn(name = "disciplina_id_fk"))
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