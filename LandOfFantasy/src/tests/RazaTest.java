package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Nortaichian;
import models.Radaiteran;
import models.Raza;
import models.Wrives;

class RazaTest {

	@Test
	void testSerAtacadoNoResultaEnDerrota() {
		Raza r = new Nortaichian();
		int ataque = 1;
		r.serAtacado(ataque);
		assertFalse(r.derrotado());
	}
	
	@Test
	void testSerAtacadoResultaEnDerrota() {
		Raza r = new Radaiteran();
		int ataque = 10000;
		r.serAtacado(ataque);
		assertTrue(r.derrotado());
	}

	@Test
	void testCompararVidaRazaIgual() {
		//Debido a que usamos una cola de prioridad para
		//determinar el orden en el que los soldados formarán
		//se debe de comparar los distintos objetos de la clase
		//Raza de acuerdo a la salud que tengan
		Raza w1 = new Wrives(); //108 hp
		Raza w2 = new Wrives(); //108 hp
		
		assertTrue(w1.compareTo(w2) == 0);
	}
	
	@Test
	void testCompararVidaRazaMenor() {
		Raza r = new Radaiteran(); 	//36 hp
		Raza w = new Wrives(); 		//108 hp
		
		assertTrue(r.compareTo(w) < 0);
	}
	
	@Test
	void testCompararVidaRazaMayor() {
		Raza w = new Wrives(); 		//108 hp
		Raza r = new Radaiteran(); 	//36 hp
		
		assertTrue(w.compareTo(r) > 0);
	}
	
	@Test
	void testBatallarGanar() {
		Raza r = new Radaiteran();
		Raza w = new Wrives();
		//Un radaiteran debería ganar esto
		assertTrue(r.batallar(w));
	}
	
	@Test
	void testBatallarPerder() {
		Raza w = new Wrives();
		Raza r = new Radaiteran();
		
		assertFalse(w.batallar(r));
	}
	
}
