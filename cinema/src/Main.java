import Vue.*;
import Modele.*;
import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String nomfilm;

        int[] n = new int[4];
        System.out.println("Hello Palkis!");
        String databaseName = "cinema"; // Remplacez par le nom de votre base de données
        String utilisateur = "root"; // Utilisateur par défaut pour MySQL
        String motDePasse = ""; // Remplacez par votre mot de passe

        try {

            Connexion connexion = new Connexion(databaseName, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données réussie !");
            nomfilm= connexion.getFilmName();
            System.out.println(nomfilm);
            new Acceuil(nomfilm);
            // Supposant que RecupererInfo est correctement défini pour utiliser la connexion établie

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        }

        ///SwingUtilities.invokeLater(() -> {
         //   vue vue = new vue();
          //  vue.setVisible(true);
     ///   });



    }
}
