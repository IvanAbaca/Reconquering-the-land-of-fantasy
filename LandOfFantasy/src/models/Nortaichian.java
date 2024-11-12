package models;

public class Nortaichian extends Soldado {

	private static final int MAX_HP = 66;
    private static final int ATK = 18;
    private static final String RANGO = "16 - 22";

	private static final int REGEN_ATK_PERCENT = 4;
	private static final int BOOST_FURIA = 2;
	private static final int INICIO_FURIA = 2;
	private static final int FIN_FURIA = 0;
	private static final int INICIO_PIEDRA = 2;
	private static final int FIN_PIEDRA = 0;
	private static final int RED_DANO_RECIBIDO = 2;

	private int furia = 0;
	private int piedra = 0;
	
	public Nortaichian() {
		super(MAX_HP, ATK, RANGO);
	}

	@Override
	public int atacar() {
		if(piedra-- > FIN_PIEDRA)
			return 0;
		
		hp = hp*REGEN_ATK_PERCENT/100 + hp > maxhp ? maxhp : (hp*REGEN_ATK_PERCENT/100)+hp;
		return furia-- > FIN_FURIA ? atk*BOOST_FURIA : atk;
	}

	@Override
	public void serAtacado(int dmg) {
		if(piedra > FIN_PIEDRA)
			dmg /= RED_DANO_RECIBIDO;
		
		furia = INICIO_FURIA;
		hp -= dmg < hp ? dmg : hp;
	}

	@Override
	public void descansar() {
		piedra = INICIO_PIEDRA;
		hp = maxhp;
	}


}
