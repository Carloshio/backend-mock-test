package com.example.demo.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.UsuarioResponseDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	String jsonString;
	
	@Autowired
	private ObjectMapper objectMapper; // Adiciona o ObjectMapper como um bean

	public String getUsuarioPorChave(String chave) {
		Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioRepository.findByChave(chave));

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			UsuarioResponseDTO dto = new UsuarioResponseDTO(usuario.getChave(), usuario.getNomeGestor(),
					usuario.getEmail(), usuario.getTelefone(), usuario.getComplementoGestor(),
					usuario.getDepartamentoInfo(), usuario.getNivelReponsabilidadeGestor());			
	
			try {
				jsonString = objectMapper.writeValueAsString(dto).replace("\"", "\\\"");
				jsonString = "\"" + jsonString + "\"";
				System.out.println(jsonString);
				return jsonString;
			} catch (JsonProcessingException e) {
				return "{\"error\": \"Erro ao processar a resposta JSON\"}";
			}			
			
		} else {
			// Retorna uma mensagem de erro em JSON
			return "{\"error\": \"Gestor não encontrado\"}";
		}
	}
}