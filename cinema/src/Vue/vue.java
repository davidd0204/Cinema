package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class vue extends JFrame {
    private JTextField screen;

    public vue() {
        setTitle("Cinema ECE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        screen = new JTextField();
        screen.setFont(new Font("Arial", Font.BOLD, 20));
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);
        add(screen, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new BorderLayout()); // Utiliser un BorderLayout pour le panneau de boutons
        initialize_buttons(buttonPanel);

    }
    private void initialize_buttons(JPanel buttonPanel){
        /*JButton fermer = new JButton();
        //Redimensionner les images
        try {
            Image image = ImageIO.read(new File("C:\\Users\\david\\java\\projet_S6\\Cinema\\cinema\\fermer.jpeg"));
            Image resizedImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Redimensionner l'image
            ImageIcon icon = new ImageIcon(resizedImage); // Utiliser l'image redimensionnée pour créer l'icône
            fermer.setIcon(icon); // Définir l'icône du bouton
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Utiliser du code HTML pour placer le texte sous l'icône
        fermer.setText("<html><div style='text-align: center;'>Fermer</div></html>");


        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre
            }
        });

        // Ajouter le bouton dans le coin en haut à gauche
        buttonPanel.add(fermer, BorderLayout.NORTH);

        add(buttonPanel, BorderLayout.WEST); // Ajouter le panneau de boutons à gauche de la fenêtre

        pack();*/
    }
}
