package models;

public class Radaiteran extends Raza {

	private int turn = 0;
	
	public Radaiteran() {
		super(36, 56);
	}

	@Override
	public int atacar() {
		return atk+(3*turn++);
	}

	@Override
	public void serAtacado(double dmg) {
		hp -= dmg < hp ? dmg : hp;	
	}

	@Override
	public void descansar() {
		// No hace nada
	}

}
