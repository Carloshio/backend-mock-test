package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    private String chave;
    
    private String nomeGestor;
    private String email;
    private String telefone;
    private String complementoGestor;
    private String departamentoInfo;
    private String nivelReponsabilidadeGestor;    
    
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getNomeGestor() {
		return nomeGestor;
	}
	public void setNomeGestor(String nomeGestor) {
		this.nomeGestor = nomeGestor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getComplementoGestor() {
		return complementoGestor;
	}
	public void setComplementoGestor(String complementoGestor) {
		this.complementoGestor = complementoGestor;
	}
	public String getDepartamentoInfo() {
		return departamentoInfo;
	}
	public void setDepartamentoInfo(String departamentoInfo) {
		this.departamentoInfo = departamentoInfo;
	}
	public String getNivelReponsabilidadeGestor() {
		return nivelReponsabilidadeGestor;
	}
	public void setNivelReponsabilidadeGestor(String nivelReponsabilidadeGestor) {
		this.nivelReponsabilidadeGestor = nivelReponsabilidadeGestor;
	}

    // Getters e Setters
}