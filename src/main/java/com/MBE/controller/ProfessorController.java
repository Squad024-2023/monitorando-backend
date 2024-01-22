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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.model.Professor;
import com.MBE.repository.ProfessorRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/professor")
@Tag(name = "Professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
//	@Autowired
//	private TurmaRepository turmaRepository;
//	@Autowired
//	private DisciplinaRepository disciplinaRepository;
//	
	
	//get all "professores"
	@Operation(summary = "Buscar todos professores")
	@GetMapping("/listar professores")
	public List<Professor> getAllProfessores(){
		return professorRepository.findAll();
	}
	
	//get professor by id rest api
	@Operation(summary = "Buscar Professores por ID")
	@GetMapping("/professores/{id}")
	public Professor getProfessorById(@PathVariable Long id) {
		return professorRepository.findById(id).get();
	}
	
	//create professor rest api
	@Operation(summary = "Método para criar novos dados")
	@PostMapping("/criar")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	//update professor rest api
	@Operation(summary = "Atualizar os dados")
	@PutMapping("/atualizar/{id}")
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
	//delete professor rest api
	@DeleteMapping("/professores/{id}")
	public void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}

}
