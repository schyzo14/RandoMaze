package model;

public class Monstre extends Individu {
	
	public Monstre(int id, String nom) {
		super(id, nom, 5);
	}
	
	/**
	 * Cr�e un monstre al�atoirement pour un combat
	 * 
	 * @return Monstre monstre
	 */
	public Monstre createMonstre () {
		Monstre monstre;
		
		int val = 1 + ((int)Math.random() * (4 - 1));
		
		switch (val) {
			case 1:
				monstre = new Monstre(1, "M�chant 1");
				break;
			case 2:
				monstre = new Monstre(2, "M�chant 2");
				break;
			case 3:
				monstre = new Monstre(3, "M�chant 3");
				break;
			case 4:
				monstre = new Monstre(4, "M�chant 4");
				break;
			default :
				monstre = new Monstre(5, "M�chant 5");
				break;
		}
		
		return monstre;
	}
	
	/**
	 * Cr�e le boss de fin pour le combat dans la derni�re salle
	 * 
	 * @return Monstre boss
	 */
	public Monstre createMonstreBoss () {
		Monstre monstre = new Monstre(0, "M�chant Boss");
		return monstre;
	}
}
