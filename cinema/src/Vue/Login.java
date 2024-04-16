package Vue;
import Modele.*;
import Controlleur.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private boolean login_state; //true si il a réussi à se connecter, false sinon (pour passer à l'onglet suivant

    public Login() throws SQLException {
        Modele.UserDAO userDAO=null;
        LoginControlleur loginControlleur = null;
        try{
            userDAO = new Modele.UserDAOImpl();
            loginControlleur = new LoginControlleur(userDAO);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            if(userDAO!=null)
            {
                try{
                    userDAO.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }

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

        // Ajout d'un listener pour le bouton de connexion
        LoginControlleur finalLoginControlleur = loginControlleur;
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars); // Convertir le tableau de caractères en String
                // Vérifier les informations de connexion (à implémenter)
                System.out.println("utilisateur : "+username);
                System.out.println("mdp : "+password);
                if (finalLoginControlleur.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie");
                    // Ici vous pouvez ouvrir une nouvelle fenêtre ou effectuer d'autres actions
                    login_state=true;
                } else {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect");
                    login_state=false;
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

    public boolean getLoginState()
    {
        return login_state;
    }


}

