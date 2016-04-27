package model;

public class Individu {
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
}
