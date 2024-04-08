package Vue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pageprincipal {
    private JFrame fenetre;
    private JLabel texteLabel; // Déclaration de texteLabel comme variable de membre

    public Pageprincipal(JFrame fenetre,JLabel texteLabel) { // Le constructeur
        this.fenetre = fenetre;
        this.texteLabel = texteLabel;
    }


    public void ajouterBouton(JFrame fenetre,JLabel texteLabel){

        JButton bouton1 = new JButton("Accueil");
        JButton bouton2 = new JButton("Connexion");
        bouton1.setBounds(20, 20, 150, 40); // x, y, largeur, hauteur
        bouton2.setBounds(180, 20, 150, 40);

        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton 1 cliqué");
            }
        });

        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton 2 cliqué");
            }
        });

        // Ajouter les boutons à la fenêtre
        fenetre.add(bouton1);
        fenetre.add(bouton2);

    }
    public void ajouterImage(JLabel texteLabel, String texte){
        if (texteLabel != null) {
            texteLabel.setText(texte);
            // Définir la position et la taille du texteLabel
            texteLabel.setBounds(20, 120, 200, 40); // Exemple de position et taille
            fenetre.add(texteLabel);

        } else {
            System.out.println("texteLabel n'est pas initialisé.");
        }
    }
    public void afficherImageURL(String nomimage,int coordonnex,int coordonney) {
        SwingUtilities.invokeLater(() -> {
            try {
                ImageIcon image = new ImageIcon(getClass().getResource(nomimage));
                JLabel label = new JLabel(image);
                // Définir explicitement la position et la taille
                label.setBounds(coordonnex, coordonney, image.getIconWidth(), image.getIconHeight()); // Ajuste selon les besoins
                fenetre.add(label);
                fenetre.pack();
                fenetre.setLocationRelativeTo(null);
                fenetre.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(fenetre, "Impossible de charger l'image", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }



}
