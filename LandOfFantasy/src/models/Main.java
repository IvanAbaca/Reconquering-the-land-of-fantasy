package models;

import java.util.List;
import utils.FileReaderOIA;

public class Main {

	public static final String PATH = "LandOfFantasy/src/files/";
	public static final String FILENAME = "pueblos.in";
	
	public static void main(String[] args) {
		System.out.println("=====INICIO=====");
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
		lector.fileReader(archivo, PATH, FILENAME);
		
		Mapa mapa = Mapa.getMapa();
		Ejercito ejercito = new Ejercito(mapa.getPuebloInicial().getEjercito());
		List<Ciudad> camino = mapa.getPoblados().obtenerCamino(mapa.getPuebloInicial(), mapa.getPuebloFinal());
		
		System.out.println(camino);
		
		System.out.println("======FIN======");
	}

}
