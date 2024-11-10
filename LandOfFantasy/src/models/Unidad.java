package models;

import java.util.List;

public abstract class Unidad implements Comparable<Unidad> {
	
    protected int maxhp;
    protected int hp;
    protected int atk;
    protected String rango;
    protected boolean propio = false;
    
    protected static final boolean VICTORIA = true;
    
    //Constructor
    public Unidad(int maxhp, int atk, String rango) {
      this.maxhp = maxhp;
      this.hp = maxhp;
      this.atk = atk;
      this.rango = rango;
    };
    
    public Unidad() {
      this.maxhp = 0;
      this.hp = 0;
      this.atk = 0;
      this.rango = "0 - 0";
    };
    
    public void setPropio() {
    	this.propio = true;
    };
    
    //Public methods
    public int getHp() {
    	
    	return hp;
    }
    
    /*public int atacar() { // repensar logica, debe estar definida?
    	int atk = 0;
    	
    	for(Soldado soldado : soldados)
    		atk += soldado.atacar();
    	
    	return atk;
    }
    
    public void serAtacado(Unidad enemigo) { // repensar logica
    	int atk = enemigo.atacar() / soldados.size();
    	
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
    public abstract void serAtacado(int dmg);
    public abstract void descansar();
    public abstract boolean batallar(Unidad enemigo);
    public abstract Unidad sumarMitadTropas();
   
    public boolean derrotado() {
		return hp<=0;
	}

    // TODO: Hay que chequear que mande al fondo a los fueron dañados, respetando que vengan primero los propios y después el resto
    
    public int compareTo(Unidad o) {
        return (int)(this.getHp() - o.getHp());
    }
}