package models;

public abstract class Raza {
    protected int maxhp;
    protected int hp;
    protected int atk;
    
    public Raza(int maxhp, int atk) {
		super();
		this.maxhp = maxhp;
		this.hp = maxhp;
		this.atk = atk;
	}
    
    protected abstract int atacar();
    protected abstract void serAtacado(int dmg);
    protected abstract void descansar();
    
	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public int getHp() {
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