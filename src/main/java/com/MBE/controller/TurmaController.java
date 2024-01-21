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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "Turmas")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	@Operation(summary = "Listar todas as turmas")
	@GetMapping("/turmas")
	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();
	}
	
	@Operation(summary = "Criar nova turma")
	@PostMapping("/turmas")
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	@Operation(summary = "Atualizar turma")
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

	@Operation(summary = "Deletar uma turma")
	@DeleteMapping("/turmas/{id}")
	public void deleteTurma(@PathVariable Long id) {
		turmaRepository.deleteById(id);
	}
}