package com.MBE;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MBE.enums.TipoUsuario;
import com.MBE.model.Disciplina;
import com.MBE.model.Professor;
import com.MBE.repository.DisciplinaRepository;
import com.MBE.repository.ProfessorRepository;

@Configuration
public class Runner implements CommandLineRunner{
	
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Override
	public void run(String... args) throws Exception {
		//Professor
		Professor prof0 = new Professor();
		prof0.setId((long) 1);
		prof0.setNome("admin");
		prof0.setEmail("admin@admin.com");
		prof0.setDataNascimento(LocalDate.now());
		prof0.setTelefone("123456789");
		prof0.setProfDescricao("administrador do sistema.");
		prof0.setTipoUsuario(TipoUsuario.ADMIN);
		prof0.setSenha("0000");
		professorRepository.save(prof0);
		
		//Disciplina
		Disciplina disc0 = new Disciplina();
		disc0.setId((long) 1);
		disc0.setNome("Física");
		disc0.getProfessores().add(prof0);
		disciplinaRepository.save(disc0);
		
	}

}
