package com.MBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.model.Disciplina;
import com.MBE.repository.DisciplinaRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	// get all disciplinas
	@GetMapping("/disciplinas")
	public List<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}

}
