package models;

public class Reralopes extends Raza {

	private int ataque = 4;
	private int boost = 0;
	
	public Reralopes() {
		super(53, 27);
	}

	@Override
	public int atacar() {
		if(ataque-- <= 2)
		{
			if(ataque == 0)
				ataque = 4;
			
			return 0;
		}
			
		if(boost-- > 0)
			return atk*2;
		
		return atk;
	}

	@Override
	public void serAtacado(double dmg) {
		hp -= dmg < hp ? dmg : hp;
		boost = 0;
	}

	@Override
	public void descansar() {
		boost = 3;
	}
}
