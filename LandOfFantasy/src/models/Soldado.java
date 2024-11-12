package models;

import java.util.PriorityQueue;

public abstract class Soldado extends Unidad{
    
    public Soldado(int maxhp, int atk, String rango) {
		super(maxhp, atk, rango);
	}
    
    public abstract int atacar();
    public abstract void serAtacado(int dmg);
    public abstract void descansar();
    
    public boolean batallar(Unidad enemigo) { 
    	while(true) {
            enemigo.serAtacado(this.atacar());

            if(enemigo.derrotado())
                return VICTORIA;

            this.serAtacado(enemigo.atacar());

            if(this.derrotado())
                return !VICTORIA;
        }
    }
    
    public Unidad sumarMitadTropas() {
		return this;
    }

	public int getMaxhp() {
		return maxhp;
	}

	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}
	
	public int ObtenerCantTropas(){
		return 1;
	}

	// TODO: Compare por vida faltante, MODIFICAR	
    
	public int compareTo(Soldado o) {
        return (int)(this.getHp() - o.getHp());
    }
}