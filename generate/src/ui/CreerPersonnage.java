package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import model.Labyrinthe;

/**
 * Classe CreerPersonnage
 * @author Manon, Aurore, Youssef
 *
 */
public class CreerPersonnage extends javax.swing.JFrame {

	/**
	 * Variables
	 */
	private int idUtilisateur;
	
    /**
     * Constructeur de la classe CreerPersonnage
     * @param idUtilisateur
     */
    public CreerPersonnage(int idUtilisateur) {
    	
    	this.idUtilisateur = idUtilisateur;
    	
    	//Initialisation de la fenêtre
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Dimensionnement Fenetre
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
        int width = (int) (524 - insets.left - insets.right);
        int height = (int) (368 - insets.top - insets.bottom);
        setSize(width, height);
    }

    /**
     * Initialisation de la fenêtre (NetBeans)
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_nomPers = new javax.swing.JLabel();
        tf_nomPers = new javax.swing.JTextField();
        b_annuler = new javax.swing.JButton();
        b_creer = new javax.swing.JButton();

        setTitle("RandoMaze - Créer un personnage");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l_nomPers.setFont(new java.awt.Font("Arial", 0, 14)); 
        l_nomPers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_nomPers.setText("Nom du personnage");

        b_annuler.setFont(new java.awt.Font("Arial", 0, 14));
        b_annuler.setText("Annuler");
        b_annuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					b_annulerMouseClicked(evt);
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        b_creer.setFont(new java.awt.Font("Arial", 0, 14));
        b_creer.setText("Créer");
        b_creer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					b_creerMouseClicked(evt);
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(b_annuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96)
                .addComponent(b_creer, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(l_nomPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nomPers, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nomPers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_nomPers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_creer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * Traitement du clic sur le bouton Annuler
     * @param evt
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    private void b_annulerMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {
    	//On ferme la fenêtre en cours
        this.setVisible(false);
        
        //On affiche la fenêtre de sélection des personnages
        Personnage fenPersonnage = new Personnage(this.idUtilisateur);
        fenPersonnage.setVisible(true);
    }

    /**
     * Traitement du clic sur le bouton Creer
     * @param evt
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    private void b_creerMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {
        //Connexion au serveur 1
    	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
    	
    	//Si le champ de saisie du nom du personnage est vide, message d'erreur
    	//Sinon on envoie la requête de création du personnage au serveur
    	if (tf_nomPers.getText().trim().length() <= 0) {
    		System.out.println("Remplissez le nom du personnage.");
    		Util.afficherPopUp("Remplissez le nom du personnage.");
    	} else {
        	boolean result = laby.creerPersonnage(tf_nomPers.getText(), idUtilisateur);
        	
        	//Si la création du personnage n'a pas pu avoir lieu, message d'erreur
        	//Sinon on affiche la fenêtre de sélection des personnages
        	if (result == false) {
        		System.out.println("Problème de création de personnage - Nom de personnage déjà existant ou autre erreur... ");
        		Util.afficherPopUp("Problème de création de personnage - Nom de personnage déjà existant ou autre erreur...");
        	} else {
        		System.out.println("Personnage créé !");
        		this.setVisible(false);
        		Personnage fenPersonnage = new Personnage(this.idUtilisateur);
        		fenPersonnage.setVisible(true);
        	}
    	}
        
    }

    /**
     * Traitement du clic sur la croix rouge
     * Permet de fermer la fenêtre
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public void quitterFenetre() throws RemoteException, MalformedURLException, NotBoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//On test s'il y a d'autres fenêtres ouvertes
		Window[] frames = JFrame.getWindows();
		boolean ouvert = false;
		for (int i=0 ; i<frames.length ; i++) {
			if (frames[i].isVisible() && ! this.getName().equals(frames[i].getName())){
				ouvert = true;
			}
		}
		
		//S'il n'y a pas d'autres fenêtres ouvertes, on peut fermer le serveur, et la fenêtre
		if (!ouvert) {
			Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
			laby.quitter();
		}
    }
    
    // Variables declaration
    private javax.swing.JButton b_annuler;
    private javax.swing.JButton b_creer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_nomPers;
    private javax.swing.JTextField tf_nomPers;
    // End of variables declaration
}
