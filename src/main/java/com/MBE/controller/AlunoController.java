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
import org.webjars.NotFoundException;

import com.MBE.model.Aluno;
import com.MBE.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

@Operation(summary="Recupera as informações de um aluno pelo ID",
description ="Retorna os detalhes completos de um aluno com base no ID fornecido.")
@ApiResponses(value= {
		@ApiResponse(responseCode ="200", description="Aluno recuperado com sucesso!"),
		@ApiResponse(responseCode ="400", description="Aluno não encontrado"),
		  @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao recuperar o aluno")
})
@Parameter(
        name = "id",
        description = "ID do aluno a ser recuperado",
        required = true
)
@GetMapping("/alunos/{id}")
	public Aluno getAlunoById(@PathVariable Long id) {
	try {
        return alunoRepository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    } catch (Exception e) {
        throw new RuntimeException("Erro interno do servidor ao recuperar o aluno", e);
    }
	}


@Operation(summary = "Criação de um novo aluno",
description = "Endpoint responsável por cadastrar um novo aluno no sistema.")
@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, aluno cadastrado"),
        @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida, verifique os parâmetros fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor ao cadastrar o aluno")
    
})
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
