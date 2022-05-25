import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame(){
        add(new GamePanel());
        setIconImage(new ImageIcon("textures/classic.png").getImage());
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
