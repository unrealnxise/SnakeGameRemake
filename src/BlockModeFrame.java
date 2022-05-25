import javax.swing.*;

public class BlockModeFrame extends JFrame {
    BlockModeFrame(){
        add(new BlockModePanel());
        setIconImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage());
        setTitle("Block Mode");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
