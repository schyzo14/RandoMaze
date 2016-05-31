package model;

import java.io.Serializable;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Monstre extends Individu implements Serializable {
	
	private static final long serialVersionUID = 7972387153447236652L;

	public Monstre(int id, String nom, int pv, int idPiece) {
		super(id, nom, pv, idPiece);
	}
}
