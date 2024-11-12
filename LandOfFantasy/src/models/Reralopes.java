package models;

public class Reralopes extends Soldado {

	private static final int MAX_HP = 53;
    private static final int ATK = 27;
    private static final String RANGO = "5 - 46";

	private static final int MAX_ATK_ERRADOS = 2;
	private static final int REINICIO_ATK = 4;
	private static final int INICIO_BOOST = 3;
	private static final int FIN_BOOST = 0;
	private static final int BOOST_ATK = 2;

	private int ataque = 4;
	private int boost = 0;
	
	public Reralopes() {
		super(MAX_HP, ATK, RANGO);
	}

	@Override
	public int atacar() {
		if(ataque-- <= MAX_ATK_ERRADOS)
		{
			if(ataque == 0)
				ataque = REINICIO_ATK;
			
			return 0;
		}
			
		if(boost-- > FIN_BOOST)
			return atk*BOOST_ATK;
		
		return atk; // Devuelve el daño realizado
	}

	@Override
	public void serAtacado(int dmg) {
		hp -= dmg < hp ? dmg : hp;
		boost = FIN_BOOST;
	}

	@Override
	public void descansar() {
		boost = INICIO_BOOST;
	}
}
