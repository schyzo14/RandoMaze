package persistence;

import java.util.ArrayList;

import model.Monstre;
import model.Personnage;
import model.Piece;
import model.Porte;
import model.Utilisateur;

public interface Labyrinthe extends java.rmi.Remote {

	// Pièces
	public ArrayList<Piece> selectPiece () 
			throws java.rmi.RemoteException;
	
	public Piece selectPieceById(int idPiece)
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
	public ArrayList<Personnage> selectPersonnageByUtilisateur (int idUtilisateur)
			throws java.rmi.RemoteException;
	public boolean creerPersonnage (String nom ,int idUtilisateur)
			throws java.rmi.RemoteException;
	public boolean updatePersonnage (int id, String nom ,int pointvie, int idpiece)
			throws java.rmi.RemoteException;
	
	// Monstre
	public Monstre selectMonstreByPiece (int idPiece)
			throws java.rmi.RemoteException;
	public boolean updateMonstre (int id, String nom ,int pointvie, int idpiece)
			throws java.rmi.RemoteException;
	
	// Fermeture
	public void fermer() 
			throws Exception;
}
