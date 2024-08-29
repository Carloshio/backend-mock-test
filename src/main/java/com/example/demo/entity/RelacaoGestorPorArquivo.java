package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "relacao_gestor_por_arquivo") // Certifique-se de que o nome da tabela esteja correto
public class RelacaoGestorPorArquivo {
	
	@Id
	@Column(name = "id_gestor")
	private Long id;
	
	@Column(name = "id_monitoramento_contabil")
	private Long idMonitoramentoContabil;

    @Column(name = "chave_usuario_responsavel")
    private String chaveUsuarioResponsavel;

    @Column(name = "ordem_acionamento_responsavel")
    private Integer ordemAcionamentoResponsavel;
    
    @Column(name = "observacao")
    private String observacao;
    
    @Column(name = "usuario_inclusao")
    private String usuarioInclusao;
    
    @Column(name = "hora_inclusaoRegistro")
    private String horaInclusaoRegistro;
    
  
	public String getChaveUsuarioResponsavel() {
		return chaveUsuarioResponsavel;
	}
	public void setChaveUsuarioResponsavel(String chaveUsuarioResponsavel) {
		this.chaveUsuarioResponsavel = chaveUsuarioResponsavel;
	}
	public Integer getOrdemAcionamentoResponsavel() {
		return ordemAcionamentoResponsavel;
	}
	public void setOrdemAcionamentoResponsavel(Integer ordemAcionamentoResponsavel) {
		this.ordemAcionamentoResponsavel = ordemAcionamentoResponsavel;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}
	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}
	public String getHoraInclusaoRegistro() {
		return horaInclusaoRegistro;
	}
	public void setHoraInclusaoRegistro(String horaInclusaoRegistro) {
		this.horaInclusaoRegistro = horaInclusaoRegistro;
	}
	public Long getIdMonitoramentoContabil() {
		return idMonitoramentoContabil;
	}
	public void setIdMonitoramentoContabil(Long idMonitoramentoContabil) {
		this.idMonitoramentoContabil = idMonitoramentoContabil;
	}

    // Getters and Setters
	
	public RelacaoGestorPorArquivo() {
		super();
	}
	
	public RelacaoGestorPorArquivo(String chaveUsuarioResponsavel, Long idMonitoramentoContabil) {
		super();
		this.chaveUsuarioResponsavel = chaveUsuarioResponsavel;
		this.idMonitoramentoContabil = idMonitoramentoContabil;
	}

}