package models;

import java.util.List;
import utils.FileReaderOIA;

public class Main {

	public static final String PATH = "src/files/";
	public static final String FILENAME = "pueblos.in";
	
	public static void main(String[] args) {
		System.out.println("=====INICIO=====");
		
		FileReaderOIA<LectorArchivoPoblados> lector = new FileReaderOIA<>();
		LectorArchivoPoblados archivo = new LectorArchivoPoblados();
		
		lector.fileReader(archivo, PATH, FILENAME);
		
		Mapa mapa = Mapa.getMapa();
		Batallon ejercito = new Batallon(mapa.getPuebloInicial().getEjercito());
		List<Ciudad> camino = mapa.getPoblados().obtenerCamino(mapa.getPuebloInicial(), mapa.getPuebloFinal());
		
		int cantDias = 0;
		int i = -1;
		Ciudad ciudadActual = null;
		while(++i<camino.size() && !ejercito.derrotado()) {
			System.out.println("contra: " + camino.get(i));
			System.out.println("unidades: " + ejercito.ObtenerCantTropas());
			ciudadActual = camino.get(i);
			ejercito.encuentro(camino.get(i));
			int distancia = camino.get(i).getDistancia();
			
			while(distancia > 10) { // mientras la distancia sea mayor a 10km
				cantDias++; //sumo un día, ya que mis tropas solo avanzan 10 km por día
				distancia-=10; //actualizo la distancia correspondiente
			}
			cantDias++; //ya que por cada batalla o encuentro, yo pierdo 1 día
		}
			
		System.out.println("El ejercito fue "+ ( ejercito.derrotado() ? "Derrotado en " + ciudadActual + " Donde se enfrentó a " + ciudadActual.getEjercito().ObtenerCantTropas() + " Soldado/s enemigos. Duración: " + cantDias + " Día/s": "Victorioso, con " + ejercito.ObtenerCantTropas() + " soldado/s. Duración: " + cantDias + " Día/s" ));
		
		System.out.println("======FIN======");
	}

}
