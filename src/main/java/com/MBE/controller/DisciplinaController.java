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

import com.MBE.docsapi.DisciplinaControllerApi;
import com.MBE.model.Disciplina;
import com.MBE.model.Professor;
import com.MBE.repository.DisciplinaRepository;
import com.MBE.repository.ProfessorRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin
@RestController

public class DisciplinaController implements DisciplinaControllerApi {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@GetMapping("/disciplinas")
	public List<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@Operation(summary = "Consultar por ID:")
	@GetMapping("/disciplinas/{id}")
	public Disciplina getDisciplinaById(@PathVariable Long id) {
		return disciplinaRepository.findById(id).get();
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@Operation(summary = "Criar nova disciplinas:")
	@PostMapping("/disciplinas")
	public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada."),
			@ApiResponse(responseCode = "500", description = "Não é possível atualizar, disciplina vinculada ao professor.") })
	@Operation(summary = "Atualizar disciplina:")
	@PutMapping("/disciplinas/{id}")
	public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaDetails) {
		Disciplina disciplina = disciplinaRepository.findById(id).get();
		disciplina.setNome(disciplinaDetails.getNome());
		disciplina.setProfessores(disciplinaDetails.getProfessores());
		return disciplinaRepository.save(disciplina);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "500", description = "Não é possível excluir, disciplina vinculada a turma.") })
	@Operation(summary = "Deletar disciplina por ID:")
	@DeleteMapping("/disciplinas/{id}")
	public void deleteDisciplina(@PathVariable Long id) {
		Disciplina disciplina = disciplinaRepository.findById(id).get();
		for (Professor professor : disciplina.getProfessores()) {
			professor.getDisciplinas().clear();
			professorRepository.save(professor);
		}
		disciplinaRepository.deleteById(id);
	}

}
