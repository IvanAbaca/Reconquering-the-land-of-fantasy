package models;

import java.util.Collections;
import java.util.PriorityQueue;

public class Batallon extends Unidad {
    PriorityQueue<Unidad> unidades;
    
    
    public Batallon() {
    	super(0,0,"");
		this.unidades = new PriorityQueue<>(); // Por defecto, la cola de prioridad pone al menor primero
	}
    
    private void agregarUnidad(Unidad unidad) {
    	this.unidades.add(unidad);
    }
    
    private void quitarUnidad(Unidad unidad) {
    	this.unidades.remove(unidad);
    }

	private Unidad obtenerUnidad() {
    	return this.unidades.peek();
    }

	private void actualizarUnidad() {
    	this.unidades.add(unidades.poll());
    }

	public void encuentro(Ciudad ciudad) {
    	if(ciudad.isAliado())
    		descansar(ciudad.getEjercito());
    	else
    		batallar(ciudad.getEjercito());
    }
    
    public void descansar(Unidad aliados) {
		
		// TODO: Arreglar el descanso (parámetros que recibe son distintos)

    	this.unidades.forEach(unidad -> unidad.descansar());

		// TODO: Añadir los aliados a la cola
    }

    public boolean derrotado() {
    	return this.unidades.isEmpty();
    }
    
	@Override
	public String toString() {
		return "Ejercito [aliados=" + unidades +"]";
	}

	@Override
	public int atacar() {
		Unidad soldado = obtenerUnidad();
    
		return soldado.atacar();
	}

	@Override
	public void serAtacado(int dmg) {
		Unidad soldado = obtenerUnidad();
    
		soldado.serAtacado(dmg);
		
		if(soldado.derrotado()) {
			quitarUnidad(soldado);
		}
	}

	@Override
	public boolean batallar(Unidad enemigo) {
		Unidad soldado = obtenerUnidad();
    
		while(soldado != null) {
			if(soldado.batallar(enemigo)) {
				actualizarUnidad();
				return true;
			}
			quitarUnidad(soldado);
			soldado = obtenerUnidad();
		}
		return false;
	}
}