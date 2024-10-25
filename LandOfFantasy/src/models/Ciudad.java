package models;

import java.util.PriorityQueue;

public class Ciudad {
	public PriorityQueue<Raza> ejercito;
	public boolean aliado;
	
	public PriorityQueue<Raza> getEjercito() {
		return ejercito;
	}
	public boolean isAliado() {
		return aliado;
	}
	
}
