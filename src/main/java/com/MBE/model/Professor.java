package com.MBE.model;

import java.util.HashSet;
import java.util.Set;

import com.MBE.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor extends Usuarios{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profDescricao;
	
	@Column(name = "tipo_usuario", nullable = false, length = 80)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "professores", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	
	public String getProfDescricao() {
		return profDescricao;
	}

	public void setProfDescricao(String profDescricao) {
		this.profDescricao = profDescricao;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}