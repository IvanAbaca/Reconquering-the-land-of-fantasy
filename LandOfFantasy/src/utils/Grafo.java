package utils;

import java.util.*;

public class Grafo<T> {
	private Map<T, List<Arista<T>>> adyacentes;

	public Grafo() {
		this.adyacentes = new HashMap<>();
	}
	
	private void agregarNodo(T dato) {
		this.adyacentes.putIfAbsent(dato, new ArrayList<>()); //evitamos sobreescribir datos
	}
	
	public void agregarArista(T nodoA, T nodoB , int peso) {
		this.agregarNodo(nodoA);
		this.agregarNodo(nodoB);
		this.adyacentes.get(nodoA).add(new Arista<T>(nodoB, peso));
		this.adyacentes.get(nodoB).add(new Arista<T>(nodoA, peso));
	}
	
	public void dijkstra(T nodoInicial, Map<T, Integer> distancias, Map<T, T> predecesores) {
		PriorityQueue<Arista<T>> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.getPeso()));
		distancias.clear();
		predecesores.clear();
		Set<T> visitados = new HashSet<>();
		
		for(T nodo : this.adyacentes.keySet())
			distancias.put(nodo, Integer.MAX_VALUE);
		
		distancias.put(nodoInicial, 0);
		cola.add(new Arista<T>(nodoInicial, 0));
		
		while(!cola.isEmpty()) {
			
			T nodoActual = cola.poll().getDestino();
			
			if(!visitados.contains(nodoActual))
			{
				visitados.add(nodoActual);
				for(Arista<T> arista : this.adyacentes.get(nodoActual))
				{
					int nuevaDistancia = distancias.get(nodoActual) + arista.peso;
					
					if(nuevaDistancia < distancias.get(arista.getDestino()))
					{
						distancias.put(arista.getDestino(), nuevaDistancia);
						predecesores.put(arista.getDestino(), nodoActual);
						cola.add(new Arista<T>(arista.getDestino(), nuevaDistancia));
					}
				}
			}
		}
	}
	
	public List<T> obtenerCamino(T nodoInicial, T nodoFinal)
	{
		List<T> camino = new ArrayList<>();
		Map<T, Integer> distancias = new HashMap<>();
		Map<T, T> predecesores = new HashMap<>();
		
		if(nodoInicial == nodoFinal)
			return camino;
		
		this.dijkstra(nodoInicial, distancias, predecesores);
		
		camino.add(nodoFinal);
		T nodoActual = predecesores.get(nodoFinal);
		while(nodoActual != nodoInicial)
		{
			camino.addFirst(nodoActual);
			nodoActual = predecesores.get(nodoActual);
		}
		camino.addFirst(nodoActual);
		
		return camino;
	}
	
	// Display the graph
    public void mostrarGrafo() {
        for (T nodo : this.adyacentes.keySet()) {
            System.out.print(nodo + " -> ");
            for (Arista<T> arista : adyacentes.get(nodo)) {
                System.out.print(arista.getDestino() + "(" + arista.peso + ") ");
            }
            System.out.println();
        }
    }
	
}
