package model;

import java.io.Serializable;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Porte implements Serializable {

	private static final long serialVersionUID = -1251738136255779026L;
	
	public int idPorte;
	public String positionPorte;
	public int idPiece;
	
	public Porte(int id, String situation) {
		idPorte = id;
		positionPorte = situation;
	}

	/**
	 * @return the idPorte
	 */
	public int getIdPorte() {
		return idPorte;
	}

	/**
	 * @param idPorte the idPorte to set
	 */
	public void setIdPorte(int idPorte) {
		this.idPorte = idPorte;
	}

	/**
	 * @return the positionPorte
	 */
	public String getPositionPorte() {
		return positionPorte;
	}

	/**
	 * @param positionPorte the positionPorte to set
	 */
	public void setPositionPorte(String positionPorte) {
		this.positionPorte = positionPorte;
	}

	/**
	 * @return the idPiece
	 */
	public int getIdPiece() {
		return idPiece;
	}

	/**
	 * @param idPiece the idPiece to set
	 */
	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}

}
