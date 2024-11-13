package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Radaiteran;

class RadaiteranTest {

	static final int SALUD_INICIAL	= 36;
	static final int SALUD_MAXIMA	= SALUD_INICIAL;
	static final int DANIO_BASICO	= 56;
	static final int AUMENTO_DANIO	= 3;
	
	@Test
	void testAtacarConDanioBase() {
		Radaiteran r = new Radaiteran();
		assertEquals(DANIO_BASICO, r.atacar());
	}
	
	@Test
	void testSerAtacadoReduceVidaIgualAlAtaque() {
		Radaiteran r = new Radaiteran();
		int ataque = 20;
		r.serAtacado(ataque);
		//Al recibir un ataque lo hace normalmente.
		assertEquals(SALUD_INICIAL-ataque, r.getHp());
	}
	
	@Test
	void testSerAtacadoNoReduceLaSaludPorDebajoDeCero() {
		Radaiteran r = new Radaiteran();
		r.serAtacado(SALUD_MAXIMA+1);
		assertEquals(0, r.getHp());
	}
	
	@Test
	void testDescansarNoRecuperaSalud() {
		Radaiteran r = new Radaiteran();
		int ataque = 10;
		r.serAtacado(ataque);
		r.descansar();
		//Cuando descansa, no le sucede nada.
		assertEquals(SALUD_INICIAL-ataque, r.getHp());
	}

	@Test
	void testAumentaDanioPorCadaAtaqueDado() {
		Radaiteran r = new Radaiteran();
		//Cuando ataca, lo hace cada vez con más fuerza 
		//(3 de daño EXTRA x la cantidad de ataques dados)
		for(int i = 0 ; i<100 ; i++)
			assertEquals(DANIO_BASICO+i*AUMENTO_DANIO, r.atacar());
	}
	
	@Test
	void testGetAtkBasico() {
		Radaiteran r = new Radaiteran();
		assertEquals(DANIO_BASICO, r.getAtk());
	}
	
}
