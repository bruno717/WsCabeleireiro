package br.com.salaodebeleza.model;

import java.util.List;

public class Compra {

	private Integer id;
	private Integer idFuncionario;
	private Integer idFonernecedor;
	private Integer tipoPagamento;
	private List<Produto> produtos;
	private Float valor;
	private Integer Status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getIdFonernecedor() {
		return idFonernecedor;
	}

	public void setIdFonernecedor(Integer idFonernecedor) {
		this.idFonernecedor = idFonernecedor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public Integer getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
