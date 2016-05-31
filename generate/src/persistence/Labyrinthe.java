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
	 * @throws java.rmi.RemoteException
	 */
	public ArrayList<Piece> selectPiece() throws java.rmi.RemoteException;

	/**
	 * Retourne une piece grace à son id
	 * 
	 * @param idPiece
	 * @return piece
	 * @throws java.rmi.RemoteException
	 */
	public Piece selectPieceById(int idPiece) throws java.rmi.RemoteException;

	// Porte
	/**
	 * Retourne la liste des portes d'une piece
	 * 
	 * @param idpiece
	 * @return liste des portes
	 * @throws java.rmi.RemoteException
	 */
	public ArrayList<Porte> selectPorteByIdPiece(int idpiece) throws java.rmi.RemoteException;

	// Utilisateur
	/**
	 * Retourne un utilisateur grave à son nom
	 * 
	 * @param nom
	 * @return Utilisateur
	 * @throws java.rmi.RemoteException
	 */
	public Utilisateur selectUtilisateurByNom(String nom) throws java.rmi.RemoteException;

	/**
	 * Créer un utilisateur avec son nom et mdp
	 * 
	 * @param nom
	 * @param mdp
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException
	 */
	public boolean creerUtilisateur(String nom, String mdp) throws java.rmi.RemoteException;

	// Personnage
	/**
	 * Retourne les personnages d'un utilisateur
	 * 
	 * @param idUtilisateur
	 * @return liste de personnages
	 * @throws java.rmi.RemoteException
	 */
	public ArrayList<Personnage> selectPersonnageByUtilisateur(int idUtilisateur) throws java.rmi.RemoteException;

	/**
	 * Retourne un personnage grace à son nom
	 * 
	 * @param nomPerso
	 * @return personnage
	 * @throws java.rmi.RemoteException
	 */
	public Personnage selectPersonnageByName(String nomPerso) throws java.rmi.RemoteException;

	/**
	 * Créer un personnage avec son nom et utilisateur
	 * 
	 * @param nom
	 * @param idUtilisateur
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException
	 */
	public boolean creerPersonnage(String nom, int idUtilisateur) throws java.rmi.RemoteException;

	/**
	 * Mettre à jour un personnage
	 * 
	 * @param id
	 * @param nom
	 * @param pointvie
	 * @param idpiece
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException
	 */
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece) throws java.rmi.RemoteException;

	// Monstre
	/**
	 * Retourne le monstre d'une piece
	 * 
	 * @param idPiece
	 * @return monstre
	 * @throws java.rmi.RemoteException
	 */
	public Monstre selectMonstreByPiece(int idPiece) throws java.rmi.RemoteException;

	/**
	 * Mettre à jour un monstre
	 * 
	 * @param id
	 * @param nom
	 * @param pointvie
	 * @param idpiece
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException
	 */
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws java.rmi.RemoteException;

	// Fermeture
	/**
	 * Fermer l'accès à la bd
	 * 
	 * @throws Exception
	 */
	public void fermer() throws Exception;
}
