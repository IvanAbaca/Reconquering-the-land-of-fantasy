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
    
    
    /*
    public Unidad() {
      this.maxhp = 0;
      this.hp = 0;
      this.atk = 0;
      this.rango = "0 - 0";
    };  */
    
    /*
    public void setPropio() {
    	this.propio = true;
    };*/
    
    //Public methods
    public int getHp() {
    	
    	return hp;
    }
    
    
    public abstract int atacar();
    public abstract void serAtacado(int dmg);
    public abstract void descansar();
    public abstract boolean batallar(Unidad enemigo);
    public abstract Unidad sumarMitadTropas();
    public abstract int obtenerCantTropas();
   
    public boolean derrotado() {
		return hp<=0;
	}

    // TODO: Hay que chequear que mande al fondo a los fueron dañados, respetando que vengan primero los propios y después el resto
    
    public int compareTo(Unidad o) {
        return (int)(this.getHp() - o.getHp());
    }
}