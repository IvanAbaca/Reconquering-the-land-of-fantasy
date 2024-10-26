package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Nortaichian;

class NortaichianTest {

	static final int SALUD_INICIAL 					= 66;
	static final int SALUD_MAXIMA					= SALUD_INICIAL;
	static final int AUMENTO_SALUD_DESCANSO			= 50;
	static final int DANIO_BASICO  					= 18;
	static final int MULTIPLICADOR_ATAQUE			= 2;
	static final int PORCENTAJE_LIFE_LEECH			= 4;
	static final int REDUCCION_DANIO_RECIBIDO		= 2;
	
	@Test
	void testAtacar() {
		Nortaichian n = new Nortaichian();
		//Ocasiona un daño básico de 18 puntos
		assertEquals(DANIO_BASICO, n.atacar());
	}
	
	@Test
	void testSerAtacadoMultiplicaElDanio() {
		Nortaichian n = new Nortaichian();
		int ataque = 10;
		n.serAtacado(ataque);
		//Al recibir un ataque se enfurece y sus ataques multiplican por 2 su daño
		assertEquals(DANIO_BASICO*MULTIPLICADOR_ATAQUE, n.atacar());
	}
	
	@Test
	void testSerAtacadoEnfurecePorDosTurnos() {
		Nortaichian n = new Nortaichian();
		int ataque = 10;
		n.serAtacado(ataque);
		//Al recibir un ataque se enfurece y sus ataques 
		//multiplican por 2 su daño (dura 2 turnos propios)
		assertEquals(DANIO_BASICO*MULTIPLICADOR_ATAQUE, n.atacar());
		assertEquals(DANIO_BASICO*MULTIPLICADOR_ATAQUE, n.atacar());
		assertEquals(DANIO_BASICO, n.atacar());
	}
	
	@Test
	void testSerAtacadoReduceVida() {
		Nortaichian n = new Nortaichian();
		int ataque = 10;
		n.serAtacado(ataque);
		assertEquals(SALUD_INICIAL - ataque, n.getHp());
	}
	
	@Test
	void testAtacarCuraPorcentajeSalud() {
		Nortaichian n = new Nortaichian();
		int ataque = 30;
		int saludRestante = SALUD_INICIAL - ataque;
		n.serAtacado(ataque);
		n.atacar();
		//Cuando ataca, se cura un 4 por ciento de su salud
		//Acá dice salud, no salud máxima, son cosas distintas
		assertEquals(saludRestante + saludRestante*4/100, n.getHp());
	}
	
	@Test
	void testDescansarRecuperaTodaLaSalud() {
		Nortaichian n = new Nortaichian();
		int ataque = 60;
		n.serAtacado(ataque);
		n.descansar();
		assertEquals(SALUD_MAXIMA, n.getHp());
	}
	
	@Test
	void testDescansarReduceElDanioEntrante() {
		Nortaichian n = new Nortaichian();
		int ataque = 20;
		n.descansar();
		n.serAtacado(ataque);
		assertEquals(SALUD_INICIAL-(ataque/REDUCCION_DANIO_RECIBIDO), n.getHp());
	}
	
	@Test
	void testNoAtacaLuegoDeDescansar() {
		Nortaichian n = new Nortaichian();
		n.descansar();
		assertEquals(0, n.atacar());
	}
	
	@Test
	void testNoAtacaPorDosTurnosLuegoDeDescansar() {
		Nortaichian n = new Nortaichian();
		n.descansar();
		assertEquals(0, n.atacar());
		assertEquals(0, n.atacar());
		assertNotEquals(0, n.atacar());
	}
	
	@Test
	void testAtacarNoCuraPorEncimaDeSaludMaxima() {
		Nortaichian n = new Nortaichian();
		n.atacar();
		assertEquals(SALUD_MAXIMA, n.getHp());
	}
	
	@Test
	void testVidaNoBajaDeCero() {
		Nortaichian n = new Nortaichian();
		n.serAtacado(SALUD_INICIAL+1);
		assertEquals(0, n.getHp());
	}
}
