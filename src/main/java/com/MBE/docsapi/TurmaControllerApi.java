package com.MBE.docsapi;

import java.util.List;

import com.MBE.model.Turma;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Turma")
public interface TurmaControllerApi {
	
	@Operation(summary = "Listar todas as turmas")
	List<Turma> getAllTurmas();

}
