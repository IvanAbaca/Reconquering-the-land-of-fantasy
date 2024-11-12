package models;

import java.util.PriorityQueue;

public class Ciudad {
	//private PriorityQueue<Unidad> ejercito;
	private boolean aliado;
	private int numero;
	Unidad ejercito;
	int distancia;
	
	/*public Ciudad(PriorityQueue<Unidad> ejercito, boolean aliado, int numeroNodo) {
		this.ejercito = ejercito;
		this.aliado = aliado;
		this.numero = numeroNodo;
	}*/
	
	public Ciudad(Unidad ejercito, boolean aliado, int numeroNodo) {
		this.ejercito = ejercito;
		this.aliado = aliado;
		this.numero = numeroNodo;
	}
	
	public void setDistancia(int d) {
		this.distancia = d;
	}
	
	@Override
	public String toString() {
		return "("+ numero + ")"; //+", " + (aliado ? "aliada" : "enemiga") + ", " + this.ejercito.size() +", "+this.ejercito.peek().getClass() +")";
	}

	public Unidad getEjercito() {
		return ejercito;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getDistancia() {
		return distancia;
	}

	public boolean isAliado() {
		return aliado;
	}
}
