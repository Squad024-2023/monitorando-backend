package com.MBE.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBE.enums.TipoUsuario;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class EnumController {
	
	
	//get all tipoUsuario
	@GetMapping("/tipoUsuario")
	public TipoUsuario getAllTipoUsuario(){
		
		return getAllTipoUsuario();

	}

}
