package models;

import java.util.HashMap;
import java.util.PriorityQueue;
import utils.TextProcessor;

public class LectorArchivoPoblados extends TextProcessor<LectorArchivoPoblados> {

	public static final String REGEX = "\\s+";
	
	Mapa mapa;
	
	public LectorArchivoPoblados() {
		super();
		this.mapa = Mapa.getMapa();
	}
	
	@Override
	public void textProcess(String[] line) {
		
		int cantidadPueblos = Integer.parseInt(line[0]);
		this.mapa.setCantidadPueblos(cantidadPueblos);
		int puebloPropio = -1;
		HashMap<Integer, Ciudad> mapaAuxiliar = new HashMap<>();
		for(int i = 1 ; i<cantidadPueblos+1 ; i++)
		{
			String[] datos = line[i].split(REGEX);
			
			PriorityQueue<Unidad> tropa = new PriorityQueue<>();
			
			for(int j = 0 ; j<Integer.parseInt(datos[1]) ; j++)
				tropa.add(crearSoldado(datos[2]));
			
			if(datos[3].toLowerCase().equals("propio"))
				puebloPropio = Integer.parseInt(datos[0]);	
			
			boolean aliado = !(datos[3].toLowerCase().equals("enemigo")); //Nota: el nodo propio lo consideramos como aliado acá
			
			Unidad unidadCiudad = new Batallon(tropa);
			Ciudad ciudad = new Ciudad(unidadCiudad, aliado, Integer.parseInt(datos[0]));
//			this.mapa.getPoblados().agregarNodo(ciudad);
			mapaAuxiliar.put(ciudad.getNumero(), ciudad);
		}
		
		this.mapa.setPuebloInicial(mapaAuxiliar.get(Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[0])));
		if(this.mapa.getPuebloInicial().getNumero() != puebloPropio)
			throw new IllegalArgumentException("El pueblo incial no es el propio");
		
		this.mapa.setPuebloFinal(mapaAuxiliar.get(Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[2])));
		
		for(int i = cantidadPueblos+2 ; i<line.length ; i++)
		{
			String[] datos = line[i].split(REGEX);
			this.mapa.getPoblados().agregarArista(mapaAuxiliar.get(Integer.parseInt(datos[0])), mapaAuxiliar.get(Integer.parseInt(datos[1])), Integer.parseInt(datos[2]));
			Ciudad origen = mapaAuxiliar.get(Integer.parseInt(datos[0]));
		    Ciudad destino = mapaAuxiliar.get(Integer.parseInt(datos[1]));
		    int peso = Integer.parseInt(datos[2]);
		    
		    // Asignar el peso a las ciudades
		    if (origen != null) {
		        origen.setDistancia(peso);
		    }
		    if (destino != null) {
		        destino.setDistancia(peso);
		    }
		}
	}

	private Soldado crearSoldado(String tipoSoldado)
	{
		Soldado soldado;
		
		switch (tipoSoldado.toLowerCase()) {
			case "wrives": {
				soldado = new Wrives();
				break;
			}
			case "reralopes": {
				soldado = new Reralopes();
				break;
			}
			case "nortaichian": {
				soldado = new Nortaichian();
				break;
			}
			case "radaiteran": {
				soldado = new Radaiteran();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipoSoldado);
		}
		
		return soldado;
	}

}
