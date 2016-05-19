import model.LabyrintheImpl;
import persistence.LabyrintheJDBC;
import ui.Connexion;

public class Game {

	public static void main(String[] args) throws Exception {
		LabyrintheJDBC.main(args);
		LabyrintheImpl.main(args);
		
		Connexion connexion = new Connexion();
		Connexion connexion2 = new Connexion();
		connexion.demarrer();
		connexion2.demarrer();
	}
}
