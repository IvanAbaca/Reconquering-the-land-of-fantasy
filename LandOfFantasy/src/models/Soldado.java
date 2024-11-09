package models;

 
public abstract class Soldado extends Unidad{
	//TODO: si a los profesores no les gustó que dejaramos un float tirado por ahí
	//que ni usabamos en el tp anterior creo que menos le va a gustar
	//todos estos doubles que están por acá, los vamos a tener que 
	//cambiar más adelante.
    
    public Soldado(int maxhp, int atk, String rango) {
		super(maxhp, atk, rango);
	}
    
    public abstract int atacar();
    public abstract void serAtacado(double dmg);
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

	public double getMaxhp() {
		return maxhp;
	}

	public double getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}
    
	public int compareTo(Soldado o) {	
        return (int)(this.getHp() - o.getHp());
    }
}