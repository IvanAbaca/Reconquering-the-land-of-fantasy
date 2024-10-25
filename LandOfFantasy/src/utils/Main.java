package utils;

import java.util.Map;

import models.Ciudad;

public class Main {
	public static void main(String[] args) {
        Grafo<Ciudad> grafo = new Grafo<>();
        
        Ciudad a = new Ciudad(null, true,1);
        Ciudad b = new Ciudad(null, true,2);
        Ciudad c = new Ciudad(null, true,3);
        Ciudad d = new Ciudad(null, true,4);
        //Ciudad e = new Ciudad(null, true);

        // Agregar nodos
        grafo.agregarNodo(a);
        grafo.agregarNodo(b);
        grafo.agregarNodo(c);
        grafo.agregarNodo(d);

        // Agregar aristas (con pesos)
        grafo.agregarArista(a, b, 1);
        grafo.agregarArista(a, c, 4);
        grafo.agregarArista(b, c, 2);
        grafo.agregarArista(b, d, 5);
        grafo.agregarArista(c, d, 1);

        // Ejecutar Dijkstra desde "A"
        Map<Nodo<Ciudad>, Integer> distancias = grafo.dijkstra(a);

        // Imprimir distancias más cortas desde el nodo A
        for (Map.Entry<Nodo<Ciudad>, Integer> entrada : distancias.entrySet()) {
            System.out.println("Distancia desde A hasta " + entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
