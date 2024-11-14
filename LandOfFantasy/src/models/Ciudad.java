package models;

public class Ciudad {
	private boolean aliado;
	private int numero;
	private Unidad ejercito;
	int distancia;
	
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
		return "("+ numero + ")";
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
