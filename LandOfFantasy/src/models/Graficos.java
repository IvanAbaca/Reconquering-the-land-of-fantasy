package models;

import java.util.ArrayList;
import java.util.List;

public class Graficos {
	private static ArrayList<Ciudad> camino = new ArrayList<>();
	private static ArrayList<Integer> cantSoldados = new ArrayList<>();
	
	public static void animacionPartida(int ciudadPartida , int soldados) {
		String partida = """
        _    .  ,   .           .
    *  / \\_ *  / \\_      _  *        *   /\\'__        *
      /    \\  /    \\,   ((        .    _/  /  \\  *'.
 .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.		COMIENZA EL VIAJE!
    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *
  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\	   O
 /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-     /|\\
/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._	  / \\			
				""";
		String partida2 = """
		        _    .  ,   .           .
		    *  / \\_ *  / \\_      _  *        *   /\\'__        *
		      /    \\  /    \\,   ((        .    _/  /  \\  *'.
		 .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.		COMIENZA EL VIAJE!!
		    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *
		  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\		  	  O
		 /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-     		 /|\\
		/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._	   		 / \\			
						""";
	
	String partida3 = """
	        _    .  ,   .           .
	    *  / \\_ *  / \\_      _  *        *   /\\'__        *
	      /    \\  /    \\,   ((        .    _/  /  \\  *'.
	 .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.		COMIENZA EL VIAJE!!!
	    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *
	  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\   			  	 O
	 /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-      		 		/|\\
	/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._	    		 		/ \\		
					""";
	for (int i = 0; i < 50; i++) {
	    System.out.println();
	}
	
	for (int i = 0; i < 3; i++) {
		System.out.println("---> PUEBLO #" + ciudadPartida);
		if((i+1)%3==0) 	
			System.out.println(partida3);
		else {
			
			if((i+1)%2==0)
				System.out.println(partida2);
			else
				System.out.println(partida);
		}
		System.out.println("COMIENZA LA TRAVESIA CON [ " + soldados + " ] SOLDADOS");	
		esperarYBorrarConsola(2000);				
	}
}
	
	public static void animacionDescanso(int numeroCiudad,int soldados) {
		
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
	
	public static void animacionBatalla(int numeroCiudad,int soldados) {

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
	
	public static void animacionMuerte(List<Ciudad> camino,int nroCiudadMuerte, int cantSoldados, int cantDias) {
		String muerte = """
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
		
		System.out.println(muerte);
		Graficos.caminoRecorrido(camino);
		System.out.println(	" El ejercito fue derrotado en (" 			+ nroCiudadMuerte + 
				") Donde se enfrentó a " 	+ cantSoldados + " Soldado/s enemigos."+
				" Duración: " 				+ cantDias + " Día/s");		
	}
	
	public static void animacionVictoria(List<Ciudad> camino, int cantSoldados, int cantDias) {
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
		
		for (int i = 0; i < 4; i++) {
			if(i%2==0)
				System.out.println(victoria);
			else
				System.out.println(victoria2);
			caminoRecorrido(camino);
			System.out.println(	" El ejercito fue victorioso, con " + cantSoldados + " soldado/s."+
					" Duración: " + cantDias + " Día/s" );
			esperarYBorrarConsola(1000);				
		}
		
		System.out.println(victoria2);
		caminoRecorrido(camino);
		System.out.println(	" El ejercito fue victorioso, con " + cantSoldados + " soldado/s."+
				" Duración: " + cantDias + " Día/s" );
	}
	
	private static void caminoRecorrido(List<Ciudad> camino) {
		System.out.println("Camino Planeado:");
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

