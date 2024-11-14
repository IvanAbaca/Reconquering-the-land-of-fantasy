package models;

import java.util.List;
import utils.FileReaderOIA;

public class Main {

	public static final String PATH = "src/files/";
	public static final String FILENAME = "pueblos.in";
	
	public static void main(String[] args) {
		
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

			ciudadActual = camino.get(i);
			ejercito.encuentro(camino.get(i));

			if(ciudadActual.isAliado())
		    {	if(i==0)
		    		Graficos.animacionPartida(ciudadActual.getNumero(),  ejercito.obtenerCantTropas());
		    	else 
		    		Graficos.animacionDescanso(ciudadActual.getNumero(),  ejercito.obtenerCantTropas());
		    }
		    else {
		    	Graficos.animacionBatalla(ciudadActual.getNumero(),  ejercito.obtenerCantTropas());
		    }
			int distancia = camino.get(i).getDistancia();
			
			while(distancia > 10) { // mientras la distancia sea mayor a 10km
				cantDias++; //sumo un día, ya que mis tropas solo avanzan 10 km por día
				distancia-=10; //actualizo la distancia correspondiente
			}
			cantDias++; //ya que por cada batalla o encuentro, yo pierdo 1 día
		}
		

		
		if(ejercito.derrotado()) {
			Graficos.animacionMuerte(camino, ciudadActual.getNumero() ,ciudadActual.getEjercito().obtenerCantTropas() ,  cantDias);	
		}
		else {
			Graficos.animacionVictoria(camino, ejercito.obtenerCantTropas(), cantDias);
		}

	}

}
