package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import models.Batallon;
import models.Ciudad;
import models.Radaiteran;
import models.Reralopes;
import models.Soldado;
import models.Unidad;
import models.Wrives;

public class BatallonTest {

	@Test
    public void testSumarMitadTropas() {
		
		Soldado soldado1 = new Radaiteran();
		Soldado soldado2= new Radaiteran();
		Batallon batallon = new Batallon(soldado1);
		
        batallon.agregarUnidad(soldado2);
        
        Unidad mitadBatallon = batallon.sumarMitadTropas();
        Unidad soldadoDeCiudad = soldado1.sumarMitadTropas();
        
        assertEquals(soldadoDeCiudad, soldado1);
        assertEquals(batallon.Obtenerbatallon().size(), ((Batallon) mitadBatallon).Obtenerbatallon().size());

        Batallon nuevoBatallon = (Batallon) mitadBatallon;
        assertEquals(1, nuevoBatallon.Obtenerbatallon().size());
    }
	
	@Test
	public void operarBatallon() {
		// Arrange
		Batallon batallon = new Batallon();
		Soldado soldado1 = new Radaiteran();
		Soldado soldado2 = new Radaiteran();
		Soldado soldado3 = new Radaiteran();
		Unidad aux;
		
		// Act
		batallon.agregarUnidad(soldado1); 	// Agrego 3 unidades
		batallon.agregarUnidad(soldado2);
		batallon.agregarUnidad(soldado3);
		
		
		batallon.quitarUnidad(soldado3); 	// Mato al soldado 3
		aux = batallon.obtenerUnidad();		// Lastimo al soldado 1
		aux.serAtacado(1);
		
		// Assert
		// El orden deberia ser soldadoq-soldado2
		assertEquals(batallon.obtenerCantTropas(), 2);
		assertEquals((Soldado)batallon.obtenerUnidad(), soldado1);
    }
	
	@Test
	public void batallarVictoria() {
		// Arrange
		Batallon pekkas = new Batallon();
		for(int i=0; i<10; i++)
			pekkas.agregarUnidad(new Reralopes());
		
		Batallon enemigo = new Batallon();
		Radaiteran duende = new Radaiteran();
		Wrives mago = new Wrives();
		
		enemigo.agregarUnidad(mago);
		enemigo.agregarUnidad(duende);
		
		// Act
		boolean resultado = pekkas.batallar(enemigo);
		
		// Assert
		assertTrue(resultado);
    }
	
	@Test
	public void batallarDerrota() {
		// Arrange
		Batallon pekkas = new Batallon();
		for(int i=0; i<10; i++)
			pekkas.agregarUnidad(new Reralopes());
		
		Batallon enemigo = new Batallon();
		Radaiteran duende = new Radaiteran();
		Wrives mago = new Wrives();
		
		enemigo.agregarUnidad(mago);
		enemigo.agregarUnidad(duende);
		
		// Act
		boolean resultado = enemigo.batallar(pekkas);
		
		// Assert
		
		assertFalse(resultado);
		assertEquals(enemigo.toString(), "Ejercito [aliados=[]]");
    }
	
	@Test
	public void encuentroAliado() {
		// Arrange
		Batallon pekkas = new Batallon();
		for(int i=0; i<10; i++)
			pekkas.agregarUnidad(new Reralopes());
		
		Batallon aliado = new Batallon();
		Radaiteran duende = new Radaiteran();
		Wrives mago = new Wrives();
		
		aliado.agregarUnidad(mago);
		aliado.agregarUnidad(duende);
		
		Ciudad ciudad = new Ciudad(aliado, true, 1);
		
		// Act
		pekkas.encuentro(ciudad);
		
		// Assert
		assertEquals(11, pekkas.obtenerCantTropas());
    }
	
	@Test
	public void encuentroEnemigo() {
		// Arrange
		Batallon pekkas = new Batallon();
		for(int i=0; i<10; i++)
			pekkas.agregarUnidad(new Reralopes());
		
		Batallon aliado = new Batallon();
		Radaiteran duende = new Radaiteran();
		Wrives mago = new Wrives();
		
		aliado.agregarUnidad(mago);
		aliado.agregarUnidad(duende);
		
		Ciudad ciudad = new Ciudad(aliado, false, 1);
		
		// Act
		pekkas.encuentro(ciudad);
		
		// Assert
		assertEquals(8, pekkas.obtenerCantTropas()); //Mueren 2 pekkas :c
    }
	


}
