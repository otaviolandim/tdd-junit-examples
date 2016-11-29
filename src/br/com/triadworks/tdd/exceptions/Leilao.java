package br.com.triadworks.tdd.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances = new ArrayList<>();
	
	public Leilao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public List<Lance> getLances() {
		return lances;
	}

	/**
	 * Dar novo lance no leilão
	 */
	public void darLance(Lance lance) {
		
		if (lance.getValor() < 0)
			throw new RuntimeException("Lance com valor negativo");
		
		if (lance.getValor() == 0)
			throw new LanceInvalidoException(-2020, "Lance deve ter valor maior que zero");
		
		this.lances.add(lance);
	}
}
