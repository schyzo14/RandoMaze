package ui;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Labyrinthe;

/**
 * @author Manon, Aurore, Youssef
 */
public class Personnage extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678088348421170218L;

	// Id de l'utilisateur connecté
	private int idUtilisateur;
	// Liste des personnages de l'utilisateur
	private ArrayList<model.Personnage> listPersonnages;

	/**
	 * Fenetre Choix du personnage
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Personnage(int idUtilisateur) throws MalformedURLException, RemoteException, NotBoundException {

		this.idUtilisateur = idUtilisateur;

		// Le choix du personnage se fait sur le serveur 1
		Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
		// On récupère les personnages du joueur
		ArrayList<model.Personnage> listPerso = laby.getPersonnages(idUtilisateur);
		this.listPersonnages = listPerso;

		// On prépare les personnages à afficher
		String[] strings = new String[listPerso.size()];
		int i = 0;
		for (model.Personnage perso : listPerso) {
			strings[i] = perso.getNomIndiv();
			i++;
		}

		// Initialise la fenetre
		initComponents(strings);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// Dimensionnement de la Fenetre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
		int width = (int) (824 - insets.left - insets.right);
		int height = (int) (568 - insets.top - insets.bottom);
		setSize(width, height);
	}

	/**
	 * Initalisation de la fenetre du choix de personnage
	 * 
	 * @param strings
	 *            : liste des personnages
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents(String[] strings) {

		jPanel1 = new javax.swing.JPanel();
		scrollPanel = new javax.swing.JScrollPane();
		list = new javax.swing.JList();
		buttonValider = new javax.swing.JButton();
		buttonNouveauPersonnage = new javax.swing.JButton();
		l_message = new javax.swing.JLabel();

		setTitle("RandoMaze - Choisir un personnage");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		list.setFont(new java.awt.Font("Arial", 0, 14));
		list.setModel(new javax.swing.AbstractListModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5087198753989132807L;

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		scrollPanel.setViewportView(list);

		buttonValider.setFont(new java.awt.Font("Arial", 0, 14));
		buttonValider.setText("Valider");
		buttonValider.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					buttonValiderMouseClicked(evt);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				}
			}
		});

		buttonNouveauPersonnage.setFont(new java.awt.Font("Arial", 0, 14));
		buttonNouveauPersonnage.setText("Nouveau personnage...");
		buttonNouveauPersonnage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				buttonNouveauPersonnageMouseClicked(evt);
			}
		});

		// Croix fermer
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				try {
					quitterFenetre();
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					e.printStackTrace();
				}

			}
		});

		l_message.setFont(new java.awt.Font("Arial", 0, 16));
		l_message.setText("Liste de vos personnages disponibles. Choisissez en un !");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(buttonValider, javax.swing.GroupLayout.PREFERRED_SIZE,
														385, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
														Short.MAX_VALUE)
												.addComponent(buttonNouveauPersonnage,
														javax.swing.GroupLayout.PREFERRED_SIZE, 383,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(l_message, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(l_message, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(50, 50, 50)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonNouveauPersonnage, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(137, 137, 137)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * Clic bouton Valider
	 * 
	 * @param evt
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	private void buttonValiderMouseClicked(java.awt.event.MouseEvent evt)
			throws MalformedURLException, RemoteException, NotBoundException {
		// Si pas de choix de personnage
		if (list.getSelectedIndex() == -1) {
			System.out.println("Pas de personnage choisi");
			Util.afficherPopUp("Veuillez choisir un personnage ou en crÃ©er un.");
		} else {
			// Personnage choisi
			String nomPerso = (String) list.getSelectedValue();
			boolean trouve = false;

			// On vérifie que le personnage choisi existe vraiment
			for (model.Personnage personnage : this.listPersonnages) {
				if (personnage.getNomIndiv().equals(nomPerso)) {
					System.out.println("Choix du personnage : " + personnage.getNomIndiv());
					model.Personnage choixPersonnage = new model.Personnage(personnage.getIdIndiv(),
							personnage.getNomIndiv(), personnage.getNbPVIndiv(), personnage.getIdPiece(),
							idUtilisateur);
					// On ferme la fenetre du choix du personnage
					this.setVisible(false);
					// On affiche le labyrinthe
					Maze fenMaze = new Maze(choixPersonnage);
					fenMaze.setVisible(true);
					trouve = true;
				}
			}

			// Pas de personnage choisi
			if (!trouve) {
				System.out.println("Personnage inconnue");
				Util.afficherPopUp("Veuillez choisir un personnage ou en crÃ©er un.");
			}
		}
	}

	/**
	 * Clic bouton Nouveau personnage
	 * 
	 * @param evt
	 */
	private void buttonNouveauPersonnageMouseClicked(java.awt.event.MouseEvent evt) {
		// Ferme la fenetre
		this.setVisible(false);

		// Affiche la fenetre pour créer un personnage
		CreerPersonnage fenCreerPerso = new CreerPersonnage(this.idUtilisateur);
		fenCreerPerso.setVisible(true);
	}

	/**
	 * Ferme la fenetre et teste si il y a d'autres fenetres ouvertes
	 * 
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public void quitterFenetre() throws RemoteException, MalformedURLException, NotBoundException {
		// ferme la fenetre
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// tester s'il y a d'autres fenetre ouvertes
		Window[] frames = JFrame.getWindows();
		boolean ouvert = false;
		for (int i = 0; i < frames.length; i++) {
			if (frames[i].isVisible() && !this.getName().equals(frames[i].getName())) {
				ouvert = true;
			}
		}
		// Si il n'y a pas d'autres fenetres ouvertes, on quitte
		if (!ouvert) {
			Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
			laby.quitter();
		}
	}

	// Composants de la fenetre
	private javax.swing.JButton buttonNouveauPersonnage;
	private javax.swing.JButton buttonValider;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel l_message;
	@SuppressWarnings("rawtypes")
	private javax.swing.JList list;
	private javax.swing.JScrollPane scrollPanel;

}
