package com.example.demo.entity;

import java.time.LocalDateTime;

public class OscilacaoDTO {
	private int qtdAtivos;
	private int qtdRecebidos;
	private int qtdPendentes;
	private int qtdPrevistos;
	private LocalDateTime dataConsulta;

	// Getters and Setters

	public int getQtdAtivos() {
		return qtdAtivos;
	}

	public void setQtdAtivos(int qtdAtivos) {
		this.qtdAtivos = qtdAtivos;
	}

	public int getQtdRecebidos() {
		return qtdRecebidos;
	}

	public void setQtdRecebidos(int qtdRecebidos) {
		this.qtdRecebidos = qtdRecebidos;
	}

	public int getQtdPendentes() {
		return qtdPendentes;
	}

	public void setQtdPendentes(int qtdPendentes) {
		this.qtdPendentes = qtdPendentes;
	}

	public int getQtdPrevistos() {
		return qtdPrevistos;
	}

	public void setQtdPrevistos(int qtdPrevistos) {
		this.qtdPrevistos = qtdPrevistos;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
}
