package com.MBE.docsapi;

import java.util.List;

import com.MBE.model.Professor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Professor")
public interface ProfessorControllerApi {

	@Operation(summary = "Listar todos os professores:")
	public List<Professor> getAllProfessores();
	
}
