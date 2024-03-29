package Vue;
import Modele.*;
import Controlleur.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        Modele.UserDAO userDAO = new Modele.UserDAOImpl();
        LoginControlleur loginControlleur = new LoginControlleur(userDAO);
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Se connecter");
        JLabel createAccountLabel = new JLabel("Vous n'avez pas de compte ? Créer un compte");

        // Ajout d'un écouteur pour le bouton de connexion
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars); // Convertir le tableau de caractères en String
                // Vérifier les informations de connexion (à implémenter)
                if (loginControlleur.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie");
                    // Ici vous pouvez ouvrir une nouvelle fenêtre ou effectuer d'autres actions
                } else {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect");
                }
            }
        });

        // Ajout d'un écouteur pour le texte de création de compte
        createAccountLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Ouvrir la fenêtre de création de compte (à implémenter)
                JOptionPane.showMessageDialog(null, "Fonctionnalité de création de compte à implémenter");
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(createAccountLabel);

        add(panel);

        setVisible(true);
    }


}

