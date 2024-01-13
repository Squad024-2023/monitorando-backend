package com.MBE.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.MBE.enums.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuarios extends Entidade {

	@Column(nullable = false, length = 80)
	private String nome;
	
	@Column(nullable = false, length = 16)
	private String telefone;
	
	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(name = "tipo_usuario", nullable = false, length = 80)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Column(nullable = false)
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	


	
}