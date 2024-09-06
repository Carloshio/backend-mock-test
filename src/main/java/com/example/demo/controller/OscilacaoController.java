package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.OscilacaoDTO;
import com.example.demo.service.OscilacaoService;

@RestController
@RequestMapping("/api")
public class OscilacaoController {
	@Autowired
    private OscilacaoService oscilacaoService;

    @PostMapping("/contarChegadaArquivos")
    public ResponseEntity<ApiResponse> getStatus() {
        ApiResponse response = oscilacaoService.getStatus();
        return ResponseEntity.ok(response);
    }
}
