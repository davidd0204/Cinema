package Modele;

import java.util.Optional;

public interface UserDAO {
    Optional<User> getUserByUsername(String username);
}
