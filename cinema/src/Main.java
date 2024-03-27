import Vue.vue;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            vue vue = new vue();
            vue.setVisible(true);
        });
    }
}
