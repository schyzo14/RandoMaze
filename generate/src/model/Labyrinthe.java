package model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Interface du serveur Labyrinthe
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public interface Labyrinthe extends Remote {

	// Utilisateur
	/**
	 * Connexion de l'utilisateur
	 * 
	 * @param id de l'utilisateur
	 * @param mdp de l'utilisateur
	 * @return Utilisateur
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public Utilisateur se_connecter(String id, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Cr�ation d'un nouvel utilisateur
	 * 
	 * @param nom de l'utilisateur
	 * @param mdp de l'utilisateur
	 * @return boolean
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public boolean creerUtilisateur(String nom, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	// Personnages
	/**
	 * R�cup�ration de tous les personnages d'un utilisateur
	 * 
	 * @param idUtilisateur : id de l'utilisateur
	 * @return liste des personnages de l'utilisateur
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public ArrayList<Personnage> getPersonnages(int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration d'un personnage � partir de son nom
	 * 
	 * @param nomPerso : nom du personnage
	 * @return personnage
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public Personnage getPersonnageByName(String nomPerso)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Cr�ation d'un nouveau personnage
	 * 
	 * @param nom du personnage
	 * @param idUtilisateur du personnage
	 * @return boolean
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public boolean creerPersonnage(String nom, int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Mise � jour d'un personnage
	 * 
	 * @param id du personnage
	 * @param nom du personnage
	 * @param pointvie du personnage
	 * @param idpiece du personnage
	 * @return boolean
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration de tous les personnages qui sont dans la m�me pi�ce qu'un personnage donn�
	 * 
	 * @param persoName : nom du personnage
	 * @return liste personnage
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public ArrayList<String> getPersonnagesSamePiece(String persoName)
			throws MalformedURLException, RemoteException, NotBoundException;

	// Piece
	/**
	 * R�cup�ration d'une pi�ce
	 * 
	 * @param idPiece : id de la piece
	 * @return piece
	 * @throws MalformedURLException e
	 * @throws RemoteException e
	 * @throws NotBoundException e
	 */
	public Piece getPieceById(int idPiece) throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration de toutes les pi�ces
	 * 
	 * @return liste des pieces
	 * @throws RemoteException remoteException
	 */
	public ArrayList<Piece> getPiece() throws RemoteException;

	// Monstre
	/**
	 * R�cup�ration du monstre d'une pi�ce
	 * 
	 * @param idPiece : id de la piece
	 * @return monstre
	 * @throws RemoteException : remoteException
	 */
	public Monstre getMonstreByPiece(int idPiece) throws RemoteException;

	/**
	 * Mise � jour d'un monstre
	 * 
	 * @param id du monstre
	 * @param nom du monstre
	 * @param pointvie du monstre
	 * @param idpiece du monstre
	 * @return boolean
	 * @throws RemoteException remoteException
	 */
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws RemoteException;

	// Autre
	/**
	 * Gestion de la chatbox dans le cas o� il y a plusieurs personnages dans une m�me salle
	 * 
	 * @param nomPerso : nom du personnage
	 * @param msg : message
	 * @throws RemoteException : remoteException
	 */
	public void notifyChat(String nomPerso, String msg) throws RemoteException;

	/**
	 * Fermeture de l'application
	 * 
	 * @throws RemoteException remoteException
	 */
	public void quitter() throws RemoteException;
}
