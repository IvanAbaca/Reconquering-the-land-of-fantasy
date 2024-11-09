package models;

import java.util.PriorityQueue;

public class Ciudad {
	//private PriorityQueue<Unidad> ejercito;
	private boolean aliado;
	private int numero;
	Unidad ejercito;
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "XD";//"("+ numero +", " + (aliado ? "aliada" : "enemiga") + ", " + this.ejercito.size() +", "+this.ejercito.peek().getClass() +")";
	}

	public Unidad getEjercito() {
		return ejercito;
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean isAliado() {
		return aliado;
	}
}
