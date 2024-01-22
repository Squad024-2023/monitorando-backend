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
import com.MBE.repository.DisciplinaRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin
@RestController

public class DisciplinaController implements DisciplinaControllerApi {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
//	 @Autowired
//	 private ProfessorRepository professorRepository;
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")
	})
	@GetMapping("/disciplinas")
	public List<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Solicitação bem sucedida."),
			@ApiResponse(responseCode = "201", description = "Solicitação criada."),
			@ApiResponse(responseCode = "404", description = "Solicitação não encontrada.")
	})
	@Operation(summary = "Consultar por ID:")
    @GetMapping("/disciplinas/{id}")
    public Disciplina getDisciplinaById(@PathVariable Long id) {
        return disciplinaRepository.findById(id).get();
    }
    
    //create professor rest api
    @PostMapping("/disciplinas")
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    
    //update disciplina rest api
    @PutMapping("/disciplinas/{id}")
    public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaDetails) {
        Disciplina disciplina = disciplinaRepository.findById(id).get();
        disciplina.setNome(disciplinaDetails.getNome());
        disciplina.setProfessores(disciplinaDetails.getProfessores());
        disciplina.setTurmas(disciplinaDetails.getTurmas());
        return disciplinaRepository.save(disciplina);             
    }
    
    //delete professor rest api
    @DeleteMapping("/disciplinas/{id}")
    public void deleteDisciplina(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }



}
