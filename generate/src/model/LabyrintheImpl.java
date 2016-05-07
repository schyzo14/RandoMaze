package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

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
	public int se_connecter(String id, String mdp) throws MalformedURLException, RemoteException, NotBoundException {
		
		persistence.Labyrinthe labyBD = (persistence.Labyrinthe) Naming.lookup("MaBD");
		
        Utilisateur utilisateur = labyBD.selectUtilisateurByNom(id);
        if(utilisateur == null || !utilisateur.getMdpUser().equals(mdp)) {
        	return -1;
        } else {
        	return utilisateur.getIdUser();
        }

	}
}
