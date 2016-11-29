package br.com.triadworks.tdd.exceptions;

public class Lance {

	private String cliente;
	private Double valor;
	
	public Lance(String cliente, Double valor) {
		this.cliente = cliente;
		this.valor = valor;
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
