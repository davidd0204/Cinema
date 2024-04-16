package Modele;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDAO {
    Optional<User> getUserByUsername(String username);
    public void close() throws SQLException;
}
