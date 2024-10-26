package models;

import java.util.PriorityQueue;

public class Ciudad {
	private PriorityQueue<Raza> ejercito;
	private boolean aliado;
	private int numero;
	
	public Ciudad(PriorityQueue<Raza> ejercito, boolean aliado, int numeroNodo) {
		this.ejercito = ejercito;
		this.aliado = aliado;
		this.numero = numeroNodo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+ numero +", " + (aliado ? "aliada" : "enemiga") + ", " + this.ejercito.size() +", "+this.ejercito.peek().getClass() +")";
	}

	public PriorityQueue<Raza> getEjercito() {
		return ejercito;
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean isAliado() {
		return aliado;
	}
}
