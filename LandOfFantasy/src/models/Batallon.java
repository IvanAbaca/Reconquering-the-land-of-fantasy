package models;

import java.util.Collections;
import java.util.PriorityQueue;

public class Batallon extends Unidad {
    PriorityQueue<Unidad> unidades;
    
    
    public Batallon() {
    	super(0,0,"");
		this.unidades = new PriorityQueue<>(Collections.reverseOrder()); // Por defecto, la cola de prioridad pone al menor primero
	}
    
    public Batallon(PriorityQueue<Unidad> u) {
    	this();
    	//No podemos guardar una cola de prioridad tal y como está
    	//nos tenemos que asegurar de que tenga el orden correcto 
    	//para la clase Batallón
    	u.forEach(e -> this.unidades.add(e));
	}
    
    public Batallon(Unidad u) {
    	this();
		agregarUnidad(u);
	}
    
    // TODO: Constructor con cola de prioridad
    
    public Batallon(PriorityQueue<Unidad> unidades, boolean propio) {
    	this(unidades);
    	this.propio = propio;
	}

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
	
	public int obtenerCantTropas(){
		int totalTropas = 0;
	    
	    for(Unidad u : unidades)
	    	totalTropas += u.obtenerCantTropas();
	    
	    return totalTropas;
	}
}