package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Nortaichian;
import models.Radaiteran;
import models.Raza;
import models.Wrives;

class SoldadoTest {

	@Test
	void testSerAtacadoNoResultaEnDerrota() {
		Soldado r = new Nortaichian();
		int ataque = 1;
		r.serAtacado(ataque);
		assertFalse(r.derrotado());
	}
	
	@Test
	void testSerAtacadoResultaEnDerrota() {
		Soldado r = new Radaiteran();
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
		Soldado w1 = new Wrives(); //108 hp
		Soldado w2 = new Wrives(); //108 hp
		
		assertTrue(w1.compareTo(w2) == 0);
	}
	
	@Test
	void testCompararVidaRazaMenor() {
		Soldado r = new Radaiteran(); 	//36 hp
		Soldado w = new Wrives(); 		//108 hp
		
		assertTrue(r.compareTo(w) < 0);
	}
	
	@Test
	void testCompararVidaRazaMayor() {
		Soldado w = new Wrives(); 		//108 hp
		Soldado r = new Radaiteran(); 	//36 hp
		
		assertTrue(w.compareTo(r) > 0);
	}
	
	@Test
	void testBatallarGanar() {
		Soldado r = new Radaiteran();
		Soldado w = new Wrives();
		//Un radaiteran debería ganar esto
		assertTrue(r.batallar(w));
	}
	
	@Test
	void testBatallarPerder() {
		Soldado w = new Wrives();
		Soldado r = new Radaiteran();
		
		assertFalse(w.batallar(r));
	}
	
}
