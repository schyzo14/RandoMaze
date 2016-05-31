package ui;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.Individu;
import model.Labyrinthe;
import model.LabyrintheImpl;
import model.Personnage;
import model.Piece;

/**
 * Classe Combat
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Combat extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312961979928777092L;
	/**
	 * Variables
	 */
	// Liste de combattants
	private Personnage currentPerso;
	private Individu enemy;
	private int pvMonstreMax = 10;
	private Labyrinthe laby;
	private int numPiece;
	// Thread de combat
	public static Thread t;

	/**
	 * Combat contre un monstre
	 * 
	 * @param personnage
	 */
	public Combat(model.Personnage personnage) {
		// Affectation du personnage
		currentPerso = personnage;

		// Test de la piece pour savoir quel type de monstre il va combattre :
		// normal, boss ou boss secret
		numPiece = currentPerso.getIdPiece();
		if (numPiece == 15)
			pvMonstreMax = 15;
		else if (numPiece == 16)
			pvMonstreMax = 20;
		else
			pvMonstreMax = 5;

		// Initialisation Fenetre
		initialisationFenetre();

		// Initialisation du serveur
		connexionServeur();

		System.out.println("Combat contre un monstre");
		try {
			// On récupère le monstre de la pièce
			enemy = laby.getMonstreByPiece(numPiece);
			enemyName.setText("Nom : " + enemy.getNomIndiv());
			lifePointsEnemy.setText("PV : " + enemy.getNbPVIndiv() + " / " + enemyPV.getMaximum());
			enemyPV.setValue(enemy.getNbPVIndiv());
			imageEnemy.setIcon(
					new javax.swing.ImageIcon(getClass().getResource("/images/" + enemy.getNomIndiv() + ".png"))); // NOI18N
			player.setText("Nom : " + currentPerso.getNomIndiv());
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}

		// Tant que le joueur ne clique pas sur Fuir ou PV=0, le combat continue
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				// Création du Thread de combat
				Combat.t = new Thread() {
					public void run() {
						enemyPV.setValue(enemy.getNbPVIndiv());
						playerPV.setValue(currentPerso.getNbPVIndiv());

						// Boucle qui vérifie les PV du monstre et du joueur
						// et qui vérifie si le Thread a été interrompu ou non
						while (enemy.getNbPVIndiv() != 0 && currentPerso.getNbPVIndiv() != 0 && !this.isInterrupted()) {
							// Toutes les secondes, un des deux perd 1 point
							if (Individu.retirerPV() == false) {
								enemy.setNbPVIndiv(enemy.getNbPVIndiv() - 1);
								enemyPV.setValue(enemy.getNbPVIndiv());
								lifePointsEnemy
										.setText("PV : " + enemy.getNbPVIndiv() + " / " + enemyPV.getMaximum());
							} else {
								currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() - 1);
								playerPV.setValue(currentPerso.getNbPVIndiv());
								lifePointsPlayer
										.setText("PV : " + currentPerso.getNbPVIndiv() + " / " + playerPV.getMaximum());
							}
						}

						// Traitement du combat d'un joueur contre un monstre
						combatPvM();
					}
				};
				t.start();
			}
		});
	}

	/**
	 * Combat entre joueurs
	 * 
	 * @param monPersonnage
	 * @param personnageCombattre
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public Combat(model.Personnage monPersonnage, String personnageCombattre)
			throws MalformedURLException, RemoteException, NotBoundException {
		// Affectation du personnage
		currentPerso = monPersonnage;

		// Initialisation Fenetre
		initialisationFenetre();

		// Initialisation du serveur
		connexionServeur();

		// Récupération des valeurs concernant le personnage à combattre
		enemy = laby.getPersonnageByName(personnageCombattre);
		LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(false);
		LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(false);
		enemyName.setText("Nom : " + enemy.getNomIndiv());
		lifePointsEnemy.setText("PV : " + enemy.getNbPVIndiv() + " / 10");
		enemyPV.setValue(enemy.getNbPVIndiv());
		player.setText("Nom : " + currentPerso.getNomIndiv());
		imageEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png")));
		imagePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png")));

		System.out.println("Combat entre joueur");
		// Tant que le joueur ne clique pas sur Fuir ou PV=0, le combat continue
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				// Création du Thread de combat
				Combat.t = new Thread() {
					public void run() {
						enemyPV.setValue(enemy.getNbPVIndiv());
						playerPV.setValue(enemy.getNbPVIndiv());

						// Boucle qui vérifie les PV du joueur à combattre et du
						// joueur
						// et qui vérifie si le Thread a été interrompu ou non
						while (enemy.getNbPVIndiv() != 0 && currentPerso.getNbPVIndiv() != 0 && !this.isInterrupted()) {
							// Toute les secondes, un des deux perd 1 point
							if (Individu.retirerPV() == false) {
								enemy.setNbPVIndiv(enemy.getNbPVIndiv() - 1);
								enemyPV.setValue(enemy.getNbPVIndiv());
								lifePointsEnemy
										.setText("PV : " + enemy.getNbPVIndiv() + " / " + enemyPV.getMaximum());
							} else {
								currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() - 1);
								playerPV.setValue(currentPerso.getNbPVIndiv());
								lifePointsPlayer
										.setText("PV : " + currentPerso.getNbPVIndiv() + " / " + playerPV.getMaximum());

							}
						}

						// Traitement du combat d'un joueur contre un joueur
						combatPvP();
					}
				};
				t.start();
			}
		});
	}

	/**
	 * Traitement d'un combat d'un joueur contre un Monstre
	 */
	public synchronized void combatPvM() {
		// Test si perso ou monstre meurt
		// Mort du perso
		if (currentPerso.getNbPVIndiv() == 0) {
			System.out.println("Mort du joueur");
			// Le monstre gagne 1 PV
			try {
				enemy.setNbPVIndiv(enemy.getNbPVIndiv() + 1);
				laby.updateMonstre(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(), enemy.getIdPiece());

				// Le joueur retourne à la case départ (listePersonnage)
				// remise des PV à 10 et de la pièce à 1 (pièce de départ)
				currentPerso.setNbPVIndiv(10);
				currentPerso.setIdPiece(1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				// Message Game Over
				Util.afficherPopUp("Game Over");

				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(false);
				fermer();
				// On ouvre la fenêtre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(currentPerso.getIdUtilisateur());
				fenPersonnage.setVisible(true);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				e.printStackTrace();
			}

		} else if (enemy.getNbPVIndiv() == 0) { // Mort du monstre
			System.out.println("Mort du monstre");

			// Le joueur gagne 1 PV
			try {
				// On ajoute 1PV au joueur
				if (currentPerso.getNbPVIndiv() < 10)
					currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() + 1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				System.out.println("Nombre de PV du joueur après combat : " + currentPerso.getNbPVIndiv());

				// Le monstre meurt
				enemy.setNbPVIndiv(5);
				laby.updateMonstre(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(), enemy.getIdPiece());

				// Message de victoire si la pièce est 15
				if (currentPerso.getIdPiece() == 15) {
					Util.afficherPopUp("Félicitations, vous avez vaincu. \n \"Je suis venu, j'ai vu, j'ai vaincu.\"");
				}
				// Fermeture de la fenetre de combat
				fermer();
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * Traitement d'un combat d'un joueur contre un autre joueur
	 */

	public void combatPvP() {
		// Test si perso ou perso combattu meurt
		if (currentPerso.getNbPVIndiv() == 0) {
			System.out.println("Mort de notre joueur");
			// Le joueur combattu gagne 1 PV
			try {
				if (enemy.getNbPVIndiv() < 10)
					enemy.setNbPVIndiv(enemy.getNbPVIndiv() + 1);
				laby.updatePersonnage(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(),
						enemy.getIdPiece());

				// Le joueur retourne à la case départ (listePersonnage)
				// remise des PV à 10 et de la pièce à 1 (pièce de départ)
				currentPerso.setNbPVIndiv(10);
				currentPerso.setIdPiece(1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(true);
				Util.afficherPopUp("Game Over");
				fermer();

				// On ouvre la fenêtre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(currentPerso.getIdUtilisateur());
				fenPersonnage.setVisible(true);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				e.printStackTrace();
			}

		} else if (enemy.getNbPVIndiv() == 0) {
			System.out.println("Mort du joueur combattu");

			// Notre joueur gagne 1 PV
			try {
				// On ajoute 1PV à notre joueur
				if (currentPerso.getNbPVIndiv() < 10)
					currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() + 1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				System.out.println("Nombre de PV de notre joueur après combat : " + currentPerso.getNbPVIndiv());

				// Le joueur combattu meurt
				enemy.setNbPVIndiv(10);
				enemy.setIdPiece(1);
				laby.updatePersonnage(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(),
						enemy.getIdPiece());

				// Fermeture de la fenetre de combat
				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);
				Util.afficherPopUp("Game Over");
				fermer();

				// On ouvre la fenêtre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(((Personnage) enemy).getIdUtilisateur());
				fenPersonnage.setVisible(true);

			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * Initialisation de la fenêtre (NetBeans)
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		enemyName = new javax.swing.JLabel();
		playerPV = new javax.swing.JProgressBar(0, 10);
		enemyPV = new javax.swing.JProgressBar(0, pvMonstreMax);
		imagePlayer = new javax.swing.JLabel();
		player = new javax.swing.JLabel();
		lifePointsPlayer = new javax.swing.JLabel();
		imageEnemy = new javax.swing.JLabel();
		lifePointsEnemy = new javax.swing.JLabel();
		buttonRun = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("RandoMaze - Combat");
		setMaximumSize(new java.awt.Dimension(824, 528));
		setMinimumSize(new java.awt.Dimension(824, 528));
		setPreferredSize(new java.awt.Dimension(824, 528));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		enemyName.setFont(new java.awt.Font("Arial", 0, 14));
		enemyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		enemyName.setText("Monstre ");

		playerPV.setFont(new java.awt.Font("Arial", 0, 12));

		enemyPV.setFont(new java.awt.Font("Arial", 0, 12));

		imagePlayer.setFont(new java.awt.Font("Arial", 0, 12));
		imagePlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		imagePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png")));

		player.setFont(new java.awt.Font("Arial", 0, 14));
		player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		player.setText("Personnage ");

		lifePointsPlayer.setFont(new java.awt.Font("Arial", 0, 14));
		lifePointsPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lifePointsPlayer.setText("PV : " + playerPV.getMaximum() + " / " + playerPV.getMaximum());

		imageEnemy.setFont(new java.awt.Font("Arial", 0, 12));
		imageEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		lifePointsEnemy.setFont(new java.awt.Font("Arial", 0, 14));
		lifePointsEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		// lifePointsEnemy.setText("PV : " + monsterPV.getMaximum() + " / " +
		// monsterPV.getMaximum());

		buttonRun.setFont(new java.awt.Font("Arial", 0, 14));
		buttonRun.setText("Fuir");
		buttonRun.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRunActionPerformed(evt);
			}
		});

		// Croix fermer
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				Util.afficherPopUp("Combattez ou fuyez ! Vous ne pouvez pas quitter...");

			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(46, 46, 46)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(playerPV, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
								.addComponent(player, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lifePointsPlayer, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(imagePlayer, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(97, 97, 97)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(enemyPV, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
								.addComponent(enemyName, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lifePointsEnemy, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(imageEnemy, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(65, 65, 65))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(301, 301, 301).addComponent(buttonRun,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(319, 319, 319)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(32, 32, 32).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(enemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(imageEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(enemyPV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lifePointsEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(5, 5, 5))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(imagePlayer, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(12, 12, 12)
								.addComponent(playerPV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(lifePointsPlayer,
										javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(37, 37, 37).addComponent(buttonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(38, 38, 38)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * Initialisation de la fenêtre
	 */
	public void initialisationFenetre() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Dimensionnement Fenetre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
		int width = (int) (824 - insets.left - insets.right);
		int height = (int) (568 - insets.top - insets.bottom);
		setSize(width, height);
	}

	/**
	 * Initialisation de la connexion au serveur
	 */
	public void connexionServeur() {
		try {
			laby = (Labyrinthe) Naming.lookup("MonServeur1");
			// On récupère la pièce où se trouve le joueur
			Piece piece = laby.getPieceById(currentPerso.getIdPiece());

			// on teste sur quel serveur se trouve la pièce
			if (piece.getNomServer().equals("beta")) {
				laby = (Labyrinthe) Naming.lookup("MonServeur2");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Fermeture de la fenêtre
	 */
	public synchronized void fermer() {
		this.setVisible(false);
	}

	/**
	 * Traitement du clic sur le bouton Fuir
	 * 
	 * @param evt
	 */
	private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("Le monstre ou le joueur quitte le combat");
		try {
			// Le monstre ou le joueur combattu gagne 1 PV
			// Si récupère le serveur;
			if (enemy instanceof Personnage) {
				laby.updatePersonnage(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(),
						enemy.getIdPiece());

				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);
				LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(true);
			} else {
				laby.updateMonstre(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(), enemy.getIdPiece());

				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);

			}

		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} finally {
			t.interrupt();
		}

		// Fermeture de la fenêtre
		this.setVisible(false);
	}

	// Variables declaration
	private javax.swing.JButton buttonRun;
	private javax.swing.JLabel imageEnemy;
	private javax.swing.JLabel imagePlayer;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lifePointsEnemy;
	private javax.swing.JLabel lifePointsPlayer;
	private javax.swing.JLabel enemyName;
	private javax.swing.JProgressBar enemyPV;
	private javax.swing.JLabel player;
	private javax.swing.JProgressBar playerPV;
	// End of variables declaration
}
