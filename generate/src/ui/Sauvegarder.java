package ui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Labyrinthe;
import model.Personnage;
import model.Piece;

/**
 * Classe Sauvegarder
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Sauvegarder extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1308807404409725435L;

	/**
	 * Variables
	 */
	private Personnage currentPerso;
	private Labyrinthe laby;

	/**
	 * Constructeur de la classe Sauvegarder
	 * 
	 * @param Personnage
	 *            choixPerso
	 */
	public Sauvegarder(Personnage choixPerso) {
		currentPerso = choixPerso;

		// Initialisation de la fenêtre
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Dimensionnement Fenetre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
		int width = (int) (524 - insets.left - insets.right);
		int height = (int) (368 - insets.top - insets.bottom);
		setSize(width, height);
	}

	/**
	 * Initialisation de la fenêtre (NetBeans)
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		l_question = new javax.swing.JLabel();
		b_oui = new javax.swing.JButton();
		b_non = new javax.swing.JButton();

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
		setTitle("RandoMaze - Sauvegarder");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		l_question.setFont(new java.awt.Font("Arial", 0, 14));
		l_question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		l_question.setText("Voulez-vous sauvegarder et quitter le jeu ?");

		b_oui.setFont(new java.awt.Font("Arial", 0, 14));
		b_oui.setText("Oui");
		b_oui.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				b_ouiMouseClicked(evt);
			}
		});

		b_non.setFont(new java.awt.Font("Arial", 0, 14));
		b_non.setText("Non");
		b_non.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				b_nonMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(43, 43, 43)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(b_oui, javax.swing.GroupLayout.DEFAULT_SIZE,
														166, Short.MAX_VALUE)
												.addGap(101, 101, 101).addComponent(b_non,
														javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
										.addComponent(l_question, javax.swing.GroupLayout.DEFAULT_SIZE, 433,
												Short.MAX_VALUE))
								.addGap(48, 48, 48)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(66, 66, 66)
						.addComponent(l_question, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addGap(57, 57, 57)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(b_oui, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(b_non, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addGap(117, 117, 117)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	/**
	 * Initialisation de la connexion au serveur
	 */
	public void connexionServeur() {
		try {
			laby = (Labyrinthe) Naming.lookup("MonServeur1");
			// On récupère la pièce où se trouve le Personnage
			Piece piece = laby.getPieceById(currentPerso.getIdPiece());

			// On teste sur quel serveur se trouve la pièce
			if (piece.getNomServer().equals("beta")) {
				laby = (Labyrinthe) Naming.lookup("MonServeur2");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * Traitement du clic sur le bouton Oui
	 * 
	 * @param evt
	 */
	private void b_ouiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_b_ouiMouseClicked
		System.out.println("Sauvegarde dans la BDD");
		try {
			connexionServeur();
			// Envoi de la requête au serveur pour exécution dans la BDD
			boolean result = laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
					currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

			// Si on n'a pas pu sauvegarder, message d'erreur
			// Sinon, on quitte l'application
			if (result == false) {
				System.out.println("Problème de sauvegarde dans la BDD!");

				try {
					// On demande à l'utilisateur s'il veut quand même quitter
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UIManager.put("OptionPane.background", Color.WHITE);
					UIManager.put("Panel.background", Color.WHITE);
					UIManager.put("OptionPane.messageForeground", Color.BLACK);
					int option = JOptionPane.showConfirmDialog(null,
							"Erreur de sauvegarde. Voulez-vous quand même quitter ?", "Erreur de sauvegarde",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						quitterFenetre();
					} else {
						this.setVisible(false);
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Sauvegarde réussie!");
				quitterFenetre();
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}// GEN-LAST:event_b_ouiMouseClicked

	/**
	 * Traitement du clic sur le bouton Non
	 * 
	 * @param evt
	 */
	private void b_nonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_b_nonMouseClicked
		// On ferme le serveur et la BDD
		try {
			quitterFenetre();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Traitement du clic sur la croix rouge (Fermeture de l'application
	 * 
	 * @param evt
	 */
	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		try {
			quitterFenetre();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fermeture de l'application
	 * 
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public void quitterFenetre() throws RemoteException, MalformedURLException, NotBoundException {
		this.dispose();

		// On teste s'il y a d'autres fenêtres ouvertes
		Window[] frames = JFrame.getWindows();
		boolean ouvert = false;
		for (int i = 0; i < frames.length; i++) {
			if (frames[i].isVisible() && !this.getName().equals(frames[i].getName())) {
				ouvert = true;
			}
		}

		// S'il n'y a aucune autre fenêtre ouverte, on peut fermer l'application
		if (!ouvert) {
			Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
			laby.quitter();
		}
	}

	// Variables declaration
	private javax.swing.JButton b_non;
	private javax.swing.JButton b_oui;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel l_question;
	// End of variables declaration
}
