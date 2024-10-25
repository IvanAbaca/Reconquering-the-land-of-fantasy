package utils;

import java.util.*;

public class Nodo<T> {
    private T valor;
    private Map<Nodo<T>, Integer> adyacentes; // Nodo y peso de la arista

    public Nodo(T valor) {
        this.valor = valor;
        this.adyacentes = new HashMap<>();
    }

    public T getValor() {
        return valor;
    }

    public Map<Nodo<T>, Integer> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacente(Nodo<T> destino, int peso) {
        adyacentes.put(destino, peso);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
