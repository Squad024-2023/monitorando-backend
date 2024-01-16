package com.MBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//get aluno by id rest api
		@GetMapping("/alunos/{id}")
		public Aluno getAlunoById(@PathVariable Long id) {
			return alunoRepository.findById(id).get();
		}
		
		//create aluno rest api
		public Aluno createAluno(@RequestBody Aluno aluno) {
			return alunoRepository.save(aluno);
		}
		
		//update aluno rest api
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
		
		//delete aluno rest api
			@DeleteMapping("/alunos/{id}")
			public void deleteAluno(@PathVariable Long id) {
				alunoRepository.deleteById(id);
				
				
				
				alunoRepository.deleteById(id);
			}

}
