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

import com.MBE.docsapi.ProfessorControllerApi;
import com.MBE.model.Professor;
import com.MBE.repository.ProfessorRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin
@RestController
public class ProfessorController implements ProfessorControllerApi {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
//	@Autowired
//	private TurmaRepository turmaRepository;
//	@Autowired
//	private DisciplinaRepository disciplinaRepository;

	
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")	})	
	@GetMapping("/professor")
	public List<Professor> getAllProfessores(){
		return professorRepository.findAll();
	}
	
	@Operation(summary = "Buscar professor por ID:")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")	})	
	@GetMapping("/professor/{id}")
	public Professor getProfessorById(@PathVariable Long id) {
		return professorRepository.findById(id).get();
	}
	
	@Operation(summary = "Adicionar novo professor:")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")	})
	@PostMapping("/professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@Operation(summary = "Atualizar os dados de professor por ID:")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")	})
	@PutMapping("/professor/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
		Professor professor = professorRepository.findById(id).get();
		professor.setNome(professorDetails.getNome());
		professor.setEmail(professorDetails.getEmail());
		professor.setDataNascimento(professorDetails.getDataNascimento());
		professor.setTelefone(professorDetails.getTelefone());
		professor.setProfDescricao(professorDetails.getProfDescricao());
		professor.setTipoUsuario(professorDetails.getTipoUsuario());
		professor.setSenha(professorDetails.getSenha());
		professor.setDisciplinas(professorDetails.getDisciplinas());
		return professorRepository.save(professor);
	}

	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada."),
			@ApiResponse(responseCode = "500", description = "Professor está vinculado a disciplina, não pode ser excluído. ") })
	@Operation(summary = "Deletar um professor por ID:")
	@DeleteMapping("/professor/{id}")
	public void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}

}
