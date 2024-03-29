package Controlleur;

import Modele.*;

import java.util.Optional;
public class LoginControlleur {
    private UserDAO userDAO;

    // Constructeur
    public LoginControlleur(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userDAO.getUserByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getUserPassword().equals(password);
        }else {
            return false;
        }

    }
}

