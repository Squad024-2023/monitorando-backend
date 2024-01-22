package com.MBE.docsapi;

import java.util.List;

import com.MBE.model.Disciplina;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Disciplina")
public interface DisciplinaControllerApi {
	
	@Operation(summary = "Listar todas as Disciplinas:")
	List<Disciplina> getAllDisciplinas();

}
