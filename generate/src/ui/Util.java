package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Util {

	public static void afficherPopUp(String mess) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
            UIManager.put("OptionPane.minimumSize",new Dimension(400,150)); 
    		JOptionPane.showMessageDialog(null, mess);
    		
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
