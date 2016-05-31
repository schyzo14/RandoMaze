import model.LabyrintheImpl;
import persistence.LabyrintheJDBC;
import ui.Connexion;

/**
 * Jouer une partie
 * 
 * @author Manon, Aurore, Youssef
 */
public class Partie {

	/**
	 * Lancer le jeux
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Connexion à la BD
		LabyrintheJDBC.demarrer();
		
		// Démarrer les 2 serveurs
		LabyrintheImpl.demarrer();

		// Lancer 2 fenetres de Connexion
		Connexion connexion = new Connexion();
		Connexion connexion2 = new Connexion();
		connexion.demarrer();
		connexion2.demarrer();
	}
}
