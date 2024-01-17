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

import com.MBE.model.Professor;
import com.MBE.repository.ProfessorRepository;

@CrossOrigin
@RestController
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
//	@Autowired
//	private TurmaRepository turmaRepository;
//	@Autowired
//	private DisciplinaRepository disciplinaRepository;
//	
	
	
	//get all "professores"
	@GetMapping("/professores")
	public List<Professor> getAllProfessores(){
		return professorRepository.findAll();
	}
	
	//get professor by id rest api
	@GetMapping("/professores/{id}")
	public Professor getProfessorById(@PathVariable Long id) {
		return professorRepository.findById(id).get();
	}
	
	//create professor rest api
	@PostMapping("/professores")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	//update professor rest api
	@PutMapping("/professores/{id}")
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
