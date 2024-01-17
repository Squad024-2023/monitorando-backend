package com.MBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.model.Turma;
import com.MBE.repository.TurmaRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	// get all turmas
	@GetMapping("/turmas")
	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();

	}

	// create turma
	@PostMapping("/turmas")
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	// uptade turma
	@PutMapping("/turmas/{id}")
	public Turma updateTurma(@PathVariable Long id, @RequestBody Turma turmaDetails) {
		Turma turma = turmaRepository.findById(id).get();
		turma.setTipoTurma(turmaDetails.getTipoTurma());
		turma.setMateriaTurma(turmaDetails.getMateriaTurma());
		turma.setDisciplina(turmaDetails.getDisciplina());
		turma.setProfessor(turmaDetails.getProfessor());
		turma.setDataAula(turmaDetails.getDataAula());
		return turmaRepository.save(turma);
	}

	// delete turma

	@DeleteMapping("/turmas/{id}")
	public void deleteTurma(@PathVariable Long id) {
		turmaRepository.deleteById(id);
	}
}
