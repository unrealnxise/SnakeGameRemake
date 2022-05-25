import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    GameFrame(){
        add(new GamePanel());
        setIconImage(new ImageIcon("DATA/textures/classic.png").getImage());
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
