package Vue;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;

public class vue extends JFrame{
    private JTextField screen;
    public vue(){
        setTitle("Cinema ECE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        screen = new JTextField();
        screen.setFont(new Font("Arial", Font.BOLD, 20));
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);
        add(screen, BorderLayout.NORTH);
        JPanel button_pan =new JPanel();
        button_pan.setLayout(new GridLayout(1, 1));
        JButton fermer = new JButton("fermer");
        try{
            Image image = ImageIO.read(new File("C:\\Users\\david\\java\\projet_S6\\Cinema\\cinema\\fermer.jpeg"));
            ImageIcon icon = new ImageIcon(image);

        }catch (Exception e){
            e.printStackTrace();
        }
        fermer.addActionListener(e -> {
            dispose();
        });
        button_pan.add(fermer);
        fermer.setLayout(new FlowLayout(FlowLayout.LEFT));
        pack();
    }
    public JTextField getScreen() {
        return screen;
    }
}
