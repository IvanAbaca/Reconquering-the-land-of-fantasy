package models;

import java.util.PriorityQueue;

public class Ciudad {
	public PriorityQueue<Unidad> ejercito;
	public boolean aliado;
	
	public Ciudad(PriorityQueue<Unidad> ejercito, boolean aliado) {
		this.ejercito = ejercito;
		this.aliado = aliado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ciudad: " + (aliado ? "aliada" : "enemiga");
	}
}
