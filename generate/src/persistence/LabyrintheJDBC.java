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
 */
public class LabyrintheJDBC extends UnicastRemoteObject implements Labyrinthe {

	private static final long serialVersionUID = 6415704478523465430L;

	// Connection
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

	/**
	 * Prépare les requetes
	 * 
	 * @param nomBD : nom de la BD
	 * @throws RemoteException e
	 */
	public LabyrintheJDBC(String nomBD) throws RemoteException {
		try {
			// récupération du driver
			Class.forName("org.h2.Driver");
			// création d'une connexion
			conn = DriverManager.getConnection("jdbc:h2:" + nomBD + ";IGNORECASE=TRUE", "sa", "");

			// Construction des prepared statement
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

		} catch (Exception e) {
			// il y a eu une erreur
			e.printStackTrace();
		}
	}

	// Piece
	/**
	 * Liste de toutes les pieces
	 * 
	 * @return liste des pieces
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public ArrayList<Piece> selectPiece() throws RemoteException {
		try {
			// Exécution de la requete
			ResultSet rs = reqSelectPieceSt.executeQuery();
			// Liste des pieces
			ArrayList<Piece> listPieces = new ArrayList<Piece>();
			// On ajoute toutes les pieces du resultat de la requete à la liste
			while (rs.next()) {
				Piece piece = new Piece(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				// On récupère les portes de la piece courante
				piece.setListePortes(selectPorteByIdPiece(rs.getInt(1)));
				listPieces.add(piece);
			}
			return listPieces;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retourne une piece grace à son id
	 * 
	 * @param id de la Piece
	 * @return piece
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public Piece selectPieceById(int idPiece) throws RemoteException {
		try {
			// On complete la requete par idPiece
			reqSelectPieceByIdSt.setInt(1, idPiece);
			// Exécution de la requete
			ResultSet rs = reqSelectPieceByIdSt.executeQuery();
			// On récupère la piece du retour de la requete
			rs.next();
			Piece piece = new Piece(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			// On récupère les portes de la piece
			piece.setListePortes(selectPorteByIdPiece(rs.getInt(1)));

			return piece;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Porte
	/**
	 * Retourne la liste des portes d'une piece
	 * 
	 * @param id de la piece
	 * @return liste des portes
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public ArrayList<Porte> selectPorteByIdPiece(int idpiece) throws RemoteException {
		try {
			// On complete la requete par idPiece
			reqSelectPorteByIdPieceSt.setInt(1, idpiece);
			// Exécution de la requete
			ResultSet rs = reqSelectPorteByIdPieceSt.executeQuery();
			// On ajoute toutes les portes du resultat de la requete à la liste
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

	// Utilisateur
	/**
	 * Retourne un utilisateur grave à son nom
	 * 
	 * @param nom de l'utilisateur
	 * @return Utilisateur
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public Utilisateur selectUtilisateurByNom(String nom) throws RemoteException {
		try {
			// On complete la requete par le nom de l'utilisateur
			reqSelectUtilisateurByNomSt.setString(1, nom);
			// Exécution de la requete
			ResultSet rs = reqSelectUtilisateurByNomSt.executeQuery();
			// On récupère l'utilisateur retourné par la requete
			Utilisateur utilisateur = null;
			while (rs.next()) {
				utilisateur = new Utilisateur((int) rs.getLong(1), rs.getString(2), rs.getString(3));
				// On récupère les personnages de l'utilisateur
				ArrayList<Personnage> listePerso = selectPersonnageByUtilisateur((int) rs.getLong(1));
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

	/**
	 * Créer un utilisateur avec son nom et mdp
	 * 
	 * @param nom de l'utilisateur
	 * @param mdp de l'utilisateur
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public boolean creerUtilisateur(String nom, String mdp) throws RemoteException {
		try {
			// On complete la requete par le nom de l'utilisateur et son mdp
			reqInsertUtilisateurSt.setString(1, nom);
			reqInsertUtilisateurSt.setString(2, mdp);
			// Création de l'utilisateur
			if (reqInsertUtilisateurSt.executeUpdate() == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// Si ce n'est pas une Contrainte unique sur le nom d'utilisateur
			// (nom déjà existant)
			if (e.getErrorCode() != 23001) {
				e.printStackTrace();
			}
			return false;
		}
	}

	// Personnage
	/**
	 * Retourne les personnages d'un utilisateur
	 * 
	 * @param id de l'Utilisateur
	 * @return liste de personnages
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public ArrayList<Personnage> selectPersonnageByUtilisateur(int idUtilisateur) throws RemoteException {
		try {
			// On complete la requete par l'id de l'utilisateur
			reqSelectPersonnageByUtilisateurSt.setInt(1, idUtilisateur);
			// Exécution de la requete
			ResultSet rs = reqSelectPersonnageByUtilisateurSt.executeQuery();
			// On récupère la liste des personnages
			ArrayList<Personnage> listPersonnages = new ArrayList<Personnage>();
			while (rs.next()) {
				Personnage personnage = new Personnage(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5),
						rs.getInt(3));
				listPersonnages.add(personnage);
			}
			return listPersonnages;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retourne un personnage grace à son nom
	 * 
	 * @param nom du Personnage
	 * @return personnage
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public Personnage selectPersonnageByName(String nomPerso) throws RemoteException {
		try {
			// On complete la requete par le nom du personnage
			reqSelectPersonnageByNameSt.setString(1, nomPerso);
			// Exécution de la requete
			ResultSet rs = reqSelectPersonnageByNameSt.executeQuery();
			// On récupère le personnage
			rs.next();
			Personnage personnage = new Personnage(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5),
					rs.getInt(3));

			return personnage;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Créer un personnage avec son nom et utilisateur
	 * 
	 * @param nom du personnage
	 * @param id de l'Utilisateur du personnage
	 * @return false : le nom existe déjà / true : création réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public boolean creerPersonnage(String nom, int idUtilisateur) throws RemoteException {
		try {
			// On complete la requete par le nom du personnage, l'id de son
			// utilisateur, le nombre de PV=10, la salle=1
			reqInsertPersonnageSt.setString(1, nom);
			reqInsertPersonnageSt.setInt(2, idUtilisateur);
			reqInsertPersonnageSt.setInt(3, 10);
			reqInsertPersonnageSt.setInt(4, 1);
			// Exécution de la requete
			if (reqInsertPersonnageSt.executeUpdate() == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// Si ce n'est pas une Contrainte unique sur le nom d'utilisateur
			// (nom déjà existant)
			if (e.getErrorCode() != 23001) { // Contrainte unique du nom de
												// personnage
				e.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * Mettre à jour un personnage
	 * 
	 * @param id du personnage
	 * @param nom du personnage
	 * @param PV du personnage
	 * @param id de la piece du personnage
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public boolean updatePersonnage(int id, String nom, int pointvie, int idpiece) throws RemoteException {
		try {
			// On complete la requete par le nom du personnage, le nombre de PV,
			// la salle et l'id du personnage
			reqUpdatePersonnageSt.setString(1, nom);
			reqUpdatePersonnageSt.setInt(2, pointvie);
			reqUpdatePersonnageSt.setInt(3, idpiece);
			reqUpdatePersonnageSt.setInt(4, id);
			// Exécution de la requete
			if (reqUpdatePersonnageSt.executeUpdate() == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Monstre
	/**
	 * Retourne le monstre d'une piece
	 * 
	 * @param id de la Piece
	 * @return monstre
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public Monstre selectMonstreByPiece(int idPiece) throws RemoteException {
		try {
			// On complete la requete par l'id de la piece
			reqSelectMonstreByPieceSt.setInt(1, idPiece);
			// Exécution de la requete
			ResultSet rs = reqSelectMonstreByPieceSt.executeQuery();
			// On récupère le monstre
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

	/**
	 * Mettre à jour un monstre
	 * 
	 * @param id du monstre
	 * @param nom du monstre
	 * @param pointvie du mosntre
	 * @param idpiece : piece du monstre
	 * @return false : erreur / true : MAJ réussie
	 * @throws java.rmi.RemoteException : remoteException
	 */
	@Override
	public boolean updateMonstre(int id, String nom, int pointvie, int idpiece) throws RemoteException {
		try {
			// On complete la requete par le nom du monstre, le nombre de PV, la
			// salle et l'id du monstre
			reqUpdateMonstreSt.setString(1, nom);
			reqUpdateMonstreSt.setInt(2, pointvie);
			reqUpdateMonstreSt.setInt(3, idpiece);
			reqUpdateMonstreSt.setInt(4, id);
			// Exécution de la requete
			if (reqUpdateMonstreSt.executeUpdate() == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Fermeture
	/**
	 * Fermer l'accès à la bd
	 * 
	 * @throws Exception e
	 */
	public void fermer() throws Exception {
		try {
			// Fermeture des PreparedStatements
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

			// Fermeture de la BD
			Naming.unbind("MaBD");
			UnicastRemoteObject.unexportObject(this, true);
			conn.close();

		} catch (Exception ex) {
			// il y a eu une erreur
			ex.printStackTrace();
		}
	}

	/**
	 * Connexion à la BD
	 * 
	 * @throws Exception e
	 */
	public static void demarrer() throws Exception {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("MaBD", new LabyrintheJDBC("Labyrinthe"));
		System.out.println("Connexion BD réussie");
	}
}
