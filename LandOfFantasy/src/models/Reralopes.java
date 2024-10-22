package models;

public class Reralopes extends Raza {

	private int ataque = 4;
	private int boost = 3;
	
	public Reralopes() {
		super(53, 27);
	}

	@Override
	protected int atacar() {
		if(ataque-- <= 2)
			return 0;
		
		if(boost-- > 0)
			return atk*2;
		
		return atk;
	}

	@Override
	protected void serAtacado(double dmg) {
		ataque = 4;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	protected void descansar() {
		boost = 3;
		hp = hp + 50 > maxhp ? maxhp : hp + 50;
	}
}
