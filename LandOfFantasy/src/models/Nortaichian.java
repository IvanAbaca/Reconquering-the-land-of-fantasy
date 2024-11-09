package models;

public class Nortaichian extends Soldado {

	private int furia = 0;
	private int piedra = 0;
	
	public Nortaichian() {
		super(66, 18, "16 - 22");
	}

	@Override
	public int atacar() {
		if(piedra-- > 0)
			return 0;
		
		hp = hp*4/100 + hp > maxhp ? maxhp : (hp*4/100)+hp;
		return furia-- > 0 ? atk*2 : atk;
	}

	@Override
	public void serAtacado(double dmg) {
		if(piedra > 0)
			dmg /= 2;
		
		furia = 2;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	public void descansar() {
		piedra = 2;
		hp = maxhp;
	}


}
