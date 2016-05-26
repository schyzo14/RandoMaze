package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Piece implements Serializable {

	private static final long serialVersionUID = -6444614151907722565L;
	
	private int idPiece;
	private String nomServer;
	private int posX;
	private int posY;
	private ArrayList<Porte> listePortes;
	
	public Piece(int id, String nom, int x, int y) {
		idPiece = id;
		nomServer = nom;
		posX = x;
		posY = y;
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

	/**
	 * @return the nomServer
	 */
	public String getNomServer() {
		return nomServer;
	}

	/**
	 * @param nomServer the nomServer to set
	 */
	public void setNomServer(String nomServer) {
		this.nomServer = nomServer;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the listePortes
	 */
	public ArrayList<Porte> getListePortes() {
		return listePortes;
	}

	/**
	 * @param listePortes the listePortes to set
	 */
	public void setListePortes(ArrayList<Porte> listePortes) {
		this.listePortes = listePortes;
	}
}
