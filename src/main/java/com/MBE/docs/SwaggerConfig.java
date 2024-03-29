package com.MBE.docs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI openAPI() {
    	return new OpenAPI()
    			.info(new Info()
    				.title("Monitorando")
    				.version("v1")
    				.description("REST API Test")
    			)  		
	.externalDocs(new ExternalDocumentation ()
			.description("GitHub - Monitorando")
			.url("https://github.com/Squad024-2023/monitorando-backend/tree/master"))
		.tags(	
			Arrays.asList(

					new Tag().name("Turma").description("Métodos de Turmas"),
					new Tag().name("Aluno").description("Métodos de Alunos"),
					new Tag().name("Disciplina").description("Métodos de Disciplinas"),
					new Tag().name("Professor").description("Métodos de Professores")

					)
		);
					
    }
}
