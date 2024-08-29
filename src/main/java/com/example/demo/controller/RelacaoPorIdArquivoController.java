package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.AlterarGestorRequestDTO;
import com.example.demo.dto.request.ExcluirGestorRequestDTO;
import com.example.demo.dto.request.IncluirGestorRequestDTO;
import com.example.demo.dto.request.RelacaoPorIdArquivoRequestDTO;
import com.example.demo.dto.response.RelacaoPorIdArquivoResponseDTO;
import com.example.demo.entity.GestorDTO;
import com.example.demo.service.RelacaoGestorPorArquivoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class RelacaoPorIdArquivoController {

    @Autowired
    private RelacaoGestorPorArquivoService relacaoPorIdArquivoService;

    @PostMapping("/relacaoPorIdArquivo")
    public ResponseEntity<ObjectNode> getRelacaoPorIdArquivo(@RequestBody RelacaoPorIdArquivoRequestDTO request) {
        // Obtem a lista de resposta do serviço
        List<RelacaoPorIdArquivoResponseDTO> responseList = relacaoPorIdArquivoService.getRelacaoPorIdArquivo(request.getIdArquivo());

        // Cria o ObjectMapper para manipular JSON
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Converte a lista de resposta para uma string JSON
            String jsonResponse = objectMapper.writeValueAsString(responseList);

            // Cria o nó JSON "entity" e coloca a string JSON dentro dele
            ObjectNode entityNode = objectMapper.createObjectNode();
            entityNode.put("entity", jsonResponse);

            // Adiciona os campos "status" e "metadata"
            entityNode.put("status", 200);
            entityNode.set("metadata", objectMapper.createObjectNode());

            // Retorna o JSON como uma entidade
            return ResponseEntity.ok(entityNode);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/incluirGestor")
    public ResponseEntity<JsonNode> incluirGestor(@RequestBody String gestoresJson) throws JsonMappingException, JsonProcessingException {
        boolean success = relacaoPorIdArquivoService.incluirGestores(gestoresJson);
        return success ? ResponseEntity.status(HttpStatus.CREATED).body(null) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PostMapping("/alterarGestor")
    public ResponseEntity<JsonNode> alterarGestor(@RequestBody String gestoresJson) {
        boolean success = relacaoPorIdArquivoService.alterarGestores(gestoresJson);
        return success ? ResponseEntity.status(HttpStatus.OK).body(null) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PostMapping("/excluirGestor")
    public ResponseEntity<JsonNode> excluirGestor(@RequestBody String gestoresJson) {
        boolean success = relacaoPorIdArquivoService.excluirGestores(gestoresJson);
        return success ? ResponseEntity.status(HttpStatus.OK).body(null) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}