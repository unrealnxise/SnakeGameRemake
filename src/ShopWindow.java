import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopWindow implements ActionListener {
    JFrame frame;
    Button portalPack;
    Button minePack;

    Button back;

    ShopWindow(){
        portalPack = new Button("500$", 0, 50, 150, 150);
        portalPack.setForeground(Color.white);
        portalPack.setBackground(Color.black);
        portalPack.setHorizontalTextPosition(JButton.CENTER);
        portalPack.setVerticalTextPosition(JButton.BOTTOM);
        portalPack.setBorder(BorderFactory.createCompoundBorder());
        portalPack.setIconTextGap(10);
        portalPack.setIcon(new ImageIcon("DATA/textures/skinPacks/Portal/iconPack.png"));

        minePack = new Button("200$", 150, 50, 150, 150);
        minePack.setForeground(Color.white);
        minePack.setBackground(Color.black);
        minePack.setHorizontalTextPosition(JButton.CENTER);
        minePack.setVerticalTextPosition(JButton.BOTTOM);
        minePack.setBorder(BorderFactory.createCompoundBorder());
        minePack.setIconTextGap(10);
        minePack.setIcon(new ImageIcon("DATA/textures/skinPacks/Minecraft/iconPack.png"));

        back = new Button("Back", 15, 300, 120, 40);
        back.setIcon(new ImageIcon("DATA/textures/classic.png"));
        back.addActionListener(this);

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 14));
        label.setText("Select your skin pack:");
        label.setBounds(150, 0, 140, 40);
        label.setLayout(null);
        label.setForeground(Color.white);

        JLabel label1 = new JLabel();
        label1.setFont(new Font("Ink Free", Font.BOLD, 14));
        label1.setText("Money: " + Bank.money);
        label1.setBounds(340, 320, 120, 40);
        label1.setLayout(null);
        label1.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(label);
        panel.add(label1);
        panel.add(portalPack);
        panel.add(minePack);
        panel.add(back);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(450, 400));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setIconImage(new ImageIcon("DATA/textures/shop.png").getImage());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            frame.dispose();
            new SelectGameModeWindow();
        }
    }
}
