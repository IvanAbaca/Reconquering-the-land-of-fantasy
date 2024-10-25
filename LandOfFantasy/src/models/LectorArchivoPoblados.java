package models;

import java.util.HashMap;
import java.util.PriorityQueue;

import utils.FileReaderOIA;
import utils.Grafo;
import utils.TextProcessor;

public class LectorArchivoPoblados extends TextProcessor<LectorArchivoPoblados> {

	private int cantidadPueblos;
	private int puebloInicial;
	private int puebloFinal;
	private Grafo<Ciudad> mapa = new Grafo<>(); //TODO: esto es solo como muestra, hay que modificar esto para que funcione como un singleton
	
	//TODO: ¿añadir constructor?
	public static final String PATH = "LandOfFantasy/src/files/"; 
	public static final String FILENAME = "pueblos.in";
	public static final String REGEX = "\\s+";
	
	public static void main(String[] args) {
		FileReaderOIA<LectorArchivoPoblados> reader = new FileReaderOIA<LectorArchivoPoblados>();
		LectorArchivoPoblados example = new LectorArchivoPoblados();
		
		reader.fileReader(example, PATH, FILENAME);
		
		System.out.println(example.toString());
	}
	
	@Override
	public void textProcess(String[] line) {
		
		this.cantidadPueblos = Integer.parseInt(line[0]);

		HashMap<Integer, Ciudad> mapaAuxiliar = new HashMap<>();
		for(int i = 1 ; i<cantidadPueblos+1 ; i++)
		{
			String[] datos = line[i].split(REGEX);
			
			PriorityQueue<Raza> tropa = new PriorityQueue<>();
			
			for(int j = 0 ; j<Integer.parseInt(datos[1]) ; j++)
				tropa.add(crearSoldado(datos[2]));
			
			boolean aliado = !(datos[3].toLowerCase().equals("enemigo")); //Nota: el nodo propio lo consideramos como aliado acá
			
			Ciudad ciudad = new Ciudad(tropa, aliado, Integer.parseInt(datos[0]));
			this.mapa.agregarNodo(ciudad);
			mapaAuxiliar.put(ciudad.getNumero(), ciudad);
		}
		
		this.puebloInicial = Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[0]);
		this.puebloFinal = Integer.parseInt(line[cantidadPueblos+1].split(REGEX)[2]);
		
		for(int i = cantidadPueblos+3 ; i<line.length ; i++)
		{
			String[] datos = line[i].split(REGEX);
			this.mapa.agregarArista(mapaAuxiliar.get(Integer.parseInt(datos[0])), mapaAuxiliar.get(Integer.parseInt(datos[1])), Integer.parseInt(datos[2]));
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
	
	@Override
	public String toString() {
//		String output = "----------------------------------------------"
//				+ "\nword = " + word + "\nnumber = " + number + "\nvector = "
//				+ Arrays.toString(vector) + "\nmatrix =";
//		
//		for(int[] v : matrix)
//			output += "\n" + Arrays.toString(v);
//		output += "\n----------------------------------------------";
//		
//		
//		return output;
		return "AAAAAAAAAAAAAA";
	}
	

}
