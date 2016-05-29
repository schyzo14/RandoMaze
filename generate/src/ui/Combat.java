/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Individu;
import model.Labyrinthe;
import model.LabyrintheImpl;
import model.Personnage;
import model.Piece;

/**
 * 
 * @author Manon, Aurore, Youssef
 *
 */
public class Combat extends javax.swing.JFrame {
	//Liste de combattants
	private Personnage currentPerso;
	private Individu enemy;
	private int pvMonstreMax = 10;
	private Labyrinthe laby;
	private int numPiece;
	// Thread de combat
	public static Thread t;

	/**
	 * Creates new form Combat
	 */
	// init fen�tre
	public void initialisationFenetre() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Dimensionnement Fenetre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
		int width = (int) (824 - insets.left - insets.right);
		int height = (int) (568 - insets.top - insets.bottom);
		setSize(width, height);
	}

	// Initialisation de la connexion au serveur
	public void connexionServeur() {
		try {
			laby = (Labyrinthe) Naming.lookup("MonServeur1");
			Piece piece = laby.getPieceById(currentPerso.getIdPiece());

			if (piece.getNomServer().equals("alpha")) {
				laby = (Labyrinthe) Naming.lookup("MonServeur1");
			} else if (piece.getNomServer().equals("beta")) {
				laby = (Labyrinthe) Naming.lookup("MonServeur2");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// Combat contre un monstre
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

		// Initialisation du labyrinthe
		connexionServeur();

		System.out.println("Combat contre un monstre");
		// Appel m�thode g�n�ration combat
		try {
			enemy = laby.getMonstreByPiece(numPiece);
			monster.setText("Nom : " + enemy.getNomIndiv());
			imageEnemy.setIcon(
					new javax.swing.ImageIcon(getClass().getResource("/images/" + enemy.getNomIndiv() + ".png"))); // NOI18N
			player.setText("Nom : " + currentPerso.getNomIndiv());
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Tant que le joueur ne clique pas sur Fuir ou PV=0, le combat continue
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				// Cr�ation du Thread de combat
				Combat.t = new Thread() {
					public void run() {
						enemy.setNbPVIndiv(pvMonstreMax);
						monsterPV.setValue(enemy.getNbPVIndiv());
						playerPV.setValue(currentPerso.getNbPVIndiv());

						// Boucle qui v�rifie les PV du monstre et du joueur
						// et qui v�rifie si le Thread a �t� interrompu ou non
						while (enemy.getNbPVIndiv() != 0 && currentPerso.getNbPVIndiv() != 0 && !this.isInterrupted()) {
							// Toutes les secondes, un des deux perd 1 point
							if (Individu.retirerPV() == false) {
								enemy.setNbPVIndiv(enemy.getNbPVIndiv() - 1);
								monsterPV.setValue(enemy.getNbPVIndiv());
								lifePointsEnemy
										.setText("PV : " + enemy.getNbPVIndiv() + " / " + monsterPV.getMaximum());
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

	// fermeture de la fen�tre
	public synchronized void fermer() {
		this.setVisible(false);
	}

	// Traitement d'un combat contre un Monstre
	public synchronized void combatPvM() {
		// Test si perso ou monstre meurt
		// Mort du perso
		if (currentPerso.getNbPVIndiv() == 0) {
			System.out.println("Mort du joueur");
			// Le monstre gagne 1 PV
			try {
				enemy.setNbPVIndiv(enemy.getNbPVIndiv() + 1);
				laby.updateMonstre(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(), enemy.getIdPiece());

				// Le joueur retourne � la case d�part (listePersonnage)
				// remise des PV � 10
				currentPerso.setNbPVIndiv(10);
				currentPerso.setIdPiece(1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				// Message Game Over
				Util.afficherPopUp("Game Over");

				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(false);
				fermer();
				// On ouvre la fen�tre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(currentPerso.getIdUtilisateur());
				fenPersonnage.setVisible(true);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (enemy.getNbPVIndiv() == 0) { // Mort du monstre
			System.out.println("Mort du monstre");

			// Le joueur gagne 1 PV
			try {
				// On ajoute 1PV au joueur
				currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() + 1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				System.out.println("Nombre de PV du joueur apr�s combat : " + currentPerso.getNbPVIndiv());

				// Le monstre meurt
				enemy.setNbPVIndiv(5);
				laby.updateMonstre(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(), enemy.getIdPiece());

				// Message de victoire si la pi�ce est 15
				if (currentPerso.getIdPiece() == 15) {
					Util.afficherPopUp("F�licitations, vous avez vaincu. \n \"Je suis venu, j'ai vu, j'ai vaincu.\"");
				}
				// Fermeture de la fenetre de combat
				fermer();
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	// Combat entre joueur
	public Combat(model.Personnage monPersonnage, String personnageCombattre)
			throws MalformedURLException, RemoteException, NotBoundException {
		// Affectation du personnage
		currentPerso = monPersonnage;

		// Initialisation Fenetre
		initialisationFenetre();

		// Initialisation du serveur
		connexionServeur();

		// Test si c'est un monstre ou un Perso
		// Si c'est un monstre
		enemy = laby.getPersonnageByName(personnageCombattre);
		LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(false);
		LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(false);
		monster.setText("Nom : " + enemy.getNomIndiv());
		player.setText("Nom : " + currentPerso.getNomIndiv());
		imageEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
		imagePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
		
		System.out.println("Combat entre joueur");
		// Tant que le joueur ne clique pas sur Fuir ou PV=0, le combat continue
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				// Cr�ation du Thread de combat
				Combat.t = new Thread() {
					public void run() {
						enemy.setNbPVIndiv(10);
						monsterPV.setValue(enemy.getNbPVIndiv());
						playerPV.setValue(enemy.getNbPVIndiv());

						// Boucle qui v�rifie les PV du joueur � combattre et du
						// joueur
						// et qui v�rifie si le Thread a �t� interrompu ou non
						while (enemy.getNbPVIndiv() != 0 && currentPerso.getNbPVIndiv() != 0 && !this.isInterrupted()) {
							// Toute les secondes, un des deux perd 1 point
							if (Individu.retirerPV() == false) {
								enemy.setNbPVIndiv(enemy.getNbPVIndiv() - 1);
								monsterPV.setValue(enemy.getNbPVIndiv());
								lifePointsEnemy
										.setText("PV : " + enemy.getNbPVIndiv() + " / " + monsterPV.getMaximum());
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

	public void combatPvP() {
		// Test si perso ou perso meurt
		if (currentPerso.getNbPVIndiv() == 0) {
			System.out.println("Mort de notre joueur");
			// Le joueur combattu gagne 1 PV
			try {
				enemy.setNbPVIndiv(enemy.getNbPVIndiv() + 1);
				laby.updatePersonnage(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(),
						enemy.getIdPiece());

				// Le joueur retourne � la case d�part (listePersonnage)
				// remise des PV � 10
				currentPerso.setNbPVIndiv(10);
				currentPerso.setIdPiece(1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(true);
				Util.afficherPopUp("Game Over");
				// LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(false);
				fermer();
				// On ouvre la fen�tre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(currentPerso.getIdUtilisateur());
				fenPersonnage.setVisible(true);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (enemy.getNbPVIndiv() == 0) {
			System.out.println("Mort du joueur combattu");

			// Notre joueur gagne 1 PV
			try {
				// On ajoute 1PV � notre joueur
				currentPerso.setNbPVIndiv(currentPerso.getNbPVIndiv() + 1);
				laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv(),
						currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());

				System.out.println("Nombre de PV de notre joueur apr�s combat : " + currentPerso.getNbPVIndiv());

				// Le joueur combattu meurt
				enemy.setNbPVIndiv(10);
				laby.updatePersonnage(enemy.getIdIndiv(), enemy.getNomIndiv(), enemy.getNbPVIndiv(),
						enemy.getIdPiece());

				// Fermeture de la fenetre de combat
				// Fermeture de la fenetre Combat et Maze
				LabyrintheImpl.listeMap.get(currentPerso.getNomIndiv()).setVisible(true);
				Util.afficherPopUp("Game Over");
				// LabyrintheImpl.listeMap.get(enemy.getNomIndiv()).setVisible(false);
				fermer();
				// On ouvre la fen�tre de Personnage pour choisir son Personnage
				ui.Personnage fenPersonnage = new ui.Personnage(((Personnage) enemy).getIdUtilisateur());
				fenPersonnage.setVisible(true);

			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		monster = new javax.swing.JLabel();
		playerPV = new javax.swing.JProgressBar(0, 10);
		monsterPV = new javax.swing.JProgressBar(0, pvMonstreMax);
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

		monster.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		monster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		monster.setText("Monstre ");

		playerPV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		monsterPV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		imagePlayer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		imagePlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		imagePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N

		player.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		player.setText("Personnage ");

		lifePointsPlayer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lifePointsPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lifePointsPlayer.setText("PV : " + playerPV.getMaximum() + " / " + playerPV.getMaximum());

		imageEnemy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		imageEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		// imageEnemy.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/images/"+monstreCombat.getNomIndiv()+".png")));
		// // NOI18N

		lifePointsEnemy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lifePointsEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lifePointsEnemy.setText("PV : " + monsterPV.getMaximum() + " / " + monsterPV.getMaximum());

		buttonRun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
								.addComponent(monsterPV, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
								.addComponent(monster, javax.swing.GroupLayout.DEFAULT_SIZE,
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
								.addComponent(monster, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(imageEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(monsterPV, javax.swing.GroupLayout.PREFERRED_SIZE,
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
	}// </editor-fold>//GEN-END:initComponents

	private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// Quitte le combat

		// Sauvegarde dans la base
		System.out.println("Le joueur quitte le combat");

		try {
			// Le monstre ou le joueur combattu gagne 1 PV
			// Si r�cup�re le serveur;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Interruption du Thread de combat
			t.interrupt();
		}

		// Fermeture de la fen�tre
		this.setVisible(false);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonRun;
	private javax.swing.JLabel imageEnemy;
	private javax.swing.JLabel imagePlayer;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lifePointsEnemy;
	private javax.swing.JLabel lifePointsPlayer;
	private javax.swing.JLabel monster;
	private javax.swing.JProgressBar monsterPV;
	private javax.swing.JLabel player;
	private javax.swing.JProgressBar playerPV;
	// End of variables declaration//GEN-END:variables
}
