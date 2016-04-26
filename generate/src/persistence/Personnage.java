package persistence;

public class Personnage {

	private int idPersonnage;
	private String nomPersonnage;
	private int idUtilisateur;
	private int pointVie;
	private int idpiece;
	
	
	public int getIdPersonnage() {
		return idPersonnage;
	}
	
	public void setIdPersonnage(int idPersonnage) {
		this.idPersonnage = idPersonnage;
	}
	
	public String getNomPersonnage() {
		return nomPersonnage;
	}
	
	public void setNomPersonnage(String nomPersonnage) {
		this.nomPersonnage = nomPersonnage;
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public int getPointVie() {
		return pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}
	
	public int getIdpiece() {
		return idpiece;
	}
	
	public void setIdpiece(int idpiece) {
		this.idpiece = idpiece;
	}
	
}
