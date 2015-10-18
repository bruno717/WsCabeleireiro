package br.com.salaodebeleza.model;

import java.util.List;

public class Compra {
	
	private Integer id;
	private Integer idFuncionario;
	private Integer idFonernecedor;
	private List<Produto> produtos;
	private Float valor;
	private String Status;
	
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
