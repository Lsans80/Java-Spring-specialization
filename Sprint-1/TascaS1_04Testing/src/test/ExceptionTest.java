package test;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

	@Test
	public void exceptionTest() {

		ArrayList<Integer> numero = new ArrayList<Integer>();
		numero.add(3);

		// Aquí estamos probando si se lanza ArrayIndexOutOfBoundsException
		assertThrows(IndexOutOfBoundsException.class, () -> {
			int fueraIndice = numero.get(1); // Esto provocará una excepción
		});

	}

}
