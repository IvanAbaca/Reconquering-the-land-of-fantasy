package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Reralopes;

class ReralopesTest {

	static final int SALUD_INICIAL			= 53;
	static final int SALUD_MAXIMA			= SALUD_INICIAL;
	static final int DANIO_BASICO			= 27;
	static final int MULTIPLICADOR_DANIO	= 2;
	
	@Test
	void testAtacarConDanioBasico() {
		Reralopes r = new Reralopes();
		assertEquals(DANIO_BASICO, r.atacar());
	}
	
	@Test
	void testRecibirAtaquesReduceSalud() {
		Reralopes r = new Reralopes();
		int ataque = 20;
		r.serAtacado(ataque);
		assertEquals(SALUD_INICIAL-ataque, r.getHp());
	}
	
	@Test
	void testSerAtacadoNoReduceLaSaludPorDebajoDeCero() {
		Reralopes r = new Reralopes();
		r.serAtacado(SALUD_INICIAL+1);
		assertEquals(0, r.getHp());
	}
	
	@Test
	void testDescansarNoRecuperaVida() {
		Reralopes r = new Reralopes();
		int ataque = 20;
		r.serAtacado(ataque);
		r.descansar();
		//Cuando descansa, se concentra y sus próximos 
		//3 ataques (de esa unidad) dañan el doble del 
		//valor correspondiente.
		//En ningún momento se menciona recuperación de hp
		assertEquals(SALUD_INICIAL-ataque, r.getHp());
	}
	
	@Test
	void testErraDosDeCadaCuatroAtaques() {
		Reralopes r = new Reralopes();
		assertEquals(DANIO_BASICO, r.atacar());
		assertEquals(DANIO_BASICO, r.atacar());
		assertEquals(0, r.atacar());
		assertEquals(0, r.atacar());
		assertEquals(DANIO_BASICO, r.atacar());
	}

	@Test
	void testDescansarAumentaDanioProximosAtaques() {
		Reralopes r = new Reralopes();
		r.descansar();
		//Cuando descansa, se concentra y sus próximos 
		//3 ataques (de esa unidad) dañan el doble 
		//del valor correspondiente.
		assertEquals(DANIO_BASICO*MULTIPLICADOR_DANIO, r.atacar());
		assertEquals(DANIO_BASICO*MULTIPLICADOR_DANIO, r.atacar());
		assertEquals(0*MULTIPLICADOR_DANIO, r.atacar()); //El tercer ataque siempre fallará
	}
	
	@Test
	void testSeDesconcentraAlSerAtacado() {
		Reralopes r = new Reralopes();
		int ataque = 10;
		
		r.descansar();
		assertEquals(DANIO_BASICO*MULTIPLICADOR_DANIO, r.atacar());
		r.serAtacado(ataque);
		assertEquals(DANIO_BASICO, r.atacar());
	}
	
}
