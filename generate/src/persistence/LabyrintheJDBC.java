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
import java.util.HashMap;

import model.Monstre;
import model.Personnage;
import model.Piece;
import model.Porte;
import model.Utilisateur;

/**
 * Permet de communiquer avec la BD
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class LabyrintheJDBC extends UnicastRemoteObject implements Labyrinthe{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6415704478523465430L;

	private Connection conn;
	
	// Piece
	private static final String reqSelectPiece = "select idpiece, nomserveur, positionX, positionY from PIECE";
	private static final String reqSelectPieceById = "select idpiece, nomserveur, positionX, positionY from PIECE where idpiece=?";
	
	private PreparedStatement reqSelectPieceSt = null;
	private PreparedStatement reqSelectPieceByIdSt = null; 
	
	// Porte
	private static final String reqSelectPorteByIdPiece = "select idporte, situationporte, idpiece from PORTE where idpiece=?";
	
	private PreparedStatement reqSelectPorteByIdPieceSt = null;
	
	// Utilisateur
	private static final String reqSelectUtilisateurByNom = "select idutilisateur, nomutilisateur, mdputilisateur from UTILISATEUR where nomutilisateur=?";
	private static final String reqInsertUtilisateur = "insert into UTILISATEUR (nomutilisateur, mdputilisateur) values (?, ?)";
	
	private PreparedStatement reqSelectUtilisateurByNomSt = null;
	private PreparedStatement reqInsertUtilisateurSt = null;
	
	// Personnage
	private static final String reqSelectPersonnageByUtilisateur = "select idpersonnage, nompersonnage, idutilisateur, pointvie, idpiece from PERSONNAGE where idutilisateur=?";
	private static final String reqSelectPersonnageByName = "select idpersonnage, nompersonnage, idutilisateur, pointvie, idpiece from PERSONNAGE where nompersonnage=?";
	private static final String reqInsertPersonnage = "insert into PERSONNAGE (nompersonnage, idutilisateur, pointvie, idpiece) values (?, ?, ?, ?) ";
	private static final String reqUpdatePersonnage = "update PERSONNAGE set nompersonnage=?, pointvie=?, idpiece=? where idpersonnage=?";
	
	private PreparedStatement reqSelectPersonnageByUtilisateurSt = null;
	private PreparedStatement reqSelectPersonnageByNameSt = null;
	private PreparedStatement reqInsertPersonnageSt = null;
	private PreparedStatement reqUpdatePersonnageSt = null;
	
	// Monstre
	private static final String reqSelectMonstreByPiece = "select IDMONSTRE, NOMMONSTRE, POINTVIE, IDPIECE from MONSTRE where IDPIECE=?";
	private static final String reqUpdateMonstre = "update MONSTRE set NOMMONSTRE=?, POINTVIE=?, IDPIECE=? where IDMONSTRE=?";
	
	private PreparedStatement reqSelectMonstreByPieceSt = null;
	private PreparedStatement reqUpdateMonstreSt = null;
	
	public LabyrintheJDBC(String nomBD) throws RemoteException {
		try {
			// récupération du driver
		    Class.forName("org.h2.Driver");
		    // création d'une connexion
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
	        // construction des prepared statement
		    // Piece
		    reqSelectPieceSt = conn.prepareStatement(reqSelectPiece);
		    reqSelectPieceByIdSt = conn.prepareStatement(reqSelectPieceById);
		    // Porte
		    reqSelectPorteByIdPieceSt = conn.prepareStatement(reqSelectPorteByIdPiece);
		    // Utilisateur
		    reqSelectUtilisateurByNomSt = conn.prepareStatement(reqSelectUtilisateurByNom);
		    reqInsertUtilisateurSt = conn.prepareStatement(reqInsertUtilisateur);
		    // Personnage
		    reqSelectPersonnageByUtilisateurSt = conn.prepareStatement(reqSelectPersonnageByUtilisateur);
		    reqSelectPersonnageByNameSt = conn.prepareStatement(reqSelectPersonnageByName);
		    reqInsertPersonnageSt = conn.prepareStatement(reqInsertPersonnage);
		    reqUpdatePersonnageSt = conn.prepareStatement(reqUpdatePersonnage);
		    // Monstre
		    reqSelectMonstreByPieceSt = conn.prepareStatement(reqSelectMonstreByPiece);
		    reqUpdateMonstreSt = conn.prepareStatement(reqUpdateMonstre);
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
				Piece piece = new Piece(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				piece.setListePortes(selectPorteByIdPiece(rs.getInt(1)));
				listPieces.add(piece);
			}
			return listPieces;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Piece selectPieceById(int idPiece) throws RemoteException {
		try {
			reqSelectPieceByIdSt.setInt(1, idPiece);
			ResultSet rs = reqSelectPieceByIdSt.executeQuery();
			rs.next();
			Piece piece = new Piece(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			piece.setListePortes(selectPorteByIdPiece(rs.getInt(1)));
			
			return piece;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<Porte> selectPorteByIdPiece(int idpiece) throws RemoteException {
		try {
			reqSelectPorteByIdPieceSt.setInt(1, idpiece);
			ResultSet rs = reqSelectPorteByIdPieceSt.executeQuery();
			
			ArrayList<Porte> listPortes = new ArrayList<Porte>();
			while (rs.next()) {
				Porte porte = new Porte(rs.getInt(1), rs.getString(2));
				porte.setIdPiece(rs.getInt(3));
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
			
			Utilisateur utilisateur = null;
			while (rs.next()) {
				utilisateur = new Utilisateur((int)rs.getLong(1), rs.getString(2), rs.getString(3));
				ArrayList<Personnage> listePerso = selectPersonnageByUtilisateur((int)rs.getLong(1));
				HashMap<Integer, Personnage> listePersoMap = new HashMap<Integer, Personnage>();
				for (Personnage perso : listePerso) {
					listePersoMap.put(perso.getIdIndiv(), perso);
				}
				utilisateur.setListePerso(listePersoMap);
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
			if (e.getErrorCode() != 23001) { // Contrainte unique nom d'utilisateur
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public ArrayList<Personnage> selectPersonnageByUtilisateur (int idUtilisateur) throws RemoteException {
		try {
			reqSelectPersonnageByUtilisateurSt.setInt(1, idUtilisateur);
			ResultSet rs = reqSelectPersonnageByUtilisateurSt.executeQuery();
			
			ArrayList<Personnage> listPersonnages = new ArrayList<Personnage>();
			while (rs.next()) {
				Personnage personnage = new Personnage(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5), rs.getInt(3));
				listPersonnages.add(personnage);
			}
			return listPersonnages;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Personnage selectPersonnageByName(String nomPerso)
			throws RemoteException {
		try {
			reqSelectPersonnageByNameSt.setString(1, nomPerso);
			ResultSet rs = reqSelectPersonnageByNameSt.executeQuery();
			
			Personnage personnage = new Personnage(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5), rs.getInt(3));
			
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
			if (e.getErrorCode() != 23001) { // Contrainte unique du nom de personnage
				e.printStackTrace();
			}
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
	
	@Override
	public Monstre selectMonstreByPiece(int idPiece) throws RemoteException {
		try {
			reqSelectMonstreByPieceSt.setInt(1, idPiece);
			ResultSet rs = reqSelectMonstreByPieceSt.executeQuery();
			
			while (rs.next()) {
				Monstre monstre = new Monstre(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				return monstre;
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece)
			throws RemoteException {
		try {
			reqUpdateMonstreSt.setString(1, nom);
			reqUpdateMonstreSt.setInt(2, pointvie);
			reqUpdateMonstreSt.setInt(3, idpiece);
			reqUpdateMonstreSt.setInt(4, id);
        	if (reqUpdateMonstreSt.executeUpdate()==1)
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
			//Fermeture des PreparedStatements
			// Piece
			reqSelectPieceSt = null;
			reqSelectPieceByIdSt = null; 
			
			// Porte
			reqSelectPorteByIdPieceSt = null;
			
			// Utilisateur
			reqSelectUtilisateurByNomSt = null;
			reqInsertUtilisateurSt = null;
			
			// Personnage
			reqSelectPersonnageByUtilisateurSt = null;
			reqInsertPersonnageSt = null;
			reqUpdatePersonnageSt = null;
			
			// Monstre
			reqSelectMonstreByPieceSt = null;
			reqUpdateMonstreSt = null;
			
			//Fermeture de la BD
			Naming.unbind("MaBD");
			UnicastRemoteObject.unexportObject(this, true);
			conn.close();
		} catch(Exception ex) {
			// il y a eu une erreur
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		LabyrintheJDBC labyrintheJDBC = new LabyrintheJDBC("Labyrinthe");
		Naming.rebind("MaBD", new LabyrintheJDBC("Labyrinthe"));
		System.out.println("Connexion BD réussie");
/*		ArrayList<Piece> listePiece =  labyrintheJDBC.selectPiece();
		for (Piece piece : listePiece) {
			System.out.println();
			System.out.print(piece.getIdPiece() + " - " 
					+ piece.getNomServer() + " - " 
					+ piece.getPosX() + " - " 
					+ piece.getPosY() + " - ");
			ArrayList<Porte> listePorte = piece.getListePortes();
			for (Porte porte : listePorte) {
				System.out.print(porte.positionPorte + " - ");
			}
		}		*/
		
/*		Utilisateur utilisateur = labyrintheJDBC.selectUtilisateurByNom("YouYou");
		System.out.println(utilisateur.getIdUser() + " - " 
				+ utilisateur.getNomUser() + " - "
				+ utilisateur.getMdpUser());
		HashMap<Integer, Personnage> listPerso = utilisateur.getListePerso();
		for (int idPerso : listPerso.keySet()) {
			Personnage personnage = listPerso.get(idPerso);
			System.out.println(personnage.getIdPiece() + " - "
					+ personnage.getNbPVIndiv() + " - "
					+ personnage.getNomIndiv());
		}		*/
/*		Monstre monstre = labyrintheJDBC.selectMonstreByPiece(25);
		System.out.println(monstre.getIdIndiv() + " - " + monstre.getIdPiece() + " - " + monstre.getNomIndiv() + " - " + monstre.getNbPVIndiv());
*/		
	}
}
