package model;

import java.util.ArrayList;

public class Porte {
	public int idPorte;
	public String positionPorte;
	public ArrayList<Piece> listePieces;
	
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
	 * @return the listePieces
	 */
	public ArrayList<Piece> getListePieces() {
		return listePieces;
	}

	/**
	 * @param listePieces the listePieces to set
	 */
	public void setListePieces(ArrayList<Piece> listePieces) {
		this.listePieces = listePieces;
	}
}
