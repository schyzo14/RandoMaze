package model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Labyrinthe extends Remote {
	
	public int se_connecter(String id, String mdp) throws MalformedURLException, RemoteException, NotBoundException;
}
