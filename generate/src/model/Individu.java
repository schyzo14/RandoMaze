package model;

import java.io.Serializable;
import java.util.Random;

public class Individu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2211726595953913891L;
	private int idIndiv;
	private String nomIndiv;
	private int nbPVIndiv;
	
	public Individu(int id, String nom, int PV) {
		idIndiv = id;
		nomIndiv = nom;
		nbPVIndiv = PV;
	}
	
	/**
	 * @return the idIndiv
	 */
	public int getIdIndiv() {
		return idIndiv;
	}
	/**
	 * @param idIndiv the idIndiv to set
	 */
	public void setIdIndiv(int idIndiv) {
		this.idIndiv = idIndiv;
	}
	/**
	 * @return the nomIndiv
	 */
	public String getNomIndiv() {
		return nomIndiv;
	}
	/**
	 * @param nomIndiv the nomIndiv to set
	 */
	public void setNomIndiv(String nomIndiv) {
		this.nomIndiv = nomIndiv;
	}
	/**
	 * @return the nbPVIndiv
	 */
	public int getNbPVIndiv() {
		return nbPVIndiv;
	}
	/**
	 * @param nbPVIndiv the nbPVIndiv to set
	 */
	public void setNbPVIndiv(int nbPVIndiv) {
		this.nbPVIndiv = nbPVIndiv;
	}
	
	/**
	 * Retirer des PV
	 * 
	 * @return False=monstre / True=personnage
	 */
	public static boolean retirerPV () {
		
		// attendre 1 seconde
		try {
		    Thread.sleep(1000);                 // 1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		// retirer aléatoirement des PV
		Random rand = new Random();
		int val = rand.nextInt(1 - 0 + 1) + 0;
		if (val == 0) {
			return false; // Retirer au monstre
		} else {
			return true; // Retirer au personnage
		}
		
	}
	
}
