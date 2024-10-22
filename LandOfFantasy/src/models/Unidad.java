package models;

import java.util.List;

public class Unidad implements Comparable<Unidad> {
    List<Raza> soldados;
    
    //Constructor
    public Unidad(List<Raza> soldados, boolean aliado) {
    	this.soldados = soldados;
    }
    
    //Public methods
    public double getHp() {
    	double hp = 0;
    	
    	for(Raza soldado : soldados)
    		hp += soldado.getHp();
    	
    	return hp;
    }
    
    public int atacar() {
    	int atk = 0;
    	
    	for(Raza soldado : soldados)
    		atk += soldado.atacar();
    	
    	return atk;
    }
    
    public void serAtacado(Unidad enemigo) {
    	double atk = enemigo.atacar() / soldados.size();
    	
    	for(Raza soldado : soldados)
    		soldado.serAtacado(atk);
    	
    	soldados.removeIf(soldado -> !(soldado.getHp() > 0));
    }
    
    public boolean batallar(Unidad enemigo) {
    	while(true) {	
	    	enemigo.serAtacado(this);
	    	
	    	if(enemigo.desmayado())
	    		return true;
	    	
	    	this.serAtacado(enemigo);
	    	
	    	if(this.desmayado())
	    		return false;
    	}
    }
    
    public void descansar() {
    	for(Raza soldado : soldados)
    		soldado.descansar();
    }
    
    public boolean desmayado() {
    	return soldados.isEmpty();
    }

    public int compareTo(Unidad o) {	
        return (int)(this.getHp() - o.getHp());
    }
}