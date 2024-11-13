package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import models.LectorArchivoPoblados;
import utils.FileReaderOIA;

class FileReaderOIATest {

	@Test
	void testFileRedaer() {
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
		lector.fileReader(archivo, "LandOfFantasy/src/files/", "pueblosTest.in");
		
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
	
	/*
	@Test
	void testFileReaderArchivoInexistente() {
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
        assertThrows(IOException.class, () -> {
            lector.fileReader(archivo, "LandOfFantasy/src/files/", "pepin.in");
        });
		
	}*/
}
