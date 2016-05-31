package model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 2544947169058657840L;

	private int idUser;
	private String nomUser;
	private String mdpUser;
	private HashMap<Integer, Personnage> listePerso;

	public Utilisateur(int id, String nom, String mdp) {
		idUser = id;
		nomUser = nom;
		mdpUser = mdp;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}

	/**
	 * @param nomUser
	 *            the nomUser to set
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	/**
	 * @return the mdpUser
	 */
	public String getMdpUser() {
		return mdpUser;
	}

	/**
	 * @param mdpUser
	 *            the mdpUser to set
	 */
	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}

	/**
	 * @return the listePerso
	 */
	public HashMap<Integer, Personnage> getListePerso() {
		return listePerso;
	}

	/**
	 * @param listePerso
	 *            the listePerso to set
	 */
	public void setListePerso(HashMap<Integer, Personnage> listePerso) {
		this.listePerso = listePerso;
	}
}
