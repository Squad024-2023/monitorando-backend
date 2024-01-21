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

import com.MBE.model.Aluno;
import com.MBE.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Operation(summary = "Retorna uma lista de todos os alunos cadastrados")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Lista de alunos recuperada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Nenhum aluno encontrado")
		})

	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	// get aluno by id rest api
	@GetMapping("/alunos/{id}")
	public Aluno getAlunoById(@PathVariable Long id) {
		return alunoRepository.findById(id).get();
	}

	// create aluno rest api
	@PostMapping("/alunos")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	// update aluno rest api
	@PutMapping("alunos/{id}")
	public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails) {
		Aluno aluno = alunoRepository.findById(id).get();
		aluno.setNome(alunoDetails.getNome());
		aluno.setEmail(alunoDetails.getEmail());
		aluno.setDataNascimento(alunoDetails.getDataNascimento());
		aluno.setTelefone(alunoDetails.getTelefone());
		aluno.setTipoUsuario(alunoDetails.getTipoUsuario());
		aluno.setSenha(alunoDetails.getSenha());
		aluno.setTurmas(alunoDetails.getTurmas());
		return alunoRepository.save(aluno);

	}

	// delete aluno rest api
	@DeleteMapping("/alunos/{id}")
	public void deleteAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}

}
