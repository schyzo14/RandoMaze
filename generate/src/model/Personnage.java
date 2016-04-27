package model;

public class Personnage extends Individu {
	private Utilisateur user;
	
	public Personnage(int id, String nom, int pv) {
		super(id, nom, pv);
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
}