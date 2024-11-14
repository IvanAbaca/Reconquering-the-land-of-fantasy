package models;

import java.util.ArrayList;

public class Graficos {
	private static ArrayList<Ciudad> camino = new ArrayList<>();
	private static ArrayList<Integer> cantSoldados = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		
//		Ciudad ciudad2 = new Ciudad(true,2);
//		Ciudad ciudad3 = new Ciudad(false,3);
//		Ciudad ciudad4 = new Ciudad(true,4);
//		Ciudad ciudad5 = new Ciudad(false,5);
//		
//		agregarCiudad(ciudad2,150);
//		agregarCiudad(ciudad3,120);
//		agregarCiudad(ciudad4,135);
//		agregarCiudad(ciudad5,1);
//		
//		animacionDeCamino();
	}
	
	public static void agregarCiudad(Ciudad ciudad, int cantSold) {
		
		camino.add(ciudad);
		cantSoldados.add(cantSold);
	}
	
	public static void animacionDeCamino() {
		for (int i = 0; i < 50; i++) {
		    System.out.println();
		}
		for (int i = 0; i < camino.size(); i++) {
		    Ciudad ciudad = camino.get(i);
		    Integer soldados = cantSoldados.get(i);
		    
		    
		    if(ciudad.isAliado())
		    {
		    	animacionDescanso(ciudad.getNumero(), soldados);
		    }
		    else {
		    	animacionBatalla(ciudad.getNumero(), soldados);
		    }
		    	
		    esperarYBorrarConsola(1000);
		    
		    if(soldados<=0)
		    {
		    	animacionMuerte();
		    	return;
		    }
		}
		
		animacionVictoria();
	}
	
	private static void animacionDescanso(int numeroCiudad,int soldados) {
		
		String aliado = """  
        .=(`(      .   )     .--  `.  (    ) )      
       ((    (..__.:'-'   .+(   )   ` _`  ) )                 
`.     `(       ) )       (   .  )     (   )  ._   
  )      ` __.:'   )     (   (   ))     `-'.-(`  ) 
)  )  ( )       --'       `- __.'         :(      )) 
.-'  (_.'          .')                    `(    )  ))
                  (_  )                     ` __.:'   
				Z						Z
				 z					   z
				  z				      z
				  
				  []___	          ___I_ 			  	    []___	  ___I_ 
				 /    /\\ 	 /\\-_--\\				    /    /\\ 	 /\\-_--\\
				/____/__\\	/  \\_-__\\	PUEBLO ALIADO - DESCANSO   /____/__\\	/  \\_-__\\	
				|[][]|| |	|[] | []|				   |[][]|| |	|[] | []|

							""";
		String aliado2 = """ 
        .=(`(      .   )     .--  `.  (    ) )      
       ((    (..__.:'-'   .+(   )   ` _`  ) )                 
`.     `(       ) )       (   .  )     (   )  ._   
  )      ` __.:'   )     (   (   ))     `-'.-(`  ) 
)  )  ( )       --'       `- __.'         :(      )) 
.-'  (_.'          .')                    `(    )  ))
                  (_  )                     ` __.:'   
				z						z
				 Z					   Z
				  z				      z
				  
				  []___	          ___I_ 			  	    []___	  ___I_ 
				 /    /\\ 	 /\\-_--\\				    /    /\\ 	 /\\-_--\\
				/____/__\\	/  \\_-__\\	PUEBLO ALIADO - DESCANSO   /____/__\\	/  \\_-__\\	
				|[][]|| |	|[] | []|				   |[][]|| |	|[] | []|

							""";
		String aliado3 = """  
        .=(`(      .   )     .--  `.  (    ) )      
       ((    (..__.:'-'   .+(   )   ` _`  ) )                 
`.     `(       ) )       (   .  )     (   )  ._   
  )      ` __.:'   )     (   (   ))     `-'.-(`  ) 
)  )  ( )       --'       `- __.'         :(      )) 
.-'  (_.'          .')                    `(    )  ))
                  (_  )                     ` __.:'   
				z						z
				 z					   z
				  Z				      Z
				  
				  []___	          ___I_ 			  	    []___	  ___I_ 
				 /    /\\ 	 /\\-_--\\				    /    /\\ 	 /\\-_--\\
				/____/__\\	/  \\_-__\\	PUEBLO ALIADO - DESCANSO   /____/__\\	/  \\_-__\\	
				|[][]|| |	|[] | []|				   |[][]|| |	|[] | []|

							""";
					
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("---> PUEBLO #" + numeroCiudad);
			if(i%3==0) 	
				System.out.println(aliado3);
			else {
				
				if(i%2==0)
					System.out.println(aliado2);
				else
					System.out.println(aliado);
			}
			System.out.println("CANTIDAD DE SOLDADOS TRAS SUMAR ALIADOS: [ " + soldados + " ]");	
			esperarYBorrarConsola(1000);				
		}
	}
	
	private static void animacionBatalla(int numeroCiudad,int soldados) {

		String batalla = """
	                       ___
	                      ( ((
	                       ) ))
	.::.                    / /(
	'_ .-;-.-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::::::.._
	(_ ( ( ( ( ( ( ( ( ( ( ( |  ))   -------PUEBLO ENEMIGO - BATALLA-------      _.>
	`_ `-;-`-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::::::''
	`::'                    \\\\(
	                       ) ))
	                      (_((
	           
       ___   )      
    @___, \\ /      
   /\\__,   |       
  / \\    / @\\     
_/__|___/___/_______
		
				""";
		String batalla2 = """
	                       ___
	                      ( ((
	                       ) ))
	.::.                    / /(
	'_ .-;-.-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::::::.._
	(_ ( ( ( ( ( ( ( ( ( ( ( |  ))   -------PUEBLO ENEMIGO - BATALLA-------      _.>
	`_ `-;-`-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::::::''
	`::'                    \\\\(
	                       ) ))
	                      (_((
	                                          
       ___   )                    ,  @         
    @___, \\ /                  @__\\  /\\      
   /\\__,   |                  /\\_, \\/ /      
  / \\    / @\\                / \\   (        
_/__|___/___/_______________/__|____\\__________                    
		""";
				
		String batalla3 = """
	                       ___
	                      ( ((
	                       ) ))
	.::.                    / /(
	'_ .-;-.-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::::::.._
	(_ ( ( ( ( ( ( ( ( ( ( ( |  ))   -------PUEBLO ENEMIGO - BATALLA-------      _.>
	`_ `-;-`-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::::::''
	`::'                    \\\\(
	                       ) ))
	                      (_((
	                                                         ___/________
       ___   )                    ,  @                    /    \\  \\ 
    @___, \\ /                  @__\\  /\\              @___/      \\@/
   /\\__,   |                  /\\_, \\/ /             /\\__/        |
  / \\    / @\\                / \\   (               / \\ /        / \\
_/__|___/___/_______________/__|____\\_____________/__/__________|__\\____
		""";
		
		for (int i = 0; i < 3; i++) {
			System.out.println("---> PUEBLO #" + numeroCiudad);
			if((i+1)%3==0) 	
				System.out.println(batalla3);
			else {
				
				if((i+1)%2==0)
					System.out.println(batalla2);
				else
					System.out.println(batalla);
			}
			System.out.println("CANTIDAD DE SOLDADOS TRAS LA BATALLA: [ " + soldados + " ]");	
			esperarYBorrarConsola(1000);		
		}
		
		System.out.println("---> PUEBLO #" + numeroCiudad);
		System.out.println(batalla3);
		System.out.println("CANTIDAD DE SOLDADOS TRAS LA BATALLA: [ " + soldados + " ]");	
		esperarYBorrarConsola(2000);

	}
	
	private static void animacionMuerte() {
		String muerte = """
		     _.------._
		    /  _    _  \\
		 _  ( (_\\  /_) )  _
		{ \\._\\   /\\   /_./ }
		/_-=-.}______{.-=-_\\		TU EJERCITO FUE DERROTADO
		 _  _.=(----)=._  _
		(_'-_.-"`~~`"-._-'_)
		 {_-            -_}
				""";
		String muerte2 = """
                            ,--.
                           {    }
                           K,   }
                          /  ~Y`
                     ,   /   /
                    {_'-K.__/
                      `/-.__L._
                      /  ' /`\\_}
                     /  ' /
             ____   /  ' /
      ,-'~~~~    ~~/  ' /_
    ,'             ``~~~  ',
   (                        Y
  {                         I
 {      -                    `,
 |       ',                   )
 |        |   ,..__      __. Y
 |    .,_./  Y ' / ^Y   J   )|
 \\           |' /   |   |   ||			TU EJERCITO FUE DERROTADO
  \\          L_/    . _ (_,.'(
   \\,   ,      ^^""' / |      )
     \\_  \\          /,L]     /
       '-_~-,       ` `   ./`
          `'{_            )
              ^^\\..___,.--`
				
				""";
		
		System.out.println(muerte2);
		System.out.println("Camino Recorrido:");
		for (int i = 0; i < camino.size(); i++) {
		    System.out.print(camino.get(i).getNumero() + " - ");
		}
		
	}
	
	private static void animacionVictoria() {
		String victoria = """
----------------                  |>>>                                 
----------------                  |                               
    \\,/             |>>>      _  _|_  _         |>>>              
                    |        |;| |;| |;|        |
                _  _|_  _    \\\\.    .  /    _  _|_  _
               |;|_|;|_|;|    \\\\:. ,  /    |;|_|;|_|;|
               \\\\..      /    ||;   . |    \\\\.    .  /
                \\\\.  ,  /     ||:  .  |     \\\\:  .  /
                 ||:   |_   _ ||_ . _ | _   _||:   |
                 ||:  .|||_|;|_|;|_|;|_|;|_|;||:.  |
                 ||:   ||.    .     .      . ||:  .|
                 ||: . || .     . .   .  ,   ||:   |       \\,/
                 ||:   ||:  ,  _______   .   ||: , |            /`\\	VICTORIA!
                 ||:   || .   /+++++++\\    . ||:   |
                 ||:   ||.    |+++++++| .    ||: . |
              __ ||: . ||: ,  |+++++++|.  . _||_   |
     ____--`~    '--~~__|.    |+++++__|----~    ~`---,              ___
-~--~                   ~---__|,--~'                  ~~----_____-~'   `~----~~
			         """;
		String victoria2 = """
----------------                  |>>                                
----------------                  |                               
    /`\\             |>>       _  _|_  _         |>>              
                    |        |;| |;| |;|        |
                _  _|_  _    \\\\.    .  /    _  _|_  _
               |;|_|;|_|;|    \\\\:. ,  /    |;|_|;|_|;|
               \\\\..      /    ||;   . |    \\\\.    .  /
                \\\\.  ,  /     ||:  .  |     \\\\:  .  /
                 ||:   |_   _ ||_ . _ | _   _||:   |
                 ||:  .|||_|;|_|;|_|;|_|;|_|;||:.  |
                 ||:   ||.    .     .      . ||:  .|
                 ||: . || .     . .   .  ,   ||:   |       /`\\
                 ||:   ||:  ,  _______   .   ||: , |            \\,/	VICTORIA!
                 ||:   || .   /+++++++\\    . ||:   |
                 ||:   ||.    |+++++++| .    ||: . |
              __ ||: . ||: ,  |+++++++|.  . _||_   |
     ____--`~    '--~~__|.    |+++++__|----~    ~`---,              ___
-~--~                   ~---__|,--~'                  ~~----_____-~'   `~----~~
			         """;
		
		for (int i = 0; i < 3; i++) {
			if(i%2==0)
				System.out.println(victoria);
			else
				System.out.println(victoria2);
			esperarYBorrarConsola(1000);				
		}
		
		System.out.println(victoria2);
		System.out.println("Camino Recorrido:");
		for (int i = 0; i < camino.size(); i++) {
		    System.out.print(camino.get(i).getNumero() + " - ");
		}
	}
	
	private static void esperarYBorrarConsola(int tiempo) {
		try {
	        Thread.sleep(tiempo); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		for (int i = 0; i < 50; i++) {
		    System.out.println();
		}
	}
}	

