package Persistence;

import java.util.ArrayList;

public interface Labyrinthe extends java.rmi.Remote {

	// Pi�ces
	public ArrayList<Piece> selectPiece () 
			throws java.rmi.RemoteException;
	public boolean creerPiece (String nomserveur, int positionX, int positionY)
			throws java.rmi.RemoteException;

	// Porte
	public ArrayList<Porte> selectPorteByIdPiece (int idpiece)
			throws java.rmi.RemoteException;
	
	// Utilisateur
	public Utilisateur selectUtilisateurByNom (String nom)
			throws java.rmi.RemoteException;
	public boolean creerUtilisateur (String nom, String mdp)
			throws java.rmi.RemoteException;
	
	// Personnage
	public Personnage selectPersonnageByNom (String nom)
			throws java.rmi.RemoteException;
	public boolean creerPersonnage (String nom ,int idUtilisateur)
			throws java.rmi.RemoteException;
	public boolean updatePersonnage (int id, String nom ,int pointvie, int idpiece)
			throws java.rmi.RemoteException;
}
