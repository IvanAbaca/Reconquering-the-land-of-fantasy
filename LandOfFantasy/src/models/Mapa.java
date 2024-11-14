package models;

import utils.Grafo;

public class Mapa {

	private static Mapa instancia;
	private int cantidadPueblos;
	private Ciudad puebloInicial;
	private Ciudad puebloFinal;
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

	public Ciudad getPuebloInicial() {
		return puebloInicial;
	}

	public Ciudad getPuebloFinal() {
		return puebloFinal;
	}

	public void setCantidadPueblos(int cantidadPueblos) {
		this.cantidadPueblos = cantidadPueblos;
	}

	public void setPuebloInicial(Ciudad puebloInicial) {
		this.puebloInicial = puebloInicial;
	}

	public void setPuebloFinal(Ciudad puebloFinal) {
		this.puebloFinal = puebloFinal;
	}
	
}
