package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.GestorExcluirDTO;
import com.example.demo.dto.response.RelacaoPorIdArquivoResponseDTO;
import com.example.demo.entity.RelacaoGestorPorArquivo;
import com.example.demo.repository.RelacaoGestorPorArquivoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RelacaoGestorPorArquivoService {

	@Autowired
	private RelacaoGestorPorArquivoRepository relacaoGestorPorArquivoRepository;

	public List<RelacaoPorIdArquivoResponseDTO> getRelacaoPorIdArquivo(Long idMonitoramentoContabil) {
		List<RelacaoGestorPorArquivo> entities = relacaoGestorPorArquivoRepository
				.findByIdMonitoramentoContabil(idMonitoramentoContabil);
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

	private RelacaoPorIdArquivoResponseDTO toDto(RelacaoGestorPorArquivo entity) {
		RelacaoPorIdArquivoResponseDTO dto = new RelacaoPorIdArquivoResponseDTO();
		dto.setChaveUsuarioResponsavel(entity.getChaveUsuarioResponsavel());
		dto.setIdMonitoracaoArquivo(entity.getIdMonitoramentoContabil());
		dto.setOrdemAcionamentoResponsavel(entity.getOrdemAcionamentoResponsavel());
		dto.setObservacao(entity.getObservacao());
		dto.setUsuarioInclusao(entity.getUsuarioInclusao());
		dto.setHoraInclusaoRegistro(entity.getHoraInclusaoRegistro());
		return dto;
	}

	private final ObjectMapper objectMapper = new ObjectMapper();

	private List<RelacaoGestorPorArquivo> parseGestores(String gestoresJson) throws IOException {
		JsonNode jsonNode = objectMapper.readTree(gestoresJson);
		String listaGestorDtoJson = jsonNode.get("listaGestorDto").asText();

		return objectMapper.readValue(listaGestorDtoJson, new TypeReference<List<RelacaoGestorPorArquivo>>() {
		});
	}

	public boolean incluirGestores(String gestoresJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserializar a lista de gestores
            List<RelacaoGestorPorArquivo> gestores = objectMapper.readValue(
                gestoresJson,
                new TypeReference<List<RelacaoGestorPorArquivo>>() {}
            );
            
            // Salvar todos os gestores no banco de dados
            relacaoGestorPorArquivoRepository.saveAll(gestores);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean alterarGestores(String gestoresJson) {
		try {
			List<RelacaoGestorPorArquivo> gestores = parseGestores(gestoresJson);
			for (RelacaoGestorPorArquivo gestor : gestores) {
				Optional<RelacaoGestorPorArquivo> existingGestor = relacaoGestorPorArquivoRepository
						.findById(gestor.getIdMonitoramentoContabil());
				if (existingGestor.isPresent()) {
					RelacaoGestorPorArquivo gestorAtualizado = existingGestor.get();
					gestorAtualizado.setOrdemAcionamentoResponsavel(gestor.getOrdemAcionamentoResponsavel());
					gestorAtualizado.setObservacao(gestor.getObservacao());
					// Atualize outros campos conforme necessário
					relacaoGestorPorArquivoRepository.save(gestorAtualizado);
				}
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluirGestores(String gestoresJson) {
		try {
			JsonNode jsonNode = objectMapper.readTree(gestoresJson);
			String listaGestorDtoJson = jsonNode.get("listaGestorDto").asText();
			List<GestorExcluirDTO> gestores = objectMapper.readValue(listaGestorDtoJson,
					new TypeReference<List<GestorExcluirDTO>>() {
					});
			List<RelacaoGestorPorArquivo> gestoresParaExcluir = gestores.stream()
					.map(dto -> new RelacaoGestorPorArquivo(dto.getChaveUsuarioResponsavel(),
							dto.getIdMonitoramentoContabil())) // Ajuste conforme necessário
					.collect(Collectors.toList());
			relacaoGestorPorArquivoRepository.deleteAll(gestoresParaExcluir);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}