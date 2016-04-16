package persistence;

public class Piece {

	private int idPiece;
	private String nomServeur;
	private int positionX;
	private int positionY;
	
	
	public int getIdPiece() {
		return idPiece;
	}
	
	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}

	public String getNomServeur() {
		return nomServeur;
	}

	public void setNomServeur(String nomServeur) {
		this.nomServeur = nomServeur;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionsX) {
		this.positionX = positionsX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
}
