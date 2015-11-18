package br.com.salaodebeleza.dto;

public class RelatorioDTO {

	private Integer qtdClientes;
	private String produtoMaisVendidoNome;
	private Integer produtoMaisVendidoQtd;
	private String produtoMenosVendidoNome;
	private Integer produtoMenosVendidoQtd;
	private String servicoMaisProcuradoNome;
	private Integer servicoMaisProcuradoQtd;
	private String funcionarioMaisAtendeuNome;
	private Integer funcionarioMaisAtendeuQtd;
	private Integer qtdAgendamentos;

	public Integer getQtdClientes() {
		return qtdClientes;
	}

	public void setQtdClientes(Integer qtdClientes) {
		this.qtdClientes = qtdClientes;
	}

	public String getProdutoMaisVendidoNome() {
		return produtoMaisVendidoNome;
	}

	public void setProdutoMaisVendidoNome(String produtoMaisVendidoNome) {
		this.produtoMaisVendidoNome = produtoMaisVendidoNome;
	}

	public Integer getProdutoMaisVendidoQtd() {
		return produtoMaisVendidoQtd;
	}

	public void setProdutoMaisVendidoQtd(Integer produtoMaisVendidoQtd) {
		this.produtoMaisVendidoQtd = produtoMaisVendidoQtd;
	}

	public String getProdutoMenosVendidoNome() {
		return produtoMenosVendidoNome;
	}

	public void setProdutoMenosVendidoNome(String produtoMenosVendidoNome) {
		this.produtoMenosVendidoNome = produtoMenosVendidoNome;
	}

	public Integer getProdutoMenosVendidoQtd() {
		return produtoMenosVendidoQtd;
	}

	public void setProdutoMenosVendidoQtd(Integer produtoMenosVendidoQtd) {
		this.produtoMenosVendidoQtd = produtoMenosVendidoQtd;
	}

	public String getServicoMaisProcuradoNome() {
		return servicoMaisProcuradoNome;
	}

	public void setServicoMaisProcuradoNome(String servicoMaisProcuradoNome) {
		this.servicoMaisProcuradoNome = servicoMaisProcuradoNome;
	}

	public Integer getServicoMaisProcuradoQtd() {
		return servicoMaisProcuradoQtd;
	}

	public void setServicoMaisProcuradoQtd(Integer servicoMaisProcuradoQtd) {
		this.servicoMaisProcuradoQtd = servicoMaisProcuradoQtd;
	}

	public String getFuncionarioMaisAtendeuNome() {
		return funcionarioMaisAtendeuNome;
	}

	public void setFuncionarioMaisAtendeuNome(String funcionarioMaisAtendeuNome) {
		this.funcionarioMaisAtendeuNome = funcionarioMaisAtendeuNome;
	}

	public Integer getFuncionarioMaisAtendeuQtd() {
		return funcionarioMaisAtendeuQtd;
	}

	public void setFuncionarioMaisAtendeuQtd(Integer funcionarioMaisAtendeuQtd) {
		this.funcionarioMaisAtendeuQtd = funcionarioMaisAtendeuQtd;
	}

	public Integer getQtdAgendamentos() {
		return qtdAgendamentos;
	}

	public void setQtdAgendamentos(Integer qtdAgendamentos) {
		this.qtdAgendamentos = qtdAgendamentos;
	}

}
