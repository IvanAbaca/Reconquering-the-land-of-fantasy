package models;

public class Radaiteran extends Soldado {

	private static final int MAX_HP = 36;
    private static final int ATK = 56;
    private static final String RANGO = "17 - 41";

	private static final int AUMENTO_ATK = 3;

	private int turn = 0;
	
	public Radaiteran() {
		super(MAX_HP, ATK, RANGO);
	}

	@Override
	public int atacar() {
		return atk+(AUMENTO_ATK*turn++);
	}

	@Override
	public void serAtacado(int dmg) {
		hp -= dmg < hp ? dmg : hp;	
	}

	@Override
	public void descansar() {
		// No hace nada
	}

}
