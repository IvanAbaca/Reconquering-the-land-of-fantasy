package models;

public class Nortaichian extends Raza {

	private int furia = 0;
	private int piedra = 0;
	
	public Nortaichian() {
		super(66, 18);
	}

	@Override
	protected int atacar() {
		if(piedra-- > 0)
			return 0;
		
		hp = maxhp*0.4 + hp > maxhp ? maxhp : (int)(maxhp*0.4)+hp; //Arreglar, hp tiene que ser double creo
		return furia-- > 0 ? atk*2 : atk;
	}

	@Override
	protected void serAtacado(int dmg) {
		if(piedra > 0)
			dmg /= 2;
		
		furia = 2;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	protected void descansar() {
		piedra = 2;
		hp = maxhp;
	}


}
