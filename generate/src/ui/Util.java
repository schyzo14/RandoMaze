package ui;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Util {

	public static void afficherPopUp(String mess) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            UIManager.put("OptionPane.messageForeground", Color.BLACK);
    		JOptionPane.showMessageDialog(null, mess);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
