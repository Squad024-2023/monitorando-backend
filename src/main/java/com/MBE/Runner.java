package com.MBE;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MBE.enums.TipoTurma;
import com.MBE.enums.TipoUsuario;
import com.MBE.model.Aluno;
import com.MBE.model.Disciplina;
import com.MBE.model.Professor;
import com.MBE.model.Turma;
import com.MBE.repository.AlunoRepository;
import com.MBE.repository.DisciplinaRepository;
import com.MBE.repository.ProfessorRepository;
import com.MBE.repository.TurmaRepository;

@Configuration
public class Runner implements CommandLineRunner {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;

	@Override
	public void run(String... args) throws Exception {
		// Professor
		for (int i = 0; i <= 3; i++) {
			String x = String.valueOf(i);
			Professor prof0 = new Professor();
			prof0.setId((long) 1 + i);
			prof0.setNome("admin" + x);
			prof0.setEmail("admin@admin.com " + x);
			prof0.setDataNascimento(LocalDate.now());
			prof0.setTelefone("123456789" + x);
			prof0.setProfDescricao("administrador do sistema." + x);
			prof0.setTipoUsuario(TipoUsuario.ADMIN);
			prof0.setSenha("0000");
			professorRepository.save(prof0);

			// Disciplina
			Disciplina disc0 = new Disciplina();
			disc0.setId((long) 1 + i);
			disc0.setNome("Física" + x);
			disc0.getProfessores().add(prof0);
			disciplinaRepository.save(disc0);

			// Alunos
			Aluno aluno0 = new Aluno();
			aluno0.setId((long) 1 + i);
			aluno0.setNome("aluno" + x);
			aluno0.setEmail("aluno@aluno.com " + x);
			aluno0.setDataNascimento(LocalDate.now());
			aluno0.setTelefone("44455578" + x);
			aluno0.setTipoUsuario(TipoUsuario.USER);
			aluno0.setSenha("1234");
			alunoRepository.save(aluno0);

			//Turmas
			Turma turma0 = new Turma();
			turma0.setId((long) 1+i);
			turma0.setMateriaTurma("Eletromagnetismo" + x);
			turma0.setDisciplina(disc0);
			turma0.setProfessor(prof0);
			turma0.setDataAula(LocalDateTime.now());
			turma0.setTipoTurma(TipoTurma.COLETIVA);
			turma0.getAlunos().add(aluno0);
			turmaRepository.save(turma0);
		}
	}
}
