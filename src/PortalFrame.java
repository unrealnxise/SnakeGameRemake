import javax.swing.*;

public class PortalFrame extends JFrame {
    PortalFrame(){
        add(new PortalPanel());
        setIconImage(new ImageIcon("DATA/textures/skinPacks/Portal/portalA.png").getImage());
        setTitle("Portal Mode");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
