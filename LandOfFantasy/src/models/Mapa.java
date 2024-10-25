package models;

import utils.Grafo;

public class Mapa {

	private static Mapa instancia;
	private int cantidadPueblos;
	private int puebloInicial;
	private int puebloFinal;
	private Grafo<Ciudad> poblados;
	
	private Mapa() {
		this.poblados = new Grafo<>();
	}

	public static Mapa getMapa() {
		if (instancia == null)
			instancia = new Mapa();
		
		return instancia;
	}
	
	public Grafo<Ciudad> getPoblados() {
		return poblados;
	}

	public int getCantidadPueblos() {
		return cantidadPueblos;
	}

	public int getPuebloInicial() {
		return puebloInicial;
	}

	public int getPuebloFinal() {
		return puebloFinal;
	}

	public void setCantidadPueblos(int cantidadPueblos) {
		this.cantidadPueblos = cantidadPueblos;
	}

	public void setPuebloInicial(int puebloInicial) {
		this.puebloInicial = puebloInicial;
	}

	public void setPuebloFinal(int puebloFinal) {
		this.puebloFinal = puebloFinal;
	}
	
	
	
}
