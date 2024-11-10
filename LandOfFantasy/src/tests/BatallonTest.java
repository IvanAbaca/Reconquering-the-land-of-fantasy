package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Batallon;
import models.Radaiteran;
import models.Soldado;
import models.Unidad;

public class BatallonTest {

	@Test
    public void testSumarMitadTropas() {
		
		Batallon batallon = new Batallon();
	    Soldado soldado1 = new Radaiteran();
	    Soldado soldado2= new Radaiteran();
		
        batallon.agregarUnidad(soldado1);
        batallon.agregarUnidad(soldado2);
        
        Unidad mitadBatallon = batallon.sumarMitadTropas();
        assertNotNull(mitadBatallon);

        Batallon nuevoBatallon = (Batallon) mitadBatallon;
        assertEquals(1, nuevoBatallon.Obtenerbatallon().size());
    }

}
