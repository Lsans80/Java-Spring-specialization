package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import n1_01Meses.Mes;
import n1_01Meses.N1_01Meses;

public class N1_01MesesTest {

	List<Mes> meses = new ArrayList<>();

	@Test
	public void posicionesLista() {

		meses = N1_01Meses.agregarMeses(meses);

		assertEquals(12, meses.size());// (Lo que esperamos, Lo que es). Tiene 12 posiciones.

	}

	@Test
	public void notNullLista() {

		meses = N1_01Meses.agregarMeses(meses);

		assertNotNull(meses);// Que no este vacia nuestra List.

	}

	@Test
	public void posicion8Lista() {

		meses = N1_01Meses.agregarMeses(meses);

		assertEquals("Agosto", meses.get(7).getMes());// (Lo que esperamos, Lo que es). Tiene Agosto en posiciín 8.

	}

}
