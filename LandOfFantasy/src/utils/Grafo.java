package utils;

import java.util.*;

public class Grafo<T> {
    private Map<T, Nodo<T>> nodos; // Mapa para acceso rápido a los nodos

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    public Nodo<T> agregarNodo(T valor) {
        Nodo<T> nodo = new Nodo<>(valor);
        nodos.put(valor, nodo);
        return nodo;
    }

    public Nodo<T> obtenerNodo(T valor) {
        return nodos.get(valor);
    }

    public void agregarArista(T origen, T destino, int peso) {
        Nodo<T> nodoOrigen = nodos.get(origen);
        Nodo<T> nodoDestino = nodos.get(destino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarAdyacente(nodoDestino, peso);
        }
    }

    public Map<Nodo<T>, Integer> dijkstra(T origen) {
        Nodo<T> nodoOrigen = nodos.get(origen);
        if (nodoOrigen == null) {
            throw new IllegalArgumentException("El nodo de origen no existe en el grafo.");
        }

        // Mapa de distancias desde el nodo de origen
        Map<Nodo<T>, Integer> distancias = new HashMap<>();
        // Todos los nodos inicializados a infinito (excepto el origen)
        for (Nodo<T> nodo : nodos.values()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(nodoOrigen, 0);

        // Cola de prioridad para seleccionar el nodo con menor distancia
        PriorityQueue<Nodo<T>> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        cola.add(nodoOrigen);

        while (!cola.isEmpty()) {
            Nodo<T> nodoActual = cola.poll();

            // Explorar los adyacentes
            for (Map.Entry<Nodo<T>, Integer> adyacente : nodoActual.getAdyacentes().entrySet()) {
                Nodo<T> nodoAdyacente = adyacente.getKey();
                int peso = adyacente.getValue();
                int nuevaDistancia = distancias.get(nodoActual) + peso;

                // Si encontramos un camino más corto
                if (nuevaDistancia < distancias.get(nodoAdyacente)) {
                    distancias.put(nodoAdyacente, nuevaDistancia);
                    cola.add(nodoAdyacente); // Añadir a la cola para explorar
                }
            }
        }

        return distancias; // Retorna el mapa con las distancias más cortas
    }
}
