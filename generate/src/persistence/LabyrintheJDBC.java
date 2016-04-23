package persistence;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabyrintheJDBC extends UnicastRemoteObject implements Labyrinthe{

	private Connection conn;
	
	// Piece
	private static final String reqSelectPiece = "select idpiece, nomserveur, positionX, positionY from PIECE";
	private static final String reqInsertPiece = "insert into PIECE (nomserveur, positionX, positionY) values (?, ?, ?)";
	
	private PreparedStatement reqSelectPieceSt = null;
	private PreparedStatement reqInsertPieceSt = null;
	
	// Porte
	private static final String reqSelectPorteByIdPiece = "select idporte, situationporte, idpiece from PORTE where idpiece=?";
	
	private PreparedStatement reqSelectPorteByIdPieceSt = null;
	
	// Utilisateur
	private static final String reqSelectUtilisateurByNom = "select idutilisateur, nomutilisateur, mdputilisateur from UTILISATEUR where nomutilisateur='?'";
	private static final String reqInsertUtilisateur = "insert into UTILISATEUR (nomutilisateur, mdputilisateur) values (?, ?)";
	
	private PreparedStatement reqSelectUtilisateurByNomSt = null;
	private PreparedStatement reqInsertUtilisateurSt = null;
	
	// Personnage
	private static final String reqSelectPersonnageByNom = "select idpersonnage, nompersonnage, idutilisateur, pointvie, idpiece from PERSONNAGE";
	private static final String reqInsertPersonnage = "insert into PERSONNAGE (nompersonnage, idutilisateur, pointvie, idpiece) values (?, ?, ?, ?) ";
	private static final String reqUpdatePersonnage = "update PERSONNAGE set nompersonnage=?, pointvie=?, idpiece=? where idpersonnage=?";

	private PreparedStatement reqSelectPersonnageByNomSt = null;
	private PreparedStatement reqInsertPersonnageSt = null;
	private PreparedStatement reqUpdatePersonnageSt = null;
	
	
	protected LabyrintheJDBC(String nomBD) throws RemoteException {
		try {
			// r�cup�ration du driver
		    Class.forName("org.h2.Driver");
		    // cr�ation d'une connexion
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
	        // construction des prepared statement
		    // Piece
		    reqSelectPieceSt = conn.prepareStatement(reqSelectPiece);
		    reqInsertPieceSt = conn.prepareStatement(reqInsertPiece);
		    // Porte
		    reqSelectPorteByIdPieceSt = conn.prepareStatement(reqSelectPorteByIdPiece);
		    // Utilisateur
		    reqSelectUtilisateurByNomSt = conn.prepareStatement(reqSelectUtilisateurByNom);
		    reqInsertUtilisateurSt = conn.prepareStatement(reqInsertUtilisateur);
		    // Personnage
		    reqSelectPersonnageByNomSt = conn.prepareStatement(reqSelectPersonnageByNom);
		    reqInsertPersonnageSt = conn.prepareStatement(reqInsertPersonnage);
		    reqUpdatePersonnageSt = conn.prepareStatement(reqUpdatePersonnage);
		} catch(Exception e) {
			// il y a eu une erreur
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Piece> selectPiece() throws RemoteException {
		try {
			ResultSet rs = reqSelectPieceSt.executeQuery();
			
			ArrayList<Piece> listPieces = new ArrayList<Piece>();
			while (rs.next()) {
				Piece piece = new Piece();
				piece.setIdPiece(rs.getInt(1));
				piece.setNomServeur(rs.getString(2));
				piece.setPositionX(rs.getInt(3));
				piece.setPositionY(rs.getInt(4));
				listPieces.add(piece);
			}
			return listPieces;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public boolean creerPiece(String nomserveur, int positionX, int positionY) throws RemoteException {
		try {
			reqInsertPieceSt.setString(1, nomserveur);
			reqInsertPieceSt.setInt(2,positionX);
			reqInsertPieceSt.setInt(3,positionY);
        	if (reqInsertPieceSt.executeUpdate()==1)
				return true;
        	else
        		return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public ArrayList<Porte> selectPorteByIdPiece(int idpiece) throws RemoteException {
		try {
			reqSelectPorteByIdPieceSt.setInt(1, idpiece);
			ResultSet rs = reqSelectPorteByIdPieceSt.executeQuery();
			
			ArrayList<Porte> listPortes = new ArrayList<Porte>();
			while (rs.next()) {
				Porte porte = new Porte();
				porte.setIdporte(rs.getInt(1));
				porte.setSituationporte(rs.getString(2));
				porte.setIdpiece(rs.getInt(3));
				listPortes.add(porte);
			}
			return listPortes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Utilisateur selectUtilisateurByNom(String nom) throws RemoteException {
		try {
			reqSelectUtilisateurByNomSt.setString(1, nom);
			ResultSet rs = reqSelectUtilisateurByNomSt.executeQuery();
			
			Utilisateur utilisateur = new Utilisateur();
			while (rs.next()) {
				utilisateur.setIdUtilisateur(rs.getInt(1));
				utilisateur.setNomUtilisateur(rs.getString(2));
				utilisateur.setMdpUtilisateur(rs.getString(3));
			}
			return utilisateur;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean creerUtilisateur(String nom, String mdp) throws RemoteException {
		try {
			reqInsertUtilisateurSt.setString(1, nom);
			reqInsertUtilisateurSt.setString(2,mdp);
        	if (reqInsertUtilisateurSt.executeUpdate()==1)
				return true;
        	else
        		return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Personnage selectPersonnageByNom(String nom) throws RemoteException {
		try {
			reqSelectPersonnageByNomSt.setString(1, nom);
			ResultSet rs = reqSelectPersonnageByNomSt.executeQuery();
			
			Personnage personnage = new Personnage();
			while (rs.next()) {
				personnage.setIpPersonnage(rs.getInt(1));
				personnage.setNomPersonnage(rs.getString(2));
				personnage.setIdUtilisateur(rs.getInt(3));
				personnage.setPointVie(rs.getInt(4));
				personnage.setIdpiece(rs.getInt(5));
			}
			return personnage;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean creerPersonnage(String nom, int idUtilisateur) throws RemoteException {
		try {
			reqInsertPersonnageSt.setString(1, nom);
			reqInsertPersonnageSt.setInt(2, idUtilisateur);
			reqInsertPersonnageSt.setInt(3, 10);
			reqInsertPersonnageSt.setInt(4, 1);
        	if (reqInsertPersonnageSt.executeUpdate()==1)
				return true;
        	else
        		return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece) throws RemoteException {
		try {
			reqUpdatePersonnageSt.setString(1, nom);
			reqUpdatePersonnageSt.setInt(2, pointvie);
			reqUpdatePersonnageSt.setInt(3, idpiece);
			reqUpdatePersonnageSt.setInt(4, id);
        	if (reqUpdatePersonnageSt.executeUpdate()==1)
				return true;
        	else
        		return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void fermer() throws Exception {		
		try {
			conn.close();
		} catch(Exception ex) {
			// il y a eu une erreur
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		LabyrintheJDBC labyrintheJDBC = new LabyrintheJDBC("Labyrinthe");
		Naming.bind("Labyrinthe", labyrintheJDBC);
		System.out.println("Connexion BD r�usie");
//		labyrintheJDBC.creerPiece("s1", 1, 2);
//		ArrayList<Piece> listPiece = labyrintheJDBC.selectPiece();
//		for (Piece piece : listPiece) {
//			System.out.println(piece.getIdPiece() + " - " + piece.getNomServeur() +
//					" - " + piece.getPositionX() + "/" + piece.getPositionY());
//		}
	}

}