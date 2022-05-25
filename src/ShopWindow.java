import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ShopWindow implements ActionListener {
    JFrame frame;
    Button portalPackB;
    Button minePackB;
    Button back;
    Button simpPackB;
    Button sonicPackB;
    Button rickPackB;
    JLabel label1;

    ShopWindow() {
        portalPackB = new Button("200$", 10, 80, 150, 150);
        portalPackB.setForeground(Color.white);
        portalPackB.setBackground(Color.black);
        portalPackB.setHorizontalTextPosition(JButton.CENTER);
        portalPackB.setVerticalTextPosition(JButton.BOTTOM);
        portalPackB.setBorder(BorderFactory.createCompoundBorder());
        portalPackB.setIconTextGap(10);
        portalPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Portal/iconPack.png"));
        portalPackB.addActionListener(this);
        if (Bank.portalPack == 1) {
            portalPackB.setEnabled(false);
        }

        minePackB = new Button("200$", 160, 80, 150, 150);
        minePackB.setForeground(Color.white);
        minePackB.setBackground(Color.black);
        minePackB.setHorizontalTextPosition(JButton.CENTER);
        minePackB.setVerticalTextPosition(JButton.BOTTOM);
        minePackB.setBorder(BorderFactory.createCompoundBorder());
        minePackB.setIconTextGap(10);
        minePackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Minecraft/iconPack.png"));
        minePackB.addActionListener(this);
        if (Bank.minePack == 1) {
            minePackB.setEnabled(false);
        }

        rickPackB = new Button("200$", 310, 80, 150, 150);
        rickPackB.setForeground(Color.white);
        rickPackB.setBackground(Color.black);
        rickPackB.setHorizontalTextPosition(JButton.CENTER);
        rickPackB.setVerticalTextPosition(JButton.BOTTOM);
        rickPackB.setBorder(BorderFactory.createCompoundBorder());
        rickPackB.setIconTextGap(10);
        rickPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/iconPack.png"));
        rickPackB.addActionListener(this);
        if (Bank.rickPack == 1) {
            rickPackB.setEnabled(false);
        }

        sonicPackB = new Button("200$", 80, 250, 150, 150);
        sonicPackB.setForeground(Color.white);
        sonicPackB.setBackground(Color.black);
        sonicPackB.setHorizontalTextPosition(JButton.CENTER);
        sonicPackB.setVerticalTextPosition(JButton.BOTTOM);
        sonicPackB.setBorder(BorderFactory.createCompoundBorder());
        sonicPackB.setIconTextGap(10);
        sonicPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Sonic/iconPack.png"));
        sonicPackB.addActionListener(this);
        if (Bank.sonicPack == 1) {
            sonicPackB.setEnabled(false);
        }

        simpPackB = new Button("200$", 260, 250, 150, 150);
        simpPackB.setForeground(Color.white);
        simpPackB.setBackground(Color.black);
        simpPackB.setHorizontalTextPosition(JButton.CENTER);
        simpPackB.setVerticalTextPosition(JButton.BOTTOM);
        simpPackB.setBorder(BorderFactory.createCompoundBorder());
        simpPackB.setIconTextGap(10);
        simpPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Simpsons/iconPack.png"));
        simpPackB.addActionListener(this);
        if (Bank.simpPack == 1) {
            simpPackB.setEnabled(false);
        }

        back = new Button("Back", 15, 500, 120, 40);
        back.setIcon(new ImageIcon("DATA/textures/classic.png"));
        back.addActionListener(this);

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 18));
        label.setText("Select your skin pack:");
        label.setBounds(150, 0, 180, 60);
        label.setLayout(null);
        label.setForeground(Color.white);

        label1 = new JLabel();
        label1.setFont(new Font("Ink Free", Font.BOLD, 18));
        label1.setText("Money: " + Bank.money);
        label1.setBounds(380, 500, 120, 40);
        label1.setLayout(null);
        label1.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(label);
        panel.add(label1);
        panel.add(portalPackB);
        panel.add(minePackB);
        panel.add(rickPackB);
        panel.add(back);
        panel.add(sonicPackB);
        panel.add(simpPackB);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(500, 600));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setIconImage(new ImageIcon("DATA/textures/shop.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setTitle("Shop");
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    public void saveData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("DATA/saves/save.txt"));
            bw.write(Integer.toString(Bank.money));
            bw.write("\n" + Integer.toString(Bank.portalPack));
            bw.write("\n" + Integer.toString(Bank.rickPack));
            bw.write("\n" + Integer.toString(Bank.minePack));
            bw.write("\n" + Integer.toString(Bank.simpPack));
            bw.write("\n" + Integer.toString(Bank.sonicPack));
            bw.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            new SelectGameModeWindow();
        }
        if (e.getSource() == portalPackB) {
            if (Bank.money >= 200) {
                portalPackB.setEnabled(false);
                Bank.money = Bank.money - 200;
                Bank.portalPack = 1;
                saveData();
                label1.setText("Money: " + Bank.money);
            } else {
                JOptionPane.showMessageDialog(null, "you don't have enough money",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == minePackB) {
            if (Bank.money >= 200) {
                minePackB.setEnabled(false);
                Bank.money = Bank.money - 200;
                Bank.minePack = 1;
                saveData();
                label1.setText("Money: " + Bank.money);
            } else {
                JOptionPane.showMessageDialog(null, "you don't have enough money",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == rickPackB) {
            if (Bank.money >= 200) {
                rickPackB.setEnabled(false);
                Bank.money = Bank.money - 200;
                Bank.rickPack = 1;
                saveData();
                label1.setText("Money: " + Bank.money);
            } else {
                JOptionPane.showMessageDialog(null, "you don't have enough money",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == sonicPackB) {
            if (Bank.money >= 200) {
                sonicPackB.setEnabled(false);
                Bank.money = Bank.money - 200;
                Bank.sonicPack = 1;
                saveData();
                label1.setText("Money: " + Bank.money);
            } else {
                JOptionPane.showMessageDialog(null, "you don't have enough money",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == simpPackB) {
            if (Bank.money >= 200) {
                simpPackB.setEnabled(false);
                Bank.money = Bank.money - 200;
                Bank.simpPack = 1;
                saveData();
                label1.setText("Money: " + Bank.money);
            } else {
                JOptionPane.showMessageDialog(null, "you don't have enough money",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}