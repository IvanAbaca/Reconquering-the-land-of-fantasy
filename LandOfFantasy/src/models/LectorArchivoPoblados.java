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

		HashMap<Integer, Ciudad> mapaAuxiliar = new HashMap<>();
		for(int i = 1 ; i<cantidadPueblos+1 ; i++)
		{
			String[] datos = line[i].split(REGEX);
			
			PriorityQueue<Raza> tropa = new PriorityQueue<>();
			
			for(int j = 0 ; j<Integer.parseInt(datos[1]) ; j++)
				tropa.add(crearSoldado(datos[2]));
			
			boolean aliado = !(datos[3].toLowerCase().equals("enemigo")); //Nota: el nodo propio lo consideramos como aliado acá
			
			Ciudad ciudad = new Ciudad(tropa, aliado, Integer.parseInt(datos[0]));
			this.mapa.getPoblados().agregarNodo(ciudad);
			mapaAuxiliar.put(ciudad.getNumero(), ciudad);
		}
		
		this.mapa.setPuebloInicial(mapaAuxiliar.get(Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[0])));
		this.mapa.setPuebloFinal(mapaAuxiliar.get(Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[2])));
		
		for(int i = cantidadPueblos+2 ; i<line.length ; i++)
		{
			String[] datos = line[i].split(REGEX);
			this.mapa.getPoblados().agregarArista(mapaAuxiliar.get(Integer.parseInt(datos[0])), mapaAuxiliar.get(Integer.parseInt(datos[1])), Integer.parseInt(datos[2]));
		}
	}

	private Raza crearSoldado(String tipoSoldado)
	{
		Raza soldado;
		
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
