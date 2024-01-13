package com.MBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.model.Turma;
import com.MBE.repository.TurmaRepository;

@CrossOrigin(origins = "http://localhost:3000")


@RestController
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	//get all turmas
	@GetMapping("/turmas")
	public List<Turma> getAllTurmas(){
		return turmaRepository.findAll();	}
	
}
