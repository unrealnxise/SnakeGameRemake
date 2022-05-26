import javax.swing.*;

public class MineFrame extends JFrame {
    MineFrame(){
        add(new MinePanel());
        setIconImage(new ImageIcon("DATA/textures/pickaxe.png").getImage());
        setTitle("Minecraft Mode");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
