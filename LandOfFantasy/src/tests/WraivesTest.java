package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Wrives;

class WraivesTest {
	
	static final int SALUD_INICIAL 					= 108;
	static final int SALUD_MAXIMA_INICIAL			= SALUD_INICIAL;
	static final int AUMENTO_SALUD_DESCANSO			= 50;
	static final int AUMENTO_SALUD_MAXIMA			= AUMENTO_SALUD_DESCANSO;
	static final int DANIO_BASICO  					= 113;
	static final int MULTIPLICADOR_ATAQUE			= 2;
	static final int MULTIPLICADOR_RECIBIR_DANIO	= 2;
	
	@Test
	void testAtacar() {
		Wrives w = new Wrives();
		
		//Se rehúsa a atacar hasta que lo ataquen
		assertEquals(0, w.atacar());
	}

	@Test
	void testSerAtacado() {
		Wrives w = new Wrives();
		int ataque = 50;
		
		w.serAtacado(ataque);
		
		//Como no lleva armadura, recibe 2 veces el daño
		assertEquals(SALUD_INICIAL-ataque*2, w.getHp());
	}
	
	@Test
	void testAtacarLuegoDeSerAtacado() {
		Wrives w = new Wrives();
		
		w.atacar();
		w.serAtacado(DANIO_BASICO);
		//Solo puede atacar luego de ser atacado
		assertEquals(DANIO_BASICO, w.atacar());
	}
	
	@Test
	void testAtaqueConBonificadorCadaDosAtaques() {
		Wrives w = new Wrives();
		int ataque = 0;
		
		w.serAtacado(ataque);
		w.atacar();
		//Cuando ataca, lo hace con 2 veces su daño, cada 2 ataques
		assertEquals(DANIO_BASICO*MULTIPLICADOR_ATAQUE, w.atacar());
	}
	
	@Test
	void testDescansarAumentaMaxHP() {
		Wrives w = new Wrives();
		w.descansar();
		//Cuando descansa, medita
		//Gracias a esto, aumenta su salud y su salud máxima en 50.
		assertEquals(SALUD_MAXIMA_INICIAL+AUMENTO_SALUD_MAXIMA, w.getMaxhp());
	}
	
	@Test
	void testDescansarLuegoDeSerAtacadoAumentaHP() {
		Wrives w = new Wrives();
		int ataque = 50;
		w.serAtacado(ataque);
		w.descansar();
		//Al descansar aumenta su salud en 50.
		assertEquals(SALUD_INICIAL-(ataque*2)+AUMENTO_SALUD_DESCANSO, w.getHp()); //No olvidemos que recibe el doble de daño por no usar armadura
	}
	
	@Test
	void testNoAtacarLuegoDeDescansar() {
		Wrives w = new Wrives();
		int ataque = 0;
		
		w.serAtacado(ataque);
		assertEquals(DANIO_BASICO, w.atacar());
		w.descansar();
		//Cuando descansa, medita, y como considera la violencia  
		//como algo malo, se rehúsa a atacar hasta que lo ataquen
		assertEquals(0, w.atacar());
	}
	
	@Test
	void testGetAtkBasico() {
		Wrives w = new Wrives();
		assertEquals(DANIO_BASICO, w.getAtk());
	}
}
