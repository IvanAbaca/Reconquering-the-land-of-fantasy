package models;

public class Wrives extends Soldado{

	private static final int MAX_HP = 108;
    private static final int ATK = 113;
    private static final String RANGO = "14 - 28";

	private static final int REGEN_HP = 50;
	private static final int INC_MAX_HP = 50;
	private static final int MULT_ATK = 2;
	private static final int MULT_DANO_RECIBIDO = 2;
	
	private boolean boost = false;
	private boolean atacado = false;
	
	public Wrives() {
		super(MAX_HP, ATK, RANGO);
	}

	@Override
	public int atacar() {
		if(!atacado)
			return 0;
		
		boost = !boost;
		return !boost ? atk*MULT_ATK : atk;
	}

	@Override
	public void serAtacado(int dmg) {
		atacado = true;
		dmg *= MULT_DANO_RECIBIDO;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	public void descansar() {
		atacado = false;
		hp = hp + REGEN_HP > maxhp ? maxhp : hp + REGEN_HP;
		maxhp += INC_MAX_HP;
	}
}
