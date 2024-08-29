package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.UsuarioRequestDTO;
import com.example.demo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/usuario")
	public ResponseEntity<String> getUsuarioPorChave(@RequestBody UsuarioRequestDTO request) {
		String jsonResponse = usuarioService.getUsuarioPorChave(request.getChave());
		
		
		System.out.println(jsonResponse);
		
		// Verifica se a resposta JSON contém um erro
		if (jsonResponse.contains("\"error\"")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse);
		} else {
			return ResponseEntity.ok(jsonResponse);
		}
	}
}