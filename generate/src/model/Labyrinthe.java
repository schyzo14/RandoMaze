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
	 * @param id
	 * @param mdp
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Utilisateur se_connecter(String id, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Cr�ation d'un nouvel utilisateur
	 * 
	 * @param nom
	 * @param mdp
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean creerUtilisateur(String nom, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	// Personnages
	/**
	 * R�cup�ration de tous les personnages d'un utilisateur
	 * 
	 * @param idUtilisateur
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public ArrayList<Personnage> getPersonnages(int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration d'un personnage � partir de son nom
	 * 
	 * @param nomPerso
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Personnage getPersonnageByName(String nomPerso)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Cr�ation d'un nouveau personnage
	 * 
	 * @param nom
	 * @param idUtilisateur
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean creerPersonnage(String nom, int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * Mise � jour d'un personnage
	 * 
	 * @param id
	 * @param nom
	 * @param pointvie
	 * @param idpiece
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece)
			throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration de tous les personnages qui sont dans la m�me pi�ce qu'un personnage donn�
	 * 
	 * @param persoName
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public ArrayList<String> getPersonnagesSamePiece(String persoName)
			throws MalformedURLException, RemoteException, NotBoundException;

	// Piece
	/**
	 * R�cup�ration d'une pi�ce
	 * 
	 * @param idPiece
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Piece getPieceById(int idPiece) throws MalformedURLException, RemoteException, NotBoundException;

	/**
	 * R�cup�ration de toutes les pi�ces
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Piece> getPiece() throws RemoteException;

	// Monstre
	/**
	 * R�cup�ration du monstre d'une pi�ce
	 * 
	 * @param idPiece
	 * @return
	 * @throws RemoteException
	 */
	public Monstre getMonstreByPiece(int idPiece) throws RemoteException;

	/**
	 * Mise � jour d'un monstre
	 * 
	 * @param id
	 * @param nom
	 * @param pointvie
	 * @param idpiece
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws RemoteException;

	// Autre
	/**
	 * Gestion de la chatbox dans le cas o� il y a plusieurs personnages dans une m�me salle
	 * 
	 * @param nomPerso
	 * @param msg
	 * @throws RemoteException
	 */
	public void notifyChat(String nomPerso, String msg) throws RemoteException;

	/**
	 * Fermeture de l'application
	 * 
	 * @throws RemoteException
	 */
	public void quitter() throws RemoteException;
}
