package model;

import java.io.Serializable;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Personnage extends Individu implements Serializable {

	private static final long serialVersionUID = 596693072202458878L;

	private int idUtilisateur;

	public Personnage(int id, String nom, int pv, int idPiece, int idUtilisateur) {
		super(id, nom, pv, idPiece);
		setIdUtilisateur(idUtilisateur);
	}

	/**
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur
	 *            the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}