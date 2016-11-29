package br.com.triadworks.tdd.exceptions;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.triadworks.tdd.exceptions.Lance;
import br.com.triadworks.tdd.exceptions.LanceInvalidoException;
import br.com.triadworks.tdd.exceptions.Leilao;

public class LeilaoTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveDarLance() {
		
		Lance lance = new Lance("Rafael", 299.99);
		
		Leilao kindle = new Leilao("Kindle Paperwhite");
		kindle.darLance(lance);
		
		assertEquals("total de lances", 1, kindle.getLances().size());
	}
	
	@Test(expected=RuntimeException.class) // jeito antigo
	public void naoDeveDarLanceQuandoValorForNegativo() {
		
		Lance lance = new Lance("Rafael", -1.99);
		
		Leilao kindle = new Leilao("Kindle Paperwhite");
		kindle.darLance(lance);
	}
	
	@Test
	public void naoDeveDarLanceQuandoValorForZero_tryCatch() {
		
		Lance lance = new Lance("Rafael", 0.0);
		Leilao kindle = new Leilao("Kindle Paperwhite");
		
		try {
			kindle.darLance(lance);
			fail("Cadê a exceção?");
		} catch (RuntimeException e) {
			assertEquals("Lance deve ter valor maior que zero", e.getMessage());
		}
	}
	
	@Test
	public void naoDeveDarLanceQuandoValorForZero() {
		
		thrown.expect(LanceInvalidoException.class);
		thrown.expectMessage("Lance deve ter valor maior que zero");
		// detalhes da exceção
		thrown.expect(hasProperty("codigoDeErro", is(-2020)));
		
		Lance lance = new Lance("Rafael", 0.0);
		
		Leilao kindle = new Leilao("Kindle Paperwhite");
		kindle.darLance(lance);
	}

}
