import javax.swing.*;
import java.awt.*;

public class ShopWindow{
    JFrame frame;
    Button portalPack;
    Button minePack;

    ShopWindow(){
        portalPack = new Button("500$", 0, 50, 150, 150);
        portalPack.setForeground(Color.white);
        portalPack.setBackground(Color.black);
        portalPack.setHorizontalTextPosition(JButton.CENTER);
        portalPack.setVerticalTextPosition(JButton.BOTTOM);
        portalPack.setBorder(BorderFactory.createCompoundBorder());
        portalPack.setIconTextGap(10);
        portalPack.setIcon(new ImageIcon("textures/skinPacks/Portal/iconPack.png"));

        minePack = new Button("200$", 150, 50, 150, 150);
        minePack.setForeground(Color.white);
        minePack.setBackground(Color.black);
        minePack.setHorizontalTextPosition(JButton.CENTER);
        minePack.setVerticalTextPosition(JButton.BOTTOM);
        minePack.setBorder(BorderFactory.createCompoundBorder());
        minePack.setIconTextGap(10);
        minePack.setIcon(new ImageIcon("textures/skinPacks/Minecraft/iconPack.png"));

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 14));
        label.setText("Select your skin pack:");
        label.setBounds(150, 0, 140, 40);
        label.setLayout(null);
        label.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(label);
        panel.add(portalPack);
        panel.add(minePack);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setIconImage(new ImageIcon("textures/shop.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setTitle("Shop");
        frame.setSize(450, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }
}
