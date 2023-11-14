package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import n1_02LetraDNI.CalculoDni;

public class CalculoDniTest {

	@ParameterizedTest
	@CsvSource({ "53032661, C", "45678993, G", "34567882, D", "23246758, Z", "27684593, E", "65478392, Z",
			"45367298, M", "23456790, X", "23478694, H", "15634593, K" })

	public void calcularLetraDniTest(int numeroDni, char letraCorrecta) {

		String dni = CalculoDni.calcularLetraDni(numeroDni);
		
		char letraDniCalculada = dni.charAt(8);

		assertEquals(letraCorrecta, letraDniCalculada);
	}

}
