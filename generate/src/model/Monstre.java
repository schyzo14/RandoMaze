package model;

import java.io.Serializable;

public class Monstre extends Individu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7972387153447236652L;

	private int idPiece;
	
	public Monstre(int id, String nom, int pv, int idPiece) {
		super(id, nom, pv);
		this.setIdPiece(idPiece);
	}

	public int getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}
}
