package com.example.demo.controller;

import com.example.demo.entity.MonitoramentoContabil;
import com.example.demo.service.MonitoramentoContabilService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
@RequestMapping("/api")
public class MonitoramentoContabilController {

	@Autowired
	private MonitoramentoContabilService service;

	@PostMapping("/inclusao")
	public ResponseEntity<MonitoramentoContabil> create(@RequestBody MonitoramentoContabil monitoramentoContabil) {
		MonitoramentoContabil createdMonitoramentoContabil = service.save(monitoramentoContabil);

		return ResponseEntity.status(201).body(createdMonitoramentoContabil);
	}

	@GetMapping("/todos")
	public ResponseEntity<Map<String, Object>> getAll() {
		List<MonitoramentoContabil> list = service.findAll();
		Map<String, Object> formattedContent = content(list);

		return ResponseEntity.ok(formattedContent);
	}

	@PostMapping("/filtrarArquivo")
	public ResponseEntity<ObjectNode> getByJobName(@RequestBody Map<String, Object> requestBody) {
	    // Extrai o mapa "filtroMonitoracaoArquivo" do corpo da requisição
	    Map<String, Object> filtroMonitoracaoArquivo = (Map<String, Object>) requestBody.get("filtroMonitoracaoArquivo");

	    // Obtém os valores de jobName, rotina e page do filtro
	    String jobName = (String) filtroMonitoracaoArquivo.get("jobName");
	    String rotina = (String) filtroMonitoracaoArquivo.get("rotina");
	    Integer page = (Integer) filtroMonitoracaoArquivo.get("page");

	    // Filtra os registros pelo jobName e rotina (você pode adicionar lógica para paginação com "page")
	    List<MonitoramentoContabil> list = service.findAll(); // Adapte o filtro conforme necessário

	    if (list.isEmpty()) {
	        return ResponseEntity.noContent().build(); // Retorna 204 No Content se não encontrar nenhum registro
	    }

	    // Cria o ObjectMapper para converter a lista para JSON
	    ObjectMapper objectMapper = new ObjectMapper();

	    // Cria o nó JSON para o conteúdo
	    ObjectNode rootNode = objectMapper.createObjectNode();
	    rootNode.set("content", objectMapper.valueToTree(list.stream().map(item -> {
	        ObjectNode itemNode = objectMapper.createObjectNode();
	        itemNode.put("idMonitoracaoArquivo", item.getIdMonitoracaoContabil()); // Ajuste conforme necessário
	        itemNode.put("rotina", item.getRotina());
	        itemNode.put("jobName", item.getJobName());
	        itemNode.put("dataInicioVigencia", item.getDataInicioVigencia()); // Formatação ajustada
	        itemNode.put("horaRecebimentoEstimado", item.getHoraRecebimentoEstimado()); // Formatação ajustada
	        itemNode.put("periodicidade", item.getPeriodicidade());
	        itemNode.put("observacao", item.getObservacoes()); // Ajuste conforme necessário
	        itemNode.put("tipoMovimento", item.getTipoMovimento());
	        itemNode.put("situacao", item.getSituacao()); // Ajuste conforme necessário
	        itemNode.put("dataHoraSituacao", ""); // Formatação ajustada
	        itemNode.put("usuarioInclusao", item.getUsuarioInclusao());
	        itemNode.put("usuarioManutencao", item.getUsuarioManutencao());
	        itemNode.put("dataInclusaoRegistro", ""); // Formatação ajustada
	        itemNode.put("dataHoraManutencaoRegistro", ""); // Formatação ajustada
	        return itemNode;
	    }).collect(Collectors.toList())));

	    // Adiciona informações de paginação
	    ObjectNode pageableNode = objectMapper.createObjectNode();
	    pageableNode.put("pageNumber", 0);
	    pageableNode.put("pageSize", 10); // Ajuste conforme necessário
	    pageableNode.put("sort", objectMapper.createObjectNode()
	            .put("empty", true)
	            .put("sorted", false)
	            .put("unsorted", true));
	    pageableNode.put("offset", 0);
	    pageableNode.put("paged", true);
	    pageableNode.put("unpaged", false);

	    rootNode.set("pageable", pageableNode);
	    rootNode.put("last", true); // Ajuste conforme necessário
	    rootNode.put("totalPages", 1); // Ajuste conforme necessário
	    rootNode.put("totalElements", 1); // Ajuste conforme necessário
	    rootNode.put("first", true); // Ajuste conforme necessário
	    rootNode.put("size", 10); // Ajuste conforme necessário
	    rootNode.put("number", 0); // Ajuste conforme necessário
	    rootNode.put("numberOfElements", 1); // Ajuste conforme necessário
	    rootNode.put("empty", false); // Ajuste conforme necessário

	    try {
	        // Converte o nó JSON para string JSON
	        String jsonResponse = objectMapper.writeValueAsString(rootNode);

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


	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteByJobName(@RequestBody String jobName) {
		service.deleteByJobName(jobName);
		return ResponseEntity.noContent().build();
	}

	private Map<String, Object> content(List<MonitoramentoContabil> value) {
		List<Map<String, Object>> contentList = new ArrayList<>();

		for (MonitoramentoContabil item : value) {
			Map<String, Object> contentMap = new HashMap<>();
			contentMap.put("jobName", item.getJobName());
			contentMap.put("rotina", item.getRotina());
			contentMap.put("dataInicioVigencia", item.getDataInicioVigencia());
			contentMap.put("horaRecebimentoEstimado", item.getHoraRecebimentoEstimado());
			contentMap.put("periodicidade", item.getPeriodicidade());
			contentMap.put("tipoMovimento", item.getTipoMovimento());
			contentMap.put("observacoes", item.getObservacoes());
			contentMap.put("usuarioManutencao", item.getUsuarioManutencao());
			contentMap.put("usuarioInclusao", item.getUsuarioInclusao());

			contentList.add(contentMap);
		}

		// Retorna um único mapa com a chave "content" e a lista de objetos como valor
		Map<String, Object> wrapperMap = new HashMap<>();
		wrapperMap.put("content", contentList);

		return wrapperMap;
	}

}
