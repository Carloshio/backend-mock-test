package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.OscilacaoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OscilacaoService {
	private final ObjectMapper objectMapper;
	
	public OscilacaoService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public ApiResponse getStatus() {
        OscilacaoDTO response = new OscilacaoDTO();
        response.setQtdRecebidos(10);
        response.setQtdPendentes(111);
        response.setQtdPrevistos(98);
        response.setQtdAtivos(response.getQtdRecebidos() + response.getQtdPrevistos() + response.getQtdPendentes());
        response.setDataConsulta(LocalDateTime.now());
        
        try {
        	String entity = objectMapper.writeValueAsString(response);
        	
        	return new ApiResponse(entity, 200, Collections.emptyMap());
        } catch (JsonProcessingException e) {
        	e.printStackTrace();
        	return new ApiResponse("", 500, Collections.emptyMap());
        }
    }
}
