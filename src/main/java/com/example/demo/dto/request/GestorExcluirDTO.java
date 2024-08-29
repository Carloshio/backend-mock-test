package com.example.demo.dto.request;

public class GestorExcluirDTO {
	private String chaveUsuarioResponsavel;
	private Long idMonitoramentoContabil;

	// Getters and Setters
	public Long getIdMonitoramentoContabil() {
		return idMonitoramentoContabil;
	}

	public void setIdMonitoramentoContabil(Long idMonitoramentoContabil) {
		this.idMonitoramentoContabil = idMonitoramentoContabil;
	}

	public String getChaveUsuarioResponsavel() {
		return chaveUsuarioResponsavel;
	}

	public void setChaveUsuarioResponsavel(String chaveUsuarioResponsavel) {
		this.chaveUsuarioResponsavel = chaveUsuarioResponsavel;
	}
}
