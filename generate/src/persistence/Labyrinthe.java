package persistence;

import java.util.ArrayList;

import model.Monstre;
import model.Personnage;
import model.Piece;
import model.Porte;
import model.Utilisateur;

/**
 * Interface de LabyrintheJDBC
 * 
 * @author Manon, Aurore, Youssef
 */
public interface Labyrinthe extends java.rmi.Remote {

	// Pièce
	/**
	 * Liste de toutes les pieces
	 * 
	 * @return liste des pieces
	 * @throws java.rmi.RemoteException remoteException
	 */
	public ArrayList<Piece> selectPiece() throws java.rmi.RemoteException;

	/**
	 * Retourne une piece grace à son id
	 * 
	 * @param idPiece : identifiant de la piece
	 * @return piece : Piece
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public Piece selectPieceById(int idPiece) throws java.rmi.RemoteException;

	// Porte
	/**
	 * Retourne la liste des portes d'une piece
	 * 
	 * @param idpiece : identifiant de la piece
	 * @return liste des portes
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public ArrayList<Porte> selectPorteByIdPiece(int idpiece) throws java.rmi.RemoteException;

	// Utilisateur
	/**
	 * Retourne un utilisateur grave à son nom
	 * 
	 * @param nom de l'utilisateur
	 * @return Utilisateur du nom
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public Utilisateur selectUtilisateurByNom(String nom) throws java.rmi.RemoteException;

	/**
	 * Créer un utilisateur avec son nom et mdp
	 * 
	 * @param nom : nom de l'utilisateur
	 * @param mdp : mot de passe
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public boolean creerUtilisateur(String nom, String mdp) throws java.rmi.RemoteException;

	// Personnage
	/**
	 * Retourne les personnages d'un utilisateur
	 * 
	 * @param idUtilisateur : identifiant de l'utilisateur
	 * @return liste de personnages
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public ArrayList<Personnage> selectPersonnageByUtilisateur(int idUtilisateur) throws java.rmi.RemoteException;

	/**
	 * Retourne un personnage grace à son nom
	 * 
	 * @param nomPerso : nom de personnage
	 * @return personnage du nom
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public Personnage selectPersonnageByName(String nomPerso) throws java.rmi.RemoteException;

	/**
	 * Créer un personnage avec son nom et utilisateur
	 * 
	 * @param nom : nom du personnage
	 * @param idUtilisateur : identifiant de l'utilisateur
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public boolean creerPersonnage(String nom, int idUtilisateur) throws java.rmi.RemoteException;

	/**
	 * Mettre à jour un personnage
	 * 
	 * @param id du personnage
	 * @param nom du personnage
	 * @param pointvie du personnage
	 * @param idpiece : identifiant de la pièce du personnage
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece) throws java.rmi.RemoteException;

	// Monstre
	/**
	 * Retourne le monstre d'une piece
	 * 
	 * @param idPiece : id de la piece
	 * @return monstre de la piece
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public Monstre selectMonstreByPiece(int idPiece) throws java.rmi.RemoteException;

	/**
	 * Mettre à jour un monstre
	 * 
	 * @param id du monstre
	 * @param nom du monstre
	 * @param pointvie du monstre
	 * @param idpiece : id de la piece du monstre
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws java.rmi.RemoteException;

	// Fermeture
	/**
	 * Fermer l'accès à la bd
	 * 
	 * @throws Exception e
	 */
	public void fermer() throws Exception;
}
