package models;

import java.util.PriorityQueue;

public class Ejercito {
    PriorityQueue<Raza> aliados;
    PriorityQueue<Raza> propios;
    
    public Ejercito(PriorityQueue<Raza> propios) {
		super();
		this.propios = propios;
		this.aliados = new PriorityQueue<>();
	}

	public void encuentro(Ciudad ciudad) {
    	if(ciudad.isAliado())
    		descansar(ciudad.getEjercito());
    	else
    		batallar(ciudad.getEjercito());
    }
    
    public void descansar(PriorityQueue<Raza> aliados) {
    	this.propios.forEach(unidad -> unidad.descansar());
    	this.aliados.forEach(unidad -> unidad.descansar()); //Nota: ¿los aliados deberían descansar el mismo turno en el que los reclutamos?
    	
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
    		propios.add(aliado);
    		return true;
    	}
    	
    	return false;
    }

	@Override
	public String toString() {
		return "Ejercito [aliados=" + aliados + ", propios=" + propios + "]";
	}
}