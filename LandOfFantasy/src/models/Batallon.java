package models;

import java.util.PriorityQueue;

public class Batallon extends Unidad {
    PriorityQueue<Unidad> unidades;
    
    
    public Batallon() {
    	super(0,0,"");
		this.unidades = new PriorityQueue<>(); // Por defecto, la cola de prioridad pone al menor primero
	}
    
    public Batallon(PriorityQueue<Unidad> u) {
    	super(0,0,"");
    	this.unidades = new PriorityQueue<>(u);
		//this.unidades = u; 
	}
    
    public Batallon(Unidad u) {
    	super(0,0,"");
    	this.unidades = new PriorityQueue<>();
		agregarUnidad(u); // Por defecto, la cola de prioridad pone al menor primero
	}
    
    // TODO: Constructor con cola de prioridad
    
    public void agregarUnidad(Unidad unidad) {
    	this.unidades.add(unidad);
    }
    
    public void quitarUnidad(Unidad unidad) {
    	this.unidades.remove(unidad);
    }

    public Unidad obtenerUnidad() {
    	return this.unidades.peek();
    }

    public void actualizarUnidad() {
    	this.unidades.add(unidades.poll());
    }

	public void encuentro(Ciudad ciudad) { 
    	if(ciudad.isAliado()) {
    		descansar();
    		agregarUnidad(ciudad.getEjercito().sumarMitadTropas());
    	}
    		
    	else
    		batallar(ciudad.getEjercito());
    }
    
    public void descansar() {
    	this.unidades.forEach(unidad -> unidad.descansar());
    }

    public boolean derrotado() {
    	return this.unidades.isEmpty();
    }
    
    public PriorityQueue<Unidad> Obtenerbatallon(){
    	return this.unidades;
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
			if(soldado.batallar(enemigo) == VICTORIA) {
				actualizarUnidad();
				return VICTORIA;
			}
			quitarUnidad(soldado);
			soldado = obtenerUnidad();
		}
		return !VICTORIA;
	}
	
	public Unidad sumarMitadTropas() {
		PriorityQueue<Unidad> tropa = new PriorityQueue<>();
		int mitad = this.unidades.size() / 2;
		
		for(int i = 0; i < mitad; i++) {
			tropa.add(this.unidades.poll());
		}
		
		Unidad u = new Batallon(tropa);
		
		return u;
	}
	
	public int ObtenerCantTropas(){
		final int[] totalTropas = {0};
	    this.unidades.forEach(unidad -> totalTropas[0] += unidad.ObtenerCantTropas());;
	    return totalTropas[0];
	}
}