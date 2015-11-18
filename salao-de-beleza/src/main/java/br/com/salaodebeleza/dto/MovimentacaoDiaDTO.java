package br.com.salaodebeleza.dto;

public class MovimentacaoDiaDTO {

	private Double gastoTotal;
	private Double recebimentoTotal;
	private Double valorLiquidoTotal;

	public MovimentacaoDiaDTO() {
		this.gastoTotal = 0D;
		this.recebimentoTotal = 0D;
		this.valorLiquidoTotal = 0D;
	}

	public Double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(Double gastoTotal) {
		this.gastoTotal = this.gastoTotal + gastoTotal;
	}

	public Double getRecebimentoTotal() {
		return recebimentoTotal;
	}

	public void setRecebimentoTotal(Double recebimentoTotal) {
		this.recebimentoTotal = this.recebimentoTotal + recebimentoTotal;
	}

	public Double getValorLiquidoTotal() {
		return valorLiquidoTotal;
	}

	public void setValorLiquidoTotal(Double valorLiquidoTotal) {
		this.valorLiquidoTotal = this.valorLiquidoTotal + valorLiquidoTotal;
	}

}
