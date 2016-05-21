package model;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.Maze;

public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5382892920038127485L;
	
	persistence.Labyrinthe labyBD;
	public static HashMap<String, Maze> listeMap = new HashMap<String, Maze>();
	
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
	
	@Override
	public ArrayList<Piece> getPiece() throws RemoteException {
		ArrayList<Piece> listPiece = labyBD.selectPiece();
		return listPiece;
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

	/**
	 * @return the listeMap
	 */
	public HashMap<String, Maze> getListeMap() throws RemoteException {
		return listeMap;
	}

	/**
	 * @param listeMap the listeMap to set
	 */
	public void setListeMap(HashMap<String, Maze> listeMap) throws RemoteException {
		this.listeMap = listeMap;
	}

	@Override
	public void notifyChat(String nomPerso, String msg) throws RemoteException {
		int piece = listeMap.get(nomPerso).getCurrentPiece().getIdPiece();
		for(Maze cl : listeMap.values()) {
			if(cl.getCurrentPiece().getIdPiece() == piece &&
					!cl.getCurrentPerso().getNomIndiv().equals(nomPerso)) {
				cl.getListeMsg().addElement(msg);
			}
		}
	}

	@Override
	public ArrayList<String> getPersonnagesSamePiece(String persoName)
			throws MalformedURLException, RemoteException, NotBoundException {
		int idPiece = listeMap.get(persoName).getCurrentPiece().getIdPiece();
		ArrayList<String> persosSamePiece = new ArrayList<String>();
		persosSamePiece.add("Monstre");
		for(Maze m : listeMap.values()) {
			if(m.getCurrentPiece().getIdPiece() == idPiece &&
					!m.getCurrentPerso().getNomIndiv().equals(persoName)) {
				persosSamePiece.add(m.getCurrentPerso().getNomIndiv());
			}
		}
		return persosSamePiece;
	}
}
