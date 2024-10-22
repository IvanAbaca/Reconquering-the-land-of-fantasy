package models;

public class Wrives extends Raza{
	
	private boolean boost = false;
	private boolean atacado = false;
	
	public Wrives() {
		super(108, 113);
	}

	@Override
	protected int atacar() {
		if(!atacado)
			return 0;
		
		boost = !boost;
		return !boost ? atk*2 : atk;
	}

	@Override
	protected void serAtacado(double dmg) {
		atacado = true;
		dmg *= 2;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	protected void descansar() {
		atacado = false;
		hp = hp + 50 > maxhp ? maxhp : hp + 50;
		maxhp += 50;
	}
}
