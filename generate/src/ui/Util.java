package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Méthodes réutilisables dans les interfaces
 * 
 * @author Manon, Aurore, Youssef
 */
public class Util {

	/**
	 * Affiche une pop-up avec un fond blanc et le texte en noir
	 * 
	 * @param mess : message à afficher dans la pop-up
	 */
	public static void afficherPopUp(String mess) {
		try {
			// Affecter una apparence à la pop-up
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// Fond blanc de la pop-up
			UIManager.put("OptionPane.background", Color.WHITE);
			// Fond du texte en blanc
            UIManager.put("Panel.background", Color.WHITE);
            // Texte en noir
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            // Taille de la pop-up
            UIManager.put("OptionPane.minimumSize",new Dimension(400,150));
            // Affichage de la pop-up
    		JOptionPane.showMessageDialog(null, mess);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
