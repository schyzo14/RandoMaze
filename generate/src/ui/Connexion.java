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
public class Connexion extends javax.swing.JFrame {

    /**
     * Creates new form Connexion
     */
    public Connexion() {
    	// Initialisation de la fen�tre Connexion
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Dimensionnement Fenetre
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
        int width = (int) (350 - insets.left - insets.right);
        int height = (int) (500 - insets.top - insets.bottom);
        setSize(width, height);
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
        buttonConnexion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonInscription = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandoMaze - Connexion");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(300, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nomUtilisateur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomUtilisateur.setToolTipText("");
        nomUtilisateur.setMinimumSize(new java.awt.Dimension(6, 26));
        nomUtilisateur.setName(""); // NOI18N
        nomUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomUtilisateurActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nom utilisateur");
        jLabel1.setPreferredSize(new java.awt.Dimension(6, 26));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mot de passe");
        jLabel2.setMaximumSize(new java.awt.Dimension(6, 26));
        jLabel2.setMinimumSize(new java.awt.Dimension(6, 26));
        jLabel2.setPreferredSize(new java.awt.Dimension(6, 26));

        motDePasse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        motDePasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motDePasseActionPerformed(evt);
            }
        });

        buttonConnexion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonConnexion.setText("Connexion");
        buttonConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConnexionMouseClicked(evt);
            }
        });
        buttonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonConnexionActionPerformed(evt);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        buttonInscription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonInscription.setText("S'inscrire");
        buttonInscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonInscriptionMouseClicked(evt);
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
					Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motDePasse)
                    .addComponent(nomUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonConnexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
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
                .addComponent(buttonConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setLocationRelativeTo(null);
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

    private void buttonConnexionActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException {//GEN-FIRST:event_buttonConnexionActionPerformed
        // La connexion se fait sur le serveur 1
    	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
    	// On essaye de se connecter
    	Utilisateur utilisateur = laby.se_connecter(nomUtilisateur.getText(), motDePasse.getText());
    	// Si l'utilisateur est inconnu ou le mot de passe incorrect
    	if(utilisateur == null || !utilisateur.getMdpUser().equals(motDePasse.getText())) {
    		System.out.println("Erreur de nom d'utilisateur ou de mot de passe.");
    		Util.afficherPopUp("Erreur de nom d'utilisateur ou de mot de passe.");
        } else {
        	System.out.println("Nom d'utilisateur et mot de passe correct!");
        	// On ferme la fen�tre de Connexion
        	this.setVisible(false);
        	// On ouvre la fen�tre de Personnage pour choisir son Personnage
        	Personnage fenPersonnage = new Personnage(utilisateur.getIdUser());
        	fenPersonnage.setVisible(true);
        }
		
    }//GEN-LAST:event_buttonConnexionActionPerformed

    private void buttonConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConnexionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonConnexionMouseClicked

    private void buttonInscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonInscriptionMouseClicked
        // On ferme la fen�tre Connexion
    	this.setVisible(false);
    	// On ouvre la fen�tre Inscription
        Inscription fenInscription = new Inscription();
        fenInscription.setVisible(true);
    }//GEN-LAST:event_buttonInscriptionMouseClicked


    public void demarrer() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }
    
    public void quitterFenetre() throws RemoteException, MalformedURLException, NotBoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// tester si il y a d'autres fenetre ouvertes
		Window[] frames = JFrame.getWindows();
		boolean ouvert = false;
		for (int i=0 ; i<frames.length ; i++) {
			if (frames[i].isVisible() && ! this.getName().equals(frames[i].getName())){
				ouvert = true;
			}
		}
		if (! ouvert) {
			Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
			laby.quitter();
		}

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnexion;
    private javax.swing.JButton buttonInscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField motDePasse;
    private javax.swing.JTextField nomUtilisateur;
    // End of variables declaration//GEN-END:variables
}
