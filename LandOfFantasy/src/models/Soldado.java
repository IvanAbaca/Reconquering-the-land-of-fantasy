package models;

 
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
                return true;

            this.serAtacado(enemigo.atacar());

            if(this.derrotado())
                return false;
        }
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

	// TODO: Compare por vida faltante, MODIFICAR	
    
	public int compareTo(Soldado o) {
        return (int)(this.getHp() - o.getHp());
    }
}