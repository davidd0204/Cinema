package Modele;

import java.sql.*;
import java.util.*;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    // Constructeur, initialisation de la connexion

    public UserDAOImpl() throws SQLException {
        /*try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à votre base de données
            String url = "jdbc:mysql://localhost:3306/cinema";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Lancer une exception SQLException pour indiquer que la connexion à la base de données a échoué
            throw new SQLException("Connexion à la base de données impossible", e);
        }*/
    }
    @Override
    public Optional<User> getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE userName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt("userId"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserEmail(resultSet.getString("userEmail"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setUserAccountType(resultSet.getString("userAccountType")); //0 pour un admin et 1 pour un utilisateur
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void connect(String URLDataBase, String LoginDataBase, String PwdDataBase) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String urlDatabase = "jdbc:mysql://localhost:3306/cinema";
        connection = DriverManager.getConnection(URLDataBase, LoginDataBase, PwdDataBase);
    }
}
