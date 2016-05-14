package model;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.Personnage;

public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5382892920038127485L;
	
	persistence.Labyrinthe labyBD;
	
	public LabyrintheImpl() throws RemoteException, MalformedURLException, NotBoundException {
		labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
	}
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1098);
	 	Naming.rebind("MonServeur1", new LabyrintheImpl());
	 	System.out.println("MonServeur1 est lancé.");
	 	LocateRegistry.createRegistry(1097);
	 	Naming.rebind("MonServeur2", new LabyrintheImpl());
	 	System.out.println("MonServeur2 est lancé.");
	}

	@Override
	public Utilisateur se_connecter(String id, String mdp) throws MalformedURLException, RemoteException, NotBoundException {
		//persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
        return labyBD.selectUtilisateurByNom(id);
	}

	@Override
	public ArrayList<model.Personnage> getPersonnages(int idUtilisateur) throws MalformedURLException, RemoteException, NotBoundException {
		//persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
    	return labyBD.selectPersonnageByUtilisateur(idUtilisateur);
	}

	@Override
	public boolean creerUtilisateur(String nom, String mdp) throws MalformedURLException, RemoteException, NotBoundException {
		//persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
		boolean result = labyBD.creerUtilisateur(nom, mdp);
		return result;
	}
	
	@Override
	public boolean creerPersonnage(String nom, int idUtilisateur) throws MalformedURLException, RemoteException, NotBoundException {
		//persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
		boolean result = labyBD.creerPersonnage(nom, idUtilisateur);
		return result;
	}
	
	@Override
	public boolean updatePersonnage(int id, String nom ,int pointvie, int idpiece) throws MalformedURLException, RemoteException, NotBoundException {
		//persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
		boolean result = labyBD.updatePersonnage(id, nom , pointvie, idpiece);
		return result;
	}

	@Override
	public Piece getPieceById(int idPiece)
			throws MalformedURLException, RemoteException, NotBoundException {
		Piece piece = labyBD.selectPieceById(idPiece);
		return piece;
	}
	
	public static void afficherPopUp(String mess) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
    		JOptionPane.showMessageDialog(null, mess);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
