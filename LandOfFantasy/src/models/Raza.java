package models;

public abstract class Raza {
    protected double maxhp;
    protected double hp;
    protected int atk;
    
    public Raza(int maxhp, int atk) {
		super();
		this.maxhp = maxhp;
		this.hp = maxhp;
		this.atk = atk;
	}
    
    protected abstract int atacar();
    protected abstract void serAtacado(double dmg);
    protected abstract void descansar();
    
	public double getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(double maxhp) {
		this.maxhp = maxhp;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
    
    
}