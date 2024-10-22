package models;

public class Radaiteran extends Raza {

	private int turn = 0;
	
	public Radaiteran() {
		super(36, 56);
	}

	@Override
	protected int atacar() {
		return atk*3*++turn;
	}

	@Override
	protected void serAtacado(double dmg) {
		hp -= dmg < hp ? dmg : hp;	
	}

	@Override
	protected void descansar() {
		// No hace nada
	}

}
