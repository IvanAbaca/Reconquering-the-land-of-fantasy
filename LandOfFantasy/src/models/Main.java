package models;

import java.util.Map;
import utils.FileReaderOIA;
import utils.Nodo;;

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
		
		Map<Nodo<Ciudad>, Integer> caminos = mapa.getPoblados().dijkstra(mapa.getPuebloInicial());
		
		for(Map.Entry<Nodo<Ciudad>, Integer> entrada : caminos.entrySet())
			System.out.println(entrada.getKey()+" "+entrada.getValue());
		
		System.out.println("======FIN======");
	}

}
