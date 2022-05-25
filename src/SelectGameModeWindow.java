import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectGameModeWindow implements ActionListener {
    JFrame frame;
    Button mode1;
    Button mode2;
    Button mode3;
    Button mode4;
    Button mode5;
    Button mode6;
    Button shop;

    SelectGameModeWindow(){
        shop = new Button("Shop", 135, 200, 120, 40);
        shop.setIcon(new ImageIcon("textures/shop.png"));
        shop.addActionListener(this);

        mode1 = new Button("Classic", 10, 50, 120, 40);
        mode1.setIcon(new ImageIcon("textures/classic.png"));
        mode1.addActionListener(this);

        mode2 = new Button("Portal", 135, 50, 120, 40);
        mode2.setIcon(new ImageIcon("textures/skinPacks/Portal/portalA.png"));
        mode2.addActionListener(this);

        mode3 = new Button("Sonic", 260, 50, 120, 40);
        // Icon
        mode3.addActionListener(this);

        mode4 = new Button("Minecraft", 10, 100, 120, 40);
        mode4.setFont(new Font("Ink Free", Font.BOLD, 12));
        mode4.setIcon(new ImageIcon("textures/skinPacks/Minecraft/head.png"));
        mode4.addActionListener(this);

        mode5 = new Button("Block Mode", 135, 100, 120, 40);
        // Icon
        mode5.addActionListener(this);

        mode6 = new Button("Danger zone", 260, 100, 120, 40);
        // Icon
        mode6.addActionListener(this);

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 14));
        label.setText("Select your mode:");
        label.setBounds(140, 0, 120, 40);
        label.setLayout(null);
        label.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(mode1);
        panel.add(mode2);
        panel.add(mode3);
        panel.add(mode4);
        panel.add(mode5);
        panel.add(mode6);
        panel.add(shop);
        panel.add(label);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setIconImage(new ImageIcon("textures/classic.png").getImage());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Game Modes");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mode1){
            int i = JOptionPane.showConfirmDialog(null, "Are u sure?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if(i == 0) {
                frame.dispose();
                new GameFrame();
            }
        } else if (e.getSource()==shop) {
            int i = JOptionPane.showConfirmDialog(null, "Are u sure?", "Warning!",
                    JOptionPane.YES_NO_OPTION);
            if(i == 0) {
                frame.dispose();
                new ShopWindow();
            }
        }
    }
}
