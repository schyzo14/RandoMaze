package model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import ui.Maze;

public interface Labyrinthe extends Remote {
	
	public Utilisateur se_connecter(String id, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;

	public ArrayList<Personnage> getPersonnages (int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public boolean creerUtilisateur (String nom, String mdp)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public boolean creerPersonnage (String nom, int idUtilisateur)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public boolean updatePersonnage (int id, String nom ,int pointvie, int idpiece)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public Piece getPieceById(int idPiece)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public ArrayList<Piece> getPiece () throws RemoteException;
	
	public HashMap<String, Maze> getListeMap() throws RemoteException;
	public void setListeMap(HashMap<String, Maze> listeMap) throws RemoteException;
	
	public void notifyChat(String nomPerso, String msg) throws RemoteException;
	
	public ArrayList<String> getPersonnagesSamePiece (String persoName)
			throws MalformedURLException, RemoteException, NotBoundException;
	
	public Monstre getMonstreByPiece (int idPiece)
			throws RemoteException;
	public boolean updateMonstre (int id, String nom ,int pointvie, int idpiece)
			throws RemoteException;
	
	public void quitter() 
			throws RemoteException;
}
