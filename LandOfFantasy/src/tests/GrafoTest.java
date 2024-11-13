package tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.Batallon;
import models.Ciudad;
import utils.Grafo;

class GrafoTest {

	@Test
	void caminoCompleto() {
		
		//Arrange
		Grafo g = new Grafo();
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		List<Ciudad> ciudadesExpected = new ArrayList<Ciudad>();		
		Map<Ciudad, Integer> distancia = new HashMap<Ciudad, Integer>();
		Map<Ciudad, Ciudad> predecesores = new HashMap<Ciudad, Ciudad>();
		Ciudad c1 = new Ciudad(new Batallon(), true, 1);
		Ciudad c2 = new Ciudad(new Batallon(), true, 2);
		Ciudad c3 = new Ciudad(new Batallon(), true, 3);
		Ciudad c4 = new Ciudad(new Batallon(), true, 4);
		Ciudad c5 = new Ciudad(new Batallon(), true, 5);
		
		
		//Act
		g.agregarArista(c1, c2, 100);
		g.agregarArista(c1, c3, 101);
		g.agregarArista(c3, c4, 2);
		g.agregarArista(c2, c4, 4);
		g.agregarArista(c4, c5, 2);
		g.agregarArista(c3, c5, 5);
		
		ciudades = g.obtenerCamino(c1, c5);
		ciudadesExpected.add(c1);
		ciudadesExpected.add(c3);
		ciudadesExpected.add(c4);
		ciudadesExpected.add(c5);
		
        FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("NUL");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
		g.mostrarGrafo();
		
		//Assert
		Assertions.assertIterableEquals(ciudadesExpected, ciudades);
		
	}
	
	@Test
	void caminoDistancia0() {
		
		//Arrange
		Grafo g = new Grafo();
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		List<Ciudad> ciudadesExpected = new ArrayList<Ciudad>();
		
		Map<Ciudad, Integer> distancia = new HashMap<Ciudad, Integer>();
		Map<Ciudad, Ciudad> predecesores = new HashMap<Ciudad, Ciudad>();
		Ciudad c1 = new Ciudad(new Batallon(), true, 1);
		Ciudad c2 = new Ciudad(new Batallon(), true, 2);
		Ciudad c3 = new Ciudad(new Batallon(), true, 3);
		Ciudad c4 = new Ciudad(new Batallon(), true, 4);
		Ciudad c5 = new Ciudad(new Batallon(), true, 5);
		
		
		//Act
		g.agregarArista(c1, c1, 0);
		g.agregarArista(c1, c2, 100);
		g.agregarArista(c1, c3, 101);
		g.agregarArista(c3, c4, 2);
		g.agregarArista(c2, c4, 4);
		g.agregarArista(c4, c5, 2);
		g.agregarArista(c3, c5, 5);
		
		ciudades = g.obtenerCamino(c1, c1);
		ciudadesExpected.add(c1);
		
		//Assert
		Assertions.assertIterableEquals(ciudadesExpected, ciudades);
		
	}

	
}
