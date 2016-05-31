package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import ui.Maze;

/**
 * Impl�mentation de l'interface Labyrinthe
 * 
 * @author Manon, Aurore, Youssef
 */
public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {

	private static final long serialVersionUID = 5382892920038127485L;

	persistence.Labyrinthe labyBD;
	public static HashMap<String, Maze> listeMap = new HashMap<String, Maze>();

	public LabyrintheImpl() throws RemoteException, MalformedURLException, NotBoundException {
		// Connexion RMI au serveur BD
		labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
	}

	
	/**
	 * Lancer les 2 serveurs
	 * 
	 * @throws Exception
	 */
	public static void demarrer() throws Exception {
		// Cr�ation des serveurs 1 et 2
		LocateRegistry.createRegistry(1098);
		Naming.rebind("MonServeur1", new LabyrintheImpl());
		System.out.println("MonServeur1 est lanc�.");
		LocateRegistry.createRegistry(1097);
		Naming.rebind("MonServeur2", new LabyrintheImpl());
		System.out.println("MonServeur2 est lanc�.");
	}


	/**
	 * Utilisateur
	 * Connexion de l'utilisateur
	 */
	@Override
	public Utilisateur se_connecter(String id, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException {
		return labyBD.selectUtilisateurByNom(id);
	}

	
	/**
	 * Cr�ation d'un nouvel utilisateur
	 */
	@Override
	public boolean creerUtilisateur(String nom, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException {
		boolean result = labyBD.creerUtilisateur(nom, mdp);
		return result;
	}


	/**
	 * Personnages
	 * R�cup�ration de tous les personnages d'un utilisateur
	 */
	@Override
	public ArrayList<model.Personnage> getPersonnages(int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException {
		return labyBD.selectPersonnageByUtilisateur(idUtilisateur);
	}

	
	/**
	 * R�cup�ration d'un personnage � partir de son nom
	 */
	@Override
	public Personnage getPersonnageByName(String nomPerso)
			throws MalformedURLException, RemoteException, NotBoundException {
		return labyBD.selectPersonnageByName(nomPerso);
	}


	/**
	 * Cr�ation d'un nouveau personnage
	 */
	@Override
	public boolean creerPersonnage(String nom, int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException {
		boolean result = labyBD.creerPersonnage(nom, idUtilisateur);
		return result;
	}


	/**
	 * Mise � jour d'un personnage
	 */
	@Override
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece)
			throws MalformedURLException, RemoteException, NotBoundException {
		boolean result = labyBD.updatePersonnage(id, nom, pointvie, idpiece);
		return result;
	}


	/**
	 * R�cup�ration de tous les personnages qui sont dans la m�me pi�ce qu'un personnage donn�
	 */
	@Override
	public ArrayList<String> getPersonnagesSamePiece(String persoName)
			throws MalformedURLException, RemoteException, NotBoundException {
		int idPiece = listeMap.get(persoName).getCurrentPiece().getIdPiece();
		ArrayList<String> persosSamePiece = new ArrayList<String>();
		persosSamePiece.add("Monstre");
		for (Maze m : listeMap.values()) {
			if (m.getCurrentPiece().getIdPiece() == idPiece && !m.getCurrentPerso().getNomIndiv().equals(persoName)) {
				persosSamePiece.add(m.getCurrentPerso().getNomIndiv());
			}
		}
		return persosSamePiece;
	}


	/**
	 * Piece
	 * R�cup�ration d'une pi�ce
	 */
	@Override
	public Piece getPieceById(int idPiece) throws MalformedURLException, RemoteException, NotBoundException {
		Piece piece = labyBD.selectPieceById(idPiece);
		return piece;
	}

	
	/**
	 * R�cup�ration de toutes les pi�ces
	 */
	@Override
	public ArrayList<Piece> getPiece() throws RemoteException {
		ArrayList<Piece> listPiece = labyBD.selectPiece();
		return listPiece;
	}


	/**
	 * Monstre
	 * R�cup�ration du monstre d'une pi�ce
	 */
	@Override
	public Monstre getMonstreByPiece(int idPiece) throws RemoteException {
		Monstre monstre = labyBD.selectMonstreByPiece(idPiece);
		return monstre;
	}


	/**
	 * Mise � jour d'un monstre
	 */
	@Override
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws RemoteException {
		boolean result = labyBD.updateMonstre(id, nom, pointvie, idpiece);
		return result;
	}


	/**
	 * Gestion de la chatbox dans le cas o� il y a plusieurs personnages dans une m�me salle
	 */
	@Override
	public void notifyChat(String nomPerso, String msg) throws RemoteException {
		int piece = listeMap.get(nomPerso).getCurrentPiece().getIdPiece();
		for (Maze cl : listeMap.values()) {
			if (cl.getCurrentPiece().getIdPiece() == piece && !cl.getCurrentPerso().getNomIndiv().equals(nomPerso)) {
				cl.getListeMsg().addElement(msg);
			}
		}
	}

	
	/**
	 * Fermeture de l'application
	 */
	@Override
	public void quitter() throws RemoteException {
		try {
			// Suppression du lien vers les serveurs
			Naming.unbind("MonServeur1");
			System.out.println("MonServeur1 arr�t�");
			Naming.unbind("MonServeur2");
			System.out.println("MonServeur2 arr�t�");

			// Fermeture de la BD
			labyBD.fermer();
			System.out.println("Connexion BD ferm�e");

			// Fermeture des serveurs
			UnicastRemoteObject.unexportObject(this, true);

			// quitter
			System.exit(0);
		} catch (MalformedURLException | NotBoundException e) {
			// Erreur fermeture serveurs
			e.printStackTrace();
		} catch (Exception e) {
			// Erreur fermeture BD
			e.printStackTrace();
		}
	}
}
