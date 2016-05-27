import model.LabyrintheImpl;
import persistence.LabyrintheJDBC;
import ui.Connexion;

/**
 * Jouer une partie
 * 
 * @author Manon, Aurore, Youssef
 */
public class Partie {

	public static void main(String[] args) throws Exception {
		LabyrintheJDBC.main(args);
		LabyrintheImpl.main(args);
		
		Connexion connexion = new Connexion();
		Connexion connexion2 = new Connexion();
		Connexion connexion3 = new Connexion();
		connexion.demarrer();
		connexion2.demarrer();
		connexion3.demarrer();
	}
}
