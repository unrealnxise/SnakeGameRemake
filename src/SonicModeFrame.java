import javax.swing.*;

public class SonicModeFrame extends JFrame{
    SonicModeFrame(){
        add(new SonicModePanel());
        setIconImage(new ImageIcon("DATA/textures/classic.png").getImage());
        setTitle("Sonic Mode");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
