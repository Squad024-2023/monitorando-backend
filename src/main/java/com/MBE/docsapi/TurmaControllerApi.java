package com.MBE.docsapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Turma")
public interface TurmaControllerApi {
	
	@Operation(summary = "Listar todas as turmas")
	String findAll();

}
