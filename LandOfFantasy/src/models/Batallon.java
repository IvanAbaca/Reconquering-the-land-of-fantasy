package models;

import java.util.Collections;
import java.util.PriorityQueue;

public class Batallon extends Unidad {
    PriorityQueue<Unidad> unidades;
    
    
    public Batallon() {
    	super(0,0,"");
		this.unidades = new PriorityQueue<>();//Por defecto, la cola de prioridad pone al menor primero
	}
    
    public void agregarUnidad(Unidad unidad) {
    	this.unidades.add(unidad);
    }
    
    public void quitarUnidad(Unidad unidad) {
    	this.unidades.remove(unidad);
    }

	public void encuentro(Ciudad ciudad) {
    	if(ciudad.isAliado())
    		descansar(ciudad.getEjercito());
    	else
    		batallar(ciudad.getEjercito());
    }
    
    public void descansar(PriorityQueue<Unidad> aliados) {
    	this.unidades.forEach(unidad -> unidad.descansar());
    	//añadir los aliados a la cola
    }
    
    public boolean batallar(PriorityQueue<Unidad> enemigos) {
    	
    	Unidad enemigo = enemigos.poll();
		
    	// Pelea de los aliados
    	Unidad aliado = aliados.poll();
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
    	Unidad propio = propios.poll();
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