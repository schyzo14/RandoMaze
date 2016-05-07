package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ui.Personnage;

public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5382892920038127485L;
	
	public LabyrintheImpl() throws RemoteException {
		//super();
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
		persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
        return labyBD.selectUtilisateurByNom(id);
	}

	@Override
	public ArrayList<model.Personnage> getPersonnages(int idUtilisateur) throws MalformedURLException, RemoteException, NotBoundException {
		persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
    	return labyBD.selectPersonnageByUtilisateur(idUtilisateur);
	}

	@Override
	public boolean creerUtilisateur(String nom, String mdp) throws MalformedURLException, RemoteException, NotBoundException {
		persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
		boolean result = labyBD.creerUtilisateur(nom, mdp);
		return result;
	}
}
