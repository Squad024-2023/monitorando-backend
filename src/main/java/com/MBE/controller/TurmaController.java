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

import com.MBE.docsapi.TurmaControllerApi;
import com.MBE.model.Aluno;
import com.MBE.model.Turma;
import com.MBE.repository.AlunoRepository;
import com.MBE.repository.TurmaRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin
@RestController

public class TurmaController implements TurmaControllerApi {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@GetMapping("/turmas")
	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })

	@Operation(summary = "Consultar por ID")
	@GetMapping("/turmas/{id}")
	public Turma getTurmaById(@PathVariable Long id) {
		return turmaRepository.findById(id).get();
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })

	@Operation(summary = "Criar nova turma")
	@PostMapping("/turmas")
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@Operation(summary = "Atualizar turma")
	@PutMapping("/turmas/{id}")
	public Turma updateTurma(@PathVariable Long id, @RequestBody Turma turmaDetails) {
		Turma turma = turmaRepository.findById(id).get();
		turma.setTipoTurma(turmaDetails.getTipoTurma());
		turma.setMateriaTurma(turmaDetails.getMateriaTurma());
		turma.setDisciplina(turmaDetails.getDisciplina());
		turma.setProfessor(turmaDetails.getProfessor());
		turma.setDataAula(turmaDetails.getDataAula());
		turma.setAlunos(turmaDetails.getAlunos());
		return turmaRepository.save(turma);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.") })
	@Operation(summary = "Deletar turma por ID")
	@DeleteMapping("/turmas/{id}")
	public void deleteTurma(@PathVariable Long id) {
		Turma turma = turmaRepository.findById(id).get();
		for (Aluno aluno : turma.getAlunos()) {
			aluno.getTurmas().clear();
			alunoRepository.save(aluno);
		}
		turmaRepository.deleteById(id);
	}

}