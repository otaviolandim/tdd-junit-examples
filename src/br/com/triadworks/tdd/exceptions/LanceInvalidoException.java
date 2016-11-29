package br.com.triadworks.tdd.exceptions;

public class LanceInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int codigoDeErro;

	public LanceInvalidoException(int codigoDeErro, String mensagem) {
		super(mensagem);
		this.codigoDeErro = codigoDeErro;
	}
	
	public int getCodigoDeErro() {
		return codigoDeErro;
	}
	
}
