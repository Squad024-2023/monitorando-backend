package com.MBE.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

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
			.url("https://github.com/Squad024-2023/monitorando-backend/tree/master")
    			);
    }
}
