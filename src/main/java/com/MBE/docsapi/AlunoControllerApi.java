package com.MBE.docsapi;

import java.util.List;

import com.MBE.model.Aluno;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Aluno")
public interface AlunoControllerApi {
	List<Aluno> getAllAlunos();



}
