import Vue.vue;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Palkis!");

        SwingUtilities.invokeLater(() -> {
            vue vue = new vue();
            vue.setVisible(true);
        });

    }
}
