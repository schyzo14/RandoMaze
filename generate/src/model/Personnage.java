package model;

public class Personnage extends Individu {
	private Utilisateur user;
	private int idPiece;
	private int idUtilisateur;
	
	public Personnage(int id, String nom, int pv, int idPiece, int idUtilisateur) {
		super(id, nom, pv);
		setIdPiece(idPiece);
		setIdUtilisateur(idUtilisateur);
	}

	/**
	 * @return the user
	 */
	public Utilisateur getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public int getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}