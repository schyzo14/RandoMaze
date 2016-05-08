package model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Labyrinthe extends Remote {
	
	public Utilisateur se_connecter(String id, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	public ArrayList<Personnage> getPersonnages (int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public boolean creerUtilisateur (String nom, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;
}
