package models;

import java.util.PriorityQueue;

public class Ejercito {
    PriorityQueue<Unidad> aliados;
    PriorityQueue<Unidad> propios;
    
    public void encuentro(Ciudad ciudad) {
    	if(ciudad.aliado)
    		descansar(ciudad.ejercito);
    	else
    		batallar(ciudad.ejercito);
    }
    
    public void descansar(PriorityQueue<Unidad> aliados) {
    	this.propios.forEach(unidad -> unidad.descansar());
    	this.aliados.forEach(unidad -> unidad.descansar());
    	
    	this.aliados.addAll(aliados);
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
    		propios.add(aliado);
    		return true;
    	}
    	
    	return false;
    }
}