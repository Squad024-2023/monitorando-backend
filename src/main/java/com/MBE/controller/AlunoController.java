package com.MBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.model.Aluno;
import com.MBE.repository.AlunoRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	// get all alunos
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

}
