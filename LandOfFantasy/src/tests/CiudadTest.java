package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import models.Batallon;
import models.Ciudad;
import models.Unidad;

class CiudadTest {

	@Test
	void distancia() {
		
		// Arrange
		Ciudad ciudad = new Ciudad(new Batallon(), false, 1);
		
		// Act
		ciudad.setDistancia(10);
		int distancia = ciudad.getDistancia();
		
		// Assert
		assertEquals("(1)", ciudad.toString());
		assertEquals(10, distancia);
	}
	
	@Test
	void getters() {
		
		// Arrange
		Batallon unidad = new Batallon();
		Ciudad ciudad = new Ciudad(unidad, false, 1);
		int numero = ciudad.getNumero();
		Unidad unidades = ciudad.getEjercito();
		boolean isAliado = ciudad.isAliado();
		
		// Assert
		assertEquals(1, numero);
		assertEquals(unidad, unidades);
		assertEquals(false, isAliado);
	}
	

}
