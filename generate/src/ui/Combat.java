/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ui;
package ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.Individu;
import model.Labyrinthe;
import model.Monstre;
import model.Piece;

/**
 *
 * @author Schyzo
 */
public class Combat extends javax.swing.JFrame {

    /**
     * Creates new form Combat
     */
	//init fen�tre
	public void initialisationFenetre(){
		initComponents();
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
	
	//Combat contre un monstre
    public Combat(model.Personnage currentPerso) {
        //Initialisation Fenetre
    	initialisationFenetre();
        
    	System.out.println("Combat contre un monstre");
        //Appel m�thode g�n�ration combat
        model.Monstre monstreCombat = new Monstre(1, "mechant");
        monstreCombat.createMonstre();
        
        //Tant que le joueur ne clique pas sur Fuir ou PV=0, le combat continue
    	this.addComponentListener(new ComponentAdapter() {
    	    public void componentShown(ComponentEvent e) {
    	    	int pvJoueur = 10;
    	        int pvMonstre = 5;
    	        monsterPV.setValue(pvMonstre);
    	        monsterPV.repaint();
    	        playerPV.setValue(pvJoueur);
    	        playerPV.repaint();
    	        
    	        while(pvMonstre!=0 && pvJoueur!=0)
    	        {      	
    	        	//Toute les secondes, un des deux perd 1 point
    	        	if(Individu.retirerPV()==false){
    	        		pvMonstre-=1;
    	        		monstreCombat.setNbPVIndiv(pvMonstre);
    	        		monsterPV.setValue(pvMonstre);
    	        		monsterPV.repaint();
        	        	System.out.println("PV Monstre : "+pvMonstre);
    	        	}else{
    	        		pvJoueur-=1;
    	        		currentPerso.setNbPVIndiv(pvJoueur);
    	        		playerPV.setValue(pvJoueur);
    	        		playerPV.repaint();
        	        	System.out.println("PV Joueur : "+pvJoueur);
    	        	}
    	        }
    	        
    	        //Test si perso ou monstre meurt
    	        if(pvJoueur==0)
    	        {
    	        	System.out.println("Mort du joueur");
    	        	
    	        	
					try {
						//Le monstre gagne 1 PV
	    	        	// Si r�cup�re le serveur
	    	        	Labyrinthe laby = (Labyrinthe) Naming.lookup("MonServeur1");;
	    	        	Piece piece;
						piece = laby.getPieceById(currentPerso.getIdPiece());
						
						if(piece.getNomServer().equals("alpha")) {
	    	    		 	laby = (Labyrinthe) Naming.lookup("MonServeur1");
	    	    		 	//boolean result = laby.updatePersonnage(monstreCombat.getIdIndiv(), monstreCombat.getNomIndiv() ,monstreCombat.getNbPVIndiv(), monstreCombat.getIdPiece());
	    	        	} else if (piece.getNomServer().equals("beta")) {
	    	             	laby = (Labyrinthe) Naming.lookup("MonServeur2"); 
	    	             	boolean result = laby.updatePersonnage(currentPerso.getIdIndiv(), currentPerso.getNomIndiv() ,currentPerso.getNbPVIndiv(), currentPerso.getIdPiece());
	    	            }
					} catch (MalformedURLException | RemoteException
							| NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	        	
    	        	
    	        }else if(pvMonstre==0)
    	        {
    	        	System.out.println("Mort du monstre");
    	        	
    	        	//Le joueur gagne 1 PV
    	        }
    	    }
    	});        
    }
    
    //Combat entre joueur
    public Combat(model.Personnage currentPerso, String persoCombat) {
    	//Initialisation Fenetre
    	initialisationFenetre();
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
        monster = new javax.swing.JLabel();
        playerPV = new javax.swing.JProgressBar();
        monsterPV = new javax.swing.JProgressBar();
        imagePlayer = new javax.swing.JLabel();
        player = new javax.swing.JLabel();
        lifePointsPlayer = new javax.swing.JLabel();
        imageEnemy = new javax.swing.JLabel();
        lifePointsEnemy = new javax.swing.JLabel();
        buttonRun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RandoMaze - Combat");
        setMaximumSize(new java.awt.Dimension(824, 528));
        setMinimumSize(new java.awt.Dimension(824, 528));
        setPreferredSize(new java.awt.Dimension(824, 528));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        monster.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        monster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monster.setText("Monstre");

        playerPV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        monsterPV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        imagePlayer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        imagePlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagePlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
        
        player.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player.setText("Personnage");

        lifePointsPlayer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lifePointsPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lifePointsPlayer.setText("PV");

        imageEnemy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        imageEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageEnemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xemnas.jpg"))); // NOI18N

        lifePointsEnemy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lifePointsEnemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lifePointsEnemy.setText("PV");

        buttonRun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonRun.setText("Fuir");
        buttonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playerPV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lifePointsPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(monster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lifePointsEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(buttonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(319, 319, 319))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(monster, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monsterPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lifePointsEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(playerPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lifePointsPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(buttonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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

    private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	//Quitte le combat
    	
    	//Sauvegarde dans la base 
    	
    	//Fermeture de la fen�tre
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
