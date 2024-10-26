package utils;

public class Arista<T> {

	private T destino;
	int peso;
	
	public Arista(T destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public T getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
	
}
