import Vue.vue;
import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            vue vue = null;
            try {
                vue = new vue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            vue.setVisible(true);
        });
    }
}
