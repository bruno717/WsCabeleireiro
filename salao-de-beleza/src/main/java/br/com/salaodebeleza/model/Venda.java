package br.com.salaodebeleza.model;

import java.util.List;

public class Venda {

	private Integer id;
	private Integer idUsuario;
	private Integer idTipoRecebimento;
	private List<Servico> servicos;
	private List<Produto> produtos;
	private Float valor;
	private Boolean adimplante;
	private Integer status;

	public Venda() {
	}

	public Venda(Integer idUsuario, Integer idTipoRecebimento,
			List<Servico> servicos, List<Produto> produtos, Float valor,
			Boolean adimplante, Integer status) {
		this.idUsuario = idUsuario;
		this.idTipoRecebimento = idTipoRecebimento;
		this.servicos = servicos;
		this.produtos = produtos;
		this.valor = valor;
		this.adimplante = adimplante;
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTipoRecebimento() {
		return idTipoRecebimento;
	}

	public void setIdTipoRecebimento(Integer idTipoRecebimento) {
		this.idTipoRecebimento = idTipoRecebimento;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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

	public Boolean getAdimplante() {
		return adimplante;
	}

	public void setAdimplante(Boolean adimplante) {
		this.adimplante = adimplante;
	}

}
