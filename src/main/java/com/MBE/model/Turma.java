package com.MBE.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.MBE.enums.TipoTurma;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id",  scope = Turma.class) //usado para gerar identidade durante serialização e deserialização
@Table(name = "turmas")
public class Turma extends Entidade{
	
	@Column(nullable = false)
	private String materiaTurma;
	
	@Column(name = "tipo_turma", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoTurma tipoTurma;
	
	@Column(name = "data_da_aula", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private LocalDateTime dataAula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "professor_id_fk")
	private Professor professor;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinTable(name = "turma_alunos", joinColumns = @JoinColumn(name = "turma_id_fk"), inverseJoinColumns = @JoinColumn(name = "aluno_id_fk"))
	private Set<Aluno> alunos = new HashSet<Aluno>();

	public String getMateriaTurma() {
		return materiaTurma;
	}

	public void setMateriaTurma(String materiaTurma) {
		this.materiaTurma = materiaTurma;
	}

	public TipoTurma getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	public LocalDateTime getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDateTime dataAula) {
		this.dataAula = dataAula;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	
	
	
}