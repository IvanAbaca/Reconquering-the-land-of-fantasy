package tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Batallon;
import models.Ciudad;
import models.Graficos;

class GraficosTest {

	
	@Test
	void graficoTest() {
		
		Ciudad c1 = new Ciudad(new Batallon(), true, 1);
		Ciudad c2 = new Ciudad(new Batallon(), true, 2);
		Ciudad c3 = new Ciudad(new Batallon(), true, 3);
		
		List<Ciudad> ciudadesGeneral = new ArrayList<Ciudad>();
		
		ciudadesGeneral.add(c1);
		ciudadesGeneral.add(c2);
		ciudadesGeneral.add(c3);
		
        FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("NUL");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
		
		Graficos.animacionBatalla(10, 10);
		Graficos.animacionDescanso(10, 10);
		Graficos.animacionMuerte(ciudadesGeneral, 0, 0, 0);
		Graficos.animacionPartida(5, 5);
		Graficos.animacionVictoria(ciudadesGeneral, 0, 0);
		
	}

}
