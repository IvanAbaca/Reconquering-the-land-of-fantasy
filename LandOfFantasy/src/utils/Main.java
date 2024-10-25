package utils;

import java.util.ArrayList;
import java.util.PriorityQueue;

import models.Ejercito;
import models.Nortaichian;
import models.Radaiteran;
import models.Raza;
import models.Reralopes;
import models.Wrives;

public class Main {

	public static void main(String[] args) {
		//=================================
		//Código provisto a modo de ejemplo
		//=================================
		PriorityQueue<Raza> tropaInicialPropia = new PriorityQueue<>();
		//Creamos una tropa de 5 Wrives
		for(int i = 0 ; i<5 ; i++)
			tropaInicialPropia.add(new Wrives());
		
		PriorityQueue<Raza> tropaAliada1 = new PriorityQueue<>();
		//Creamos una tropa de 5 Nortaichian
		for(int i = 0 ; i<5 ; i++)
			tropaAliada1.add(new Nortaichian());
		
		PriorityQueue<Raza> tropaAliada2 = new PriorityQueue<>();
		//Creamos una tropa de 5 Reralopes
		for(int i = 0 ; i<5 ; i++)
			tropaAliada2.add(new Reralopes());
		
		Ejercito ejercito = new Ejercito(tropaInicialPropia);
		
		//Esto añade una tropa al ejército y además hacen que descanse, 
		//solo se debería de usar en las ciudades pero de momento para 
		//demostrar como funciona el nuevo código de combate se está 
		//utilizando acá
		ejercito.descansar(tropaAliada1);
		ejercito.descansar(tropaAliada2);
		
		PriorityQueue<Raza> tropaEnemiga = new PriorityQueue<>();
		
		//Creamos 20 Radaiterans
		for(int i = 0 ; i<20 ; i++)
			tropaEnemiga.add(new Radaiteran());

		System.out.println(ejercito.batallar(tropaEnemiga));//Nota: los Radaiterans están OP
		
	}
	
}
