import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InterfaceConnexion {
    private JFrame frame;
    private JButton boutonConnexion;
    private JButton boutonInvité;

    // Constructeur
    public InterfaceConnexion() {
        // Création de la fenêtre principale
        frame = new JFrame("Interface de Connexion");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(frame);

        // Création du bouton de connexion
        boutonConnexion = new JButton("Connexion");
        boutonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe
                afficherInterfaceConnexion();
            }
        });

        // Création du bouton d'invité
        boutonInvité = new JButton("Invité");
        boutonInvité.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton d'invité est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe
                //afficherInterfaceConnexion();

            }
        });

        // Ajout des boutons à la fenêtre principale
        frame.add(boutonConnexion);
        frame.add(boutonInvité);

        // Rendre la fenêtre principale visible
        frame.setVisible(true);
    }

    // Méthode pour afficher l'interface de saisie utilisateur et mot de passe
    private void afficherInterfaceConnexion() {
        JFrame frameConnexion = new JFrame("Connexion");
        frameConnexion.setSize(300, 150);
        frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConnexion.setLayout(new GridLayout(4, 1));

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        frameConnexion.setLocationRelativeTo(frame);

        // Ajouter des champs de saisie pour l'utilisateur et le mot de passe
        JTextField champUtilisateur = new JTextField();
        JPasswordField champMotDePasse = new JPasswordField();

        // Créer le bouton de validation
        JButton boutonValider = new JButton("Valider");
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs saisies par l'utilisateur
                String utilisateur = champUtilisateur.getText();
                String motDePasse = new String(champMotDePasse.getPassword());

                // Afficher les informations saisies dans une nouvelle interface
                try {
                    afficherInfosUtilisateur(utilisateur, motDePasse);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Fermer la fenêtre de connexion
                frameConnexion.dispose();
            }
        });
        // Ajouter les composants à la fenêtre de connexion
        frameConnexion.add(new JLabel("Utilisateur:"));
        frameConnexion.add(champUtilisateur);
        frameConnexion.add(new JLabel("Mot de passe:"));
        frameConnexion.add(champMotDePasse);
        frameConnexion.add(boutonValider);
        JButton boutonRetour = new JButton("Retour");
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre des informations utilisateur
                frameConnexion.dispose();

                // Afficher à nouveau la fenêtre principale
                frame.setVisible(true);
            }
        });

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        frameConnexion.add(boutonRetour);


        // Rendre la fenêtre de connexion visible
        frameConnexion.setVisible(true);
    }

        // Méthode pour vérifier l'utilisateur et le mot de passe dans la base de données
        public  void verifierUtilisateur(String utilisateur, String motDePasse) throws SQLException {
            // Connexion à la base de données (à adapter selon votre configuration)
            String URL_BDD = "jdbc:mysql://localhost:3306/utilisateur";
            String UTILISATEUR_BDD = "root";
            String MOT_DE_PASSE_BDD = "Jack123456";
            Connection connexion = null;
            try {
                // Chargement du driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Etablissement de la connexion
                connexion = DriverManager.getConnection(URL_BDD, UTILISATEUR_BDD, MOT_DE_PASSE_BDD);

                // Si la connexion est établie avec succès
                if (connexion != null) {

                    System.out.println("Connexion établie avec la base de données !");
                    PreparedStatement ps1 = connexion.prepareStatement("select * from utilisateur");
                    ResultSet rs=ps1.executeQuery();
                    while(rs.next()){
                        System.out.println(rs.getInt("ID")+"\t"+rs.getString("NOM")+"\t"+rs.getInt("AGE"));
                    }
                    // Vous pouvez maintenant effectuer des opérations sur la base de données
                } else {
                    System.out.println("Echec de la connexion à la base de données !");
                }

                // TOUT LES EXCEPTIONS
            } catch (SQLException e) {
                System.out.println("Erreur de connexion : " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC non trouvé : " + e.getMessage());
            } finally {
                // Fermeture de la connexion
                try {
                    if (connexion != null) {
                        connexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }

        }

    // Méthode pour afficher les informations de l'utilisateur dans une nouvelle interface
    private void afficherInfosUtilisateur(String utilisateur, String motDePasse) throws SQLException {
        JFrame frameInfos = new JFrame("Informations Utilisateur");
        frameInfos.setSize(300, 150);
        frameInfos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInfos.setLayout(new GridLayout(3, 1));
        frameInfos.setLocationRelativeTo(frame);

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        frameInfos.setLocationRelativeTo(frame);

        // Créer des étiquettes pour afficher les informations de l'utilisateur
        JLabel labelUtilisateur = new JLabel("Utilisateur: " + utilisateur);
        JLabel labelMotDePasse = new JLabel("Mot de passe: " + motDePasse);
        verifierUtilisateur(utilisateur,motDePasse);

        // Ajouter les étiquettes à la fenêtre des informations utilisateur
        frameInfos.add(labelUtilisateur);
        frameInfos.add(labelMotDePasse);

        // Créer un bouton pour revenir à la page principale
        JButton boutonRetour = new JButton("Retour");
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre des informations utilisateur
                frameInfos.dispose();

                // Afficher à nouveau la fenêtre principale
                frame.setVisible(true);
            }
        });

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        frameInfos.add(boutonRetour);

        // Rendre la fenêtre des informations utilisateur visible
        frameInfos.setVisible(true);
    }

    // Méthode principale
    public static void main(String[] args) {
        // Création de l'interface de connexion
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceConnexion();
            }
        });
    }
}