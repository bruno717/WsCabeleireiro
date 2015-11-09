package br.com.salaodebeleza.model;

import java.util.Date;

public class ContaReceber {

	private Integer id;
	private Integer idTipoConta;
	private Integer parcelas;
	private Date dataVencimento;
	private Date dataRecebimento;
	private Integer parcelaAtual;
	private Double desconto;
	private Double juros;
	private Double valorConta;
	private Integer idVenda;
	private Double valorRecebido;

	public Double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(Double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getIdTipoConta() {
		return idTipoConta;
	}

	public void setIdTipoConta(Integer idTipoConta) {
		this.idTipoConta = idTipoConta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataPagamento) {
		this.dataRecebimento = dataPagamento;
	}

	public Integer getParcelaAtual() {
		return parcelaAtual;
	}

	public void setParcelaAtual(Integer parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getValorConta() {
		return valorConta;
	}

	public void setValorConta(Double valorConta) {
		this.valorConta = valorConta;
	}

}
