package models;

 
public abstract class Raza implements Comparable<Raza> {
	//TODO: si a los profesores no les gustó que dejaramos un float tirado por ahí
	//que ni usabamos en el tp anterior creo que menos le va a gustar
	//todos estos doubles que están por acá, los vamos a tener que 
	//cambiar más adelante.
    protected int maxhp;
    protected int hp;
    protected int atk;
    
    public Raza(int maxhp, int atk) {
		super();
		this.maxhp = maxhp;
		this.hp = maxhp;
		this.atk = atk;
	}
    
    public abstract int atacar();
    public abstract void serAtacado(double dmg);
    public abstract void descansar();
    
    public boolean batallar(Raza enemigo) {
    	while(true) {	
	    	enemigo.serAtacado(this.atacar());
	    	
	    	if(enemigo.derrotado())
	    		return true;
	    	
	    	this.serAtacado(enemigo.atacar());
	    	
	    	if(this.derrotado())
	    		return false;
    	}
    }
    
	public boolean derrotado() {
		return hp<=0;
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
    
	public int compareTo(Raza o) {	
        return (int)(this.getHp() - o.getHp());
    }
}