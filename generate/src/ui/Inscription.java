/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ui;
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
import model.LabyrintheImpl;
import model.Utilisateur;

/**
 *
 * @author Aurore
 */
public class Inscription extends javax.swing.JFrame {

    /**
     * Creates new form Inscription
     */
    public Inscription() {
    	// Initialisation de la fen�tre Inscription
        initComponents();
        
        //Dimensionnement Fenetre
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
        int width = (int) (350 - insets.left - insets.right);
        int height = (int) (500 - insets.top - insets.bottom);
        this.setSize(width, height);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomUtilisateur = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        motDePasse = new javax.swing.JPasswordField();
        buttonInscription = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandoMaze - Inscription");
        setPreferredSize(new java.awt.Dimension(190, 218));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nomUtilisateur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomUtilisateur.setToolTipText("");
        nomUtilisateur.setName(""); // NOI18N
        nomUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomUtilisateurActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nom utilisateur");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mot de passe");

        motDePasse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        motDePasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motDePasseActionPerformed(evt);
            }
        });

        buttonInscription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonInscription.setText("S'inscrire");
        buttonInscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					buttonInscriptionMouseClicked(evt);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        buttonInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInscriptionActionPerformed(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomUtilisateur)
                    .addComponent(motDePasse)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(buttonInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomUtilisateurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomUtilisateurActionPerformed

    private void motDePasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motDePasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motDePasseActionPerformed

    private void buttonInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInscriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonInscriptionActionPerformed

    private void buttonInscriptionMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {//GEN-FIRST:event_buttonInscriptionMouseClicked
        // L'Inscription est sur le Serveur1
    	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
    	
    	// Si le nom d'utilisateur est vide
    	if (nomUtilisateur.getText().trim().length() <= 0) {
    		System.out.println("Remplissez le nom d'utilisateur.");
    		Util.afficherPopUp("Remplissez le nom d'utilisateur.");
    	// Sinon si le mot de passe est vide
    	} else if (motDePasse.getText().trim().length() <= 0) {
    		System.out.println("Remplissez le mot de passe.");
    		Util.afficherPopUp("Remplissez le mot de passe.");
    	// Les deux champs ne sont pas vide
    	} else {
    		// Cr�ation de l'utilisateur
    		boolean result = laby.creerUtilisateur(nomUtilisateur.getText(), motDePasse.getText());
        	// Si erreur lors de la cr�ation
        	if (result == false) {
        		System.out.println("Problème d'inscription");
        		Util.afficherPopUp("Problème d'inscription - Nom déjà existant ou autre erreur...");
        	// Si inscription r�ussie
        	} else {
        		System.out.println("Inscription réussie");
        		// On ferme la fen�tre Inscription
        		this.setVisible(false);
        		// On se connecte au compte qui vient d'�tre cr��
        		Utilisateur utilisateur = laby.se_connecter(nomUtilisateur.getText(), motDePasse.getText());
        		// On ouvre la fen�tre CreerPersonnage
                CreerPersonnage fenCreerPersonnage = new CreerPersonnage(utilisateur.getIdUser());
                fenCreerPersonnage.setVisible(true);
        	}
    	}
        
    }//GEN-LAST:event_buttonInscriptionMouseClicked

    public void quitterFenetre() throws RemoteException, MalformedURLException, NotBoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// tester s'il y a d'autres fenetre ouvertes
		Window[] frames = JFrame.getWindows();
		boolean ouvert = false;
		for (int i=0 ; i<frames.length ; i++) {
			if (frames[i].isVisible() && ! this.getName().equals(frames[i].getName())){
				ouvert = true;
			}
		}
		if (!ouvert) {
			Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
			laby.quitter();
		}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField motDePasse;
    private javax.swing.JTextField nomUtilisateur;
    // End of variables declaration//GEN-END:variables
}
