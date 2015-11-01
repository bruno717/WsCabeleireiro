package br.com.salaodebeleza.model;

public class Produto {

	private Integer id;
	private Integer tipoProduto;
	private String nome;
	private String fabricante;
	private String descricao;
	private Float preco;
	
	

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, Integer tipoProduto, String nome,
			String fabricante, String descricao, Float preco) {
		super();
		this.id = id;
		this.tipoProduto = tipoProduto;
		this.nome = nome;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Integer tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
