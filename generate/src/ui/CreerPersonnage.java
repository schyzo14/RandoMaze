/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Labyrinthe;

/**
 *
 * @author Administrateur
 */
public class CreerPersonnage extends javax.swing.JFrame {

	private int idUtilisateur;
	
    /**
     * Creates new form CreerPersonnage
     */
    public CreerPersonnage(int idUtilisateur) {
    	
    	this.idUtilisateur = idUtilisateur;
    	
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_nomPers = new javax.swing.JLabel();
        tf_nomPers = new javax.swing.JTextField();
        b_annuler = new javax.swing.JButton();
        b_creer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandoMaze - Cr�er un personnage");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l_nomPers.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        l_nomPers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_nomPers.setText("Nom du personnage");

        b_annuler.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        b_creer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        b_creer.setText("Cr�er");
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
    }// </editor-fold>//GEN-END:initComponents

    private void b_annulerMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {//GEN-FIRST:event_b_annulerMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Personnage fenPersonnage = new Personnage(this.idUtilisateur);
        fenPersonnage.setVisible(true);
    }//GEN-LAST:event_b_annulerMouseClicked

    private void b_creerMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {//GEN-FIRST:event_b_creerMouseClicked
        // TODO add your handling code here:
    	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
    	
    	if (tf_nomPers.getText().trim().length() <= 0) {
    		System.out.println("Remplissez le nom du personnage.");
    		try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				UIManager.put("OptionPane.background", Color.WHITE);
	            UIManager.put("Panel.background", Color.WHITE);
	            UIManager.put("OptionPane.messageForeground", Color.BLACK);
	    		JOptionPane.showMessageDialog(null, "Remplissez le nom du personnage.");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
    	} else {
        	boolean result = laby.creerPersonnage(tf_nomPers.getText(), idUtilisateur);
        	
        	if (result == false) {
        		System.out.println("Probl�me de cr�ation de personnage - Nom de personnage d�j� existant ou autre erreur... ");
        		try {
    				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    				UIManager.put("OptionPane.background", Color.WHITE);
    	            UIManager.put("Panel.background", Color.WHITE);
    	            UIManager.put("OptionPane.messageForeground", Color.BLACK);
    	            JOptionPane.showMessageDialog(null, "Probl�me de cr�ation de personnage - Nom de personnage d�j� existant ou autre erreur...");
    			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
    				e.printStackTrace();
    			}
        	} else {
        		System.out.println("Personnage cr�� !");
        		this.setVisible(false);
        		Personnage fenPersonnage = new Personnage(this.idUtilisateur);
        		fenPersonnage.setVisible(true);
        	}
    	}
        
    }//GEN-LAST:event_b_creerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_annuler;
    private javax.swing.JButton b_creer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_nomPers;
    private javax.swing.JTextField tf_nomPers;
    // End of variables declaration//GEN-END:variables
}
