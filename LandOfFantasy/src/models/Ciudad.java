package models;

import java.util.PriorityQueue;

public class Ciudad {
	public PriorityQueue<Raza> ejercito;
	public boolean aliado;
	private int numeroNodo;
	private static int numeroInstancia = 1;
	
	public Ciudad(PriorityQueue<Unidad> ejercito, boolean aliado) {
		this.ejercito = ejercito;
		this.aliado = aliado;
		this.numeroNodo = numeroInstancia++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ciudad "+ numeroNodo +": " + (aliado ? "aliada" : "enemiga");
	}

	public PriorityQueue<Raza> getEjercito() {
		return ejercito;
	}
	public boolean isAliado() {
		return aliado;
	}
}
