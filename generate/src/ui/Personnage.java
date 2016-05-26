/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ui;
package ui;

import java.awt.Color;
import java.awt.Dimension;
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
import model.LabyrintheImpl;

/**
 *
 * @author Aurore
 */
public class Personnage extends javax.swing.JFrame {

	private int idUtilisateur;
	private ArrayList<model.Personnage> listPersonnages;
	
    /**
     * Creates new form Personnage
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
    public Personnage (int idUtilisateur) throws MalformedURLException, RemoteException, NotBoundException {
    	
    	this.idUtilisateur = idUtilisateur;
    	
    	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");
    	ArrayList<model.Personnage> listPerso = laby.getPersonnages(idUtilisateur);
    	this.listPersonnages = listPerso;
    	
    	String[] strings = new String[listPerso.size()];
    	int i = 0;
    	for (model.Personnage perso : listPerso) {
    		strings[i] = perso.getNomIndiv();
    		i ++;
    	}
    	
        initComponents(strings);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Dimensionnement Fenetre
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration());
        int width = (int) (824 - insets.left - insets.right);
        int height = (int) (568 - insets.top - insets.bottom);
        setSize(width, height);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String[] strings) {

        jPanel1 = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        buttonValider = new javax.swing.JButton();
        buttonNouveauPersonnage = new javax.swing.JButton();
        l_message = new javax.swing.JLabel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandoMaze - Choisir un personnage");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        list.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        list.setModel(new javax.swing.AbstractListModel() {
            
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPanel.setViewportView(list);

        buttonValider.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonValider.setText("Valider");
        buttonValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					buttonValiderMouseClicked(evt);
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
        buttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderActionPerformed(evt);
            }
        });

        buttonNouveauPersonnage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonNouveauPersonnage.setText("Nouveau personnage...");
        buttonNouveauPersonnage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNouveauPersonnageMouseClicked(evt);
            }
        });
        buttonNouveauPersonnage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNouveauPersonnageActionPerformed(evt);
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
        
        l_message.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        l_message.setText("Liste de vos personnages disponibles. Choisissez en un !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(buttonNouveauPersonnage, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(l_message, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNouveauPersonnage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNouveauPersonnageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNouveauPersonnageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNouveauPersonnageActionPerformed

    private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonValiderActionPerformed

    private void buttonValiderMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException, RemoteException, NotBoundException {//GEN-FIRST:event_buttonValiderMouseClicked
        
    	
    	
    	if (list.getSelectedIndex() == -1) {
    		System.out.println("Pas de personnage choisi");
    		Util.afficherPopUp("Veuillez choisir un personnage ou en créer un.");
    	} else {
    		String nomPerso = (String) list.getSelectedValue();
    		boolean trouve = false;
    		for (model.Personnage personnage : this.listPersonnages) {
        		if (personnage.getNomIndiv().equals(nomPerso)) {
        			System.out.println("Choix du personnage : " + personnage.getNomIndiv());
        			model.Personnage choixPersonnage = new model.Personnage(personnage.getIdIndiv(), personnage.getNomIndiv(), personnage.getNbPVIndiv(), personnage.getIdPiece(), idUtilisateur);
        			this.setVisible(false);
        	        Maze fenMaze = new Maze(choixPersonnage);
        	        fenMaze.setVisible(true);
        	        trouve = true;
        		}
        	}
    		if (!trouve) {
     			System.out.println("Personnage inconnue");
     			Util.afficherPopUp("Veuillez choisir un personnage ou en créer un.");
     		}
    	}
    	
        
    }//GEN-LAST:event_buttonValiderMouseClicked

    private void buttonNouveauPersonnageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNouveauPersonnageMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        CreerPersonnage fenCreerPerso = new CreerPersonnage(this.idUtilisateur);
        fenCreerPerso.setVisible(true);
    }//GEN-LAST:event_buttonNouveauPersonnageMouseClicked

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
    private javax.swing.JButton buttonNouveauPersonnage;
    private javax.swing.JButton buttonValider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_message;
    private javax.swing.JList list;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
