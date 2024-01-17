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

import com.MBE.model.Disciplina;
import com.MBE.repository.DisciplinaRepository;

@CrossOrigin
@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
//	 @Autowired
//	 private ProfessorRepository professorRepository;

	// get all disciplinas
	@GetMapping("/disciplinas")
	public List<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	//get disciplina by id rest api
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
