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
import javax.swing.plaf.ColorUIResource;

import persistence.LabyrintheJDBC;
import model.Labyrinthe;
import model.Personnage;

/**
 *
 * @author Administrateur
 */
public class Sauvegarder extends javax.swing.JFrame {

	private Personnage currentPerso;
    /**
     * Creates new form Sauvegarder
     */
    public Sauvegarder(Personnage choixPerso) {
    	currentPerso = choixPerso;
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
        l_question = new javax.swing.JLabel();
        b_oui = new javax.swing.JButton();
        b_non = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        setTitle("RandoMaze - Sauvegarder");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        l_question.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        l_question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_question.setText("Voulez-vous sauvegarder et quitter le jeu ?");

        b_oui.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        b_oui.setText("Oui");
        b_oui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ouiMouseClicked(evt);
            }
        });

        b_non.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        b_non.setText("Non");
        b_non.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_nonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_oui, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addGap(101, 101, 101)
                        .addComponent(b_non, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                    .addComponent(l_question, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(l_question, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_oui, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(b_non, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(117, 117, 117))
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

    private void b_ouiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ouiMouseClicked
        // TODO add your handling code here:
       System.out.println("Sauvegarde dans la BDD");
		Labyrinthe laby;
		try {
			laby = (Labyrinthe) Naming.lookup("MonServeur1");
			boolean result = laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv() ,currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());
			
			if (result == false) {
				System.out.println("Probl�me de sauvegarde dans la BDD!");
		
				int option = JOptionPane.showConfirmDialog(null, 
			        "Erreur de sauvegarde. Voulez-vous quand m�me quitter ?", 
			        "Erreur de sauvegarde", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE);
			      
			      if(option == JOptionPane.OK_OPTION){
			          System.exit(0);   	
			      }else{
			    	  this.setVisible(false);
	        	      //Maze fenMaze = new Maze(currentPerso);
	        	      //fenMaze.setVisible(true);
			      }
			} else {
				System.out.println("Sauvegarde r�ussie!");
				System.exit(0);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }//GEN-LAST:event_b_ouiMouseClicked

    private void b_nonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_nonMouseClicked
        // TODO add your handling code here:
        //Fermer la bdd ... 
    	try {
    		//LabyrintheJDBC laby = new LabyrintheJDBC("MaBD");
			//laby.fermer();

			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }//GEN-LAST:event_b_nonMouseClicked

	private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
    	this.setVisible(false);
    }
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_non;
    private javax.swing.JButton b_oui;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_question;
    // End of variables declaration//GEN-END:variables
}
