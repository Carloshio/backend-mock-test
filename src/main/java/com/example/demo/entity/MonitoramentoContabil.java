package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "monitoramento_contabil")
public class MonitoramentoContabil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monitoramento_contabil")
	private Long idMonitoracaoContabil;

	@Column(name = "job_name")
	private String jobName;

	@Column(name = "rotina")
	private String rotina;

	@Column(name = "data_inicio_vigencia")
	private String dataInicioVigencia;

	@Column(name = "hora_recebimento_estimado")
	private String horaRecebimentoEstimado;

	@Column(name = "periodicidade")
	private Integer periodicidade;

	@Column(name = "tipo_movimento")
	private Integer tipoMovimento;

	@Column(name = "situacao")
	private Integer situacao;

	@Column(name = "observacao")
	private String observacoes;

	@Column(name = "usuario_manutencao")
	private String usuarioManutencao;

	@Column(name = "usuario_inclusao")
	private String usuarioInclusao;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getRotina() {
		return rotina;
	}

	public void setRotina(String rotina) {
		this.rotina = rotina;
	}

	public String getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(String dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public String getHoraRecebimentoEstimado() {
		return horaRecebimentoEstimado;
	}

	public void setHoraRecebimentoEstimado(String horaRecebimentoEstimado) {
		this.horaRecebimentoEstimado = horaRecebimentoEstimado;
	}

	public Integer getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}

	public Integer getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(Integer tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getUsuarioManutencao() {
		return usuarioManutencao;
	}

	public void setUsuarioManutencao(String usuarioManutencao) {
		this.usuarioManutencao = usuarioManutencao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Long getIdMonitoracaoContabil() {
		return idMonitoracaoContabil;
	}

	public void setIdMonitoracaoContabil(Long idMonitoracaoContabil) {
		this.idMonitoracaoContabil = idMonitoracaoContabil;
	}

	

	// Getters and Setters
}