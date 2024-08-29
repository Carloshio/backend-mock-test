package com.example.demo.dto.response;

public class RelacaoPorIdArquivoResponseDTO {
    private String chaveUsuarioResponsavel;
    private Long idMonitoracaoArquivo;
    private Integer ordemAcionamentoResponsavel;
    private String observacao;
    private String usuarioInclusao;
    private String horaInclusaoRegistro;

    // Getters and Setters
    public String getChaveUsuarioResponsavel() {
        return chaveUsuarioResponsavel;
    }

    public void setChaveUsuarioResponsavel(String chaveUsuarioResponsavel) {
        this.chaveUsuarioResponsavel = chaveUsuarioResponsavel;
    }

    public Long getIdMonitoracaoArquivo() {
        return idMonitoracaoArquivo;
    }

    public void setIdMonitoracaoArquivo(Long idMonitoracaoArquivo) {
        this.idMonitoracaoArquivo = idMonitoracaoArquivo;
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
}