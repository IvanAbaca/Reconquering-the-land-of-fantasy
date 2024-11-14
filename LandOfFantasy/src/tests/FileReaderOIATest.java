package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Batallon;
import models.Ciudad;
import models.LectorArchivoPoblados;
import models.Mapa;
import utils.FileReaderOIA;

class FileReaderOIATest {

	@Test
	void testFileRedaer() {
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		Mapa map = Mapa.getMapa();
		
		lector.fileReader(archivo, "LandOfFantasy/src/files/", "pueblosTest.in");
		
		List<Ciudad> caminoReal = map.getPoblados().obtenerCamino(map.getPuebloInicial(), map.getPuebloFinal());	
		List<Ciudad> caminoEsperado = new ArrayList<Ciudad>();
		Ciudad c1 = new Ciudad(new Batallon(), true, 1);
		Ciudad c3 = new Ciudad(new Batallon(), true, 3);
		Ciudad c4 = new Ciudad(new Batallon(), true, 4);
		Ciudad c5 = new Ciudad(new Batallon(), true, 5);
		
		caminoEsperado.add(c1);
		caminoEsperado.add(c3);
		caminoEsperado.add(c4);
		caminoEsperado.add(c5);
		
		
		for(int i = 0; i < 4; i++) {
			assertEquals(caminoEsperado.get(i).getNumero(),caminoReal.get(i).getNumero());
		}
			
	}
	
	
	@Test
	void testFileRedaerErrorPueblo() {
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
        assertThrows(IllegalArgumentException.class, () -> {
            lector.fileReader(archivo, "LandOfFantasy/src/files/", "pueblosTestErrorPueblo.in");
        });
	}
	
	
	@Test
	void testFileReaderErrorRaza() {
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
        assertThrows(IllegalArgumentException.class, () -> {
            lector.fileReader(archivo, "LandOfFantasy/src/files/", "pueblosTestErrorRaza.in");
        });
		
	}
}
