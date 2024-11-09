package models;

import java.util.List;

public abstract class Unidad implements Comparable<Unidad> {
	
    protected int maxhp;
    protected int hp;
    protected int atk;
    protected String rango;
    protected boolean propio = false; 
    
    
    //Constructor
    public Unidad(int maxhp, int atk, String rango) {
		this.maxhp = maxhp;
		this.hp = maxhp;
		this.atk = atk;
		this.rango = rango;
    };
    
    public Unidad() {
		this.maxhp = maxhp;
		this.hp = maxhp;
		this.atk = atk;
		this.rango = rango;
    };
    
    public void setPropio() {
    	this.propio = true;
    };
    
    //Public methods
    public double getHp() {
    	
    	return hp;
    }
    
    /*public int atacar() { // repensar logica, debe estar definida?
    	int atk = 0;
    	
    	for(Soldado soldado : soldados)
    		atk += soldado.atacar();
    	
    	return atk;
    }
    
    public void serAtacado(Unidad enemigo) { // repensar logica
    	double atk = enemigo.atacar() / soldados.size();
    	
    	for(Soldado soldado : soldados)
    		soldado.serAtacado(atk);
    	
    	soldados.removeIf(soldado -> !(soldado.getHp() > 0));
    }
    
    /*public boolean batallar(Unidad enemigo) {
    	while(true) {	
	    	enemigo.serAtacado(this);
	    	
	    	if(enemigo.desmayado())
	    		return true;
	    	
	    	this.serAtacado(enemigo);
	    	
	    	if(this.desmayado())
	    		return false;
    	}
    }*/ //este metopdo no deberia estar acá, sino en batallón
    
   /* public void descansar() {
    	for(Soldado soldado : soldados)
    		soldado.descansar();
    }*/
    
    public abstract int atacar();
    public abstract void serAtacado(double dmg);
    public abstract void descansar();
    public abstract boolean batallar(Unidad enemigo);
   
    public boolean derrotado() {
		return hp<=0;
	}

    //TODO
    public int compareTo(Unidad o) {	// hay q checkear q mande al fondo a los fueron dañados, respetando que vengan primero los propio y despues el resto
        return (int)(this.getHp() - o.getHp());
    }
}