package model;

import java.io.Serializable;
import java.util.Random;

public class Monstre extends Individu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7972387153447236652L;

	public Monstre(int id, String nom) {
		super(id, nom, 5);
	}
	
	/**
	 * Crée un monstre aléatoirement pour un combat
	 * 
	 * @return Monstre monstre
	 */
	public Monstre createMonstre () {
		Monstre monstre;
		
		Random rand = new Random();
		int val = rand.nextInt(4 - 1 + 1) + 1;
		
		switch (val) {
			case 1:
				monstre = new Monstre(1, "Méchant 1");
				break;
			case 2:
				monstre = new Monstre(2, "Méchant 2");
				break;
			case 3:
				monstre = new Monstre(3, "Méchant 3");
				break;
			case 4:
				monstre = new Monstre(4, "Méchant 4");
				break;
			default :
				monstre = new Monstre(5, "Méchant 5");
				break;
		}
		
		return monstre;
	}
	
	/**
	 * Crée le boss de fin pour le combat dans la dernière salle
	 * 
	 * @return Monstre boss
	 */
	public Monstre createMonstreBoss () {
		Monstre monstre = new Monstre(0, "Méchant Boss");
		return monstre;
	}
}
