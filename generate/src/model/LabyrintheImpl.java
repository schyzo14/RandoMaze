package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5382892920038127485L;
	
	public LabyrintheImpl() throws RemoteException {
		super();
	}
}
