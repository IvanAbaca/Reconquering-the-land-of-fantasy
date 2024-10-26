package models;

import java.util.Collections;
import java.util.PriorityQueue;

public class Ejercito {
    PriorityQueue<Raza> aliados;
    PriorityQueue<Raza> propios;
    
    public Ejercito(PriorityQueue<Raza> propios) {
		super();
		this.propios = new PriorityQueue<>(Collections.reverseOrder());
		this.aliados = new PriorityQueue<>(Collections.reverseOrder()); //Por defecto, la cola de prioridad pone al menor primero
		this.propios.addAll(propios);
	}

	public void encuentro(Ciudad ciudad) {
    	if(ciudad.isAliado())
    		descansar(ciudad.getEjercito());
    	else
    		batallar(ciudad.getEjercito());
    }
    
    public void descansar(PriorityQueue<Raza> aliados) {
    	this.propios.forEach(unidad -> unidad.descansar());
    	this.aliados.forEach(unidad -> unidad.descansar());
    	
    	this.aliados.addAll(aliados);
    }
    
    public boolean batallar(PriorityQueue<Raza> enemigos) {
    	
    	Raza enemigo = enemigos.poll();
		
    	// Pelea de los aliados
    	Raza aliado = aliados.poll();
    	while(aliado != null && enemigo != null)
    		if(aliado.batallar(enemigo))
    			enemigo = enemigos.poll();
    		else
    			aliado = aliados.poll();
    	
    	if(enemigo == null) {
    		aliados.add(aliado);
    		return true;
    	}
    	
		// Pelea de los propios
    	Raza propio = propios.poll();
    	while(propio != null && enemigo != null)
    		if(propio.batallar(enemigo))
    			enemigo = enemigos.poll();
    		else
    			propio = propios.poll();
    	
    	if(enemigo == null) {
    		propios.add(propio);
    		return true;
    	}
    	
    	return false;
    }

    public boolean derrotado() {
    	return this.aliados.isEmpty() && this.propios.isEmpty();
    }
    
	@Override
	public String toString() {
		return "Ejercito [aliados=" + aliados + ", propios=" + propios + "]";
	}
}