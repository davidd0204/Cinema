package Vue;

import Vue.*;
import Modele.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Acceuil {
    private JFrame fenetre;
    private JLabel texteLabel;
    public Acceuil(){
        fenetre = new JFrame("Exemple avec deux boutons");
        texteLabel = new JLabel("Message initial");

        fenetre.setSize(1920, 1080);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null); // Utiliser un layout null pour le contrôle manuel des positions
        Pageprincipal page=new Pageprincipal(fenetre,texteLabel);

        page.ajouterBouton(fenetre,texteLabel);
        page.ajouterImage(texteLabel,"bonjour");
        page.afficherImageURL("/fermer.jpeg",870,400);

    }
}
