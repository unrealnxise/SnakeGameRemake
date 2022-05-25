import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SkinsFrame implements ActionListener {
    JFrame frame;
    Button portalPackB;
    Button minePackB;
    Button simpPackB;
    Button sonicPackB;
    Button rickPackB;
    Button standard;
    Button back;
    SkinsFrame() {

        standard = new Button("Standard", 320, 250, 150, 150);
        standard.setForeground(Color.white);
        standard.setBackground(Color.black);
        standard.setHorizontalTextPosition(JButton.CENTER);
        standard.setVerticalTextPosition(JButton.BOTTOM);
        standard.setBorder(BorderFactory.createCompoundBorder());
        standard.setIconTextGap(10);
        standard.setIcon(new ImageIcon("DATA/textures/standartPack.png"));
        standard.addActionListener(this);
        if (Objects.equals(Bank.selectPack, "Standard")) {
            standard.setEnabled(false);
        }

        portalPackB = new Button("Portal", 20, 80, 150, 150);
        portalPackB.setForeground(Color.white);
        portalPackB.setBackground(Color.black);
        portalPackB.setHorizontalTextPosition(JButton.CENTER);
        portalPackB.setVerticalTextPosition(JButton.BOTTOM);
        portalPackB.setBorder(BorderFactory.createCompoundBorder());
        portalPackB.setIconTextGap(10);
        portalPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Portal/iconPack.png"));
        portalPackB.addActionListener(this);
        if(Bank.portalPack == 0){
            portalPackB.setEnabled(false);
        }
        if (Objects.equals(Bank.selectPack, "Portal")) {
            portalPackB.setEnabled(false);
        }

        minePackB = new Button("Minecraft", 170, 80, 150, 150);
        minePackB.setForeground(Color.white);
        minePackB.setBackground(Color.black);
        minePackB.setHorizontalTextPosition(JButton.CENTER);
        minePackB.setVerticalTextPosition(JButton.BOTTOM);
        minePackB.setBorder(BorderFactory.createCompoundBorder());
        minePackB.setIconTextGap(10);
        minePackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Minecraft/iconPack.png"));
        minePackB.addActionListener(this);
        if(Bank.minePack == 0){
            minePackB.setEnabled(false);
        }
        if (Objects.equals(Bank.selectPack, "Mine")) {
            minePackB.setEnabled(false);
        }

        rickPackB = new Button("RickAndMorty", 320, 80, 150, 150);
        rickPackB.setForeground(Color.white);
        rickPackB.setBackground(Color.black);
        rickPackB.setHorizontalTextPosition(JButton.CENTER);
        rickPackB.setVerticalTextPosition(JButton.BOTTOM);
        rickPackB.setBorder(BorderFactory.createCompoundBorder());
        rickPackB.setIconTextGap(10);
        rickPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/iconPack.png"));
        rickPackB.addActionListener(this);
        if(Bank.rickPack == 0){
            rickPackB.setEnabled(false);
        }
        if (Objects.equals(Bank.selectPack, "Rick")) {
            rickPackB.setEnabled(false);
        }

        sonicPackB = new Button("Sonic", 20, 250, 150, 150);
        sonicPackB.setForeground(Color.white);
        sonicPackB.setBackground(Color.black);
        sonicPackB.setHorizontalTextPosition(JButton.CENTER);
        sonicPackB.setVerticalTextPosition(JButton.BOTTOM);
        sonicPackB.setBorder(BorderFactory.createCompoundBorder());
        sonicPackB.setIconTextGap(10);
        sonicPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Sonic/iconPack.png"));
        sonicPackB.addActionListener(this);
        if(Bank.sonicPack == 0){
            sonicPackB.setEnabled(false);
        }
        if (Objects.equals(Bank.selectPack, "Sonic")) {
            sonicPackB.setEnabled(false);
        }

        simpPackB = new Button("Simpsons", 170, 250, 150, 150);
        simpPackB.setForeground(Color.white);
        simpPackB.setBackground(Color.black);
        simpPackB.setHorizontalTextPosition(JButton.CENTER);
        simpPackB.setVerticalTextPosition(JButton.BOTTOM);
        simpPackB.setBorder(BorderFactory.createCompoundBorder());
        simpPackB.setIconTextGap(10);
        simpPackB.setIcon(new ImageIcon("DATA/textures/skinPacks/Simpsons/iconPack.png"));
        simpPackB.addActionListener(this);
        if(Bank.simpPack == 0){
            simpPackB.setEnabled(false);
        }
        if (Objects.equals(Bank.selectPack, "Simp")) {
            simpPackB.setEnabled(false);
        }

        back = new Button("Back", 15, 500, 120, 40);
        back.setIcon(new ImageIcon("DATA/textures/classic.png"));
        back.addActionListener(this);

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 18));
        label.setText("Select your skin pack:");
        label.setBounds(170, 0, 180, 60);
        label.setLayout(null);
        label.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(label);
        panel.add(portalPackB);
        panel.add(minePackB);
        panel.add(rickPackB);
        panel.add(sonicPackB);
        panel.add(simpPackB);
        panel.add(back);
        panel.add(standard);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(500, 600));
        panel.setLayout(null);

        frame = new JFrame();
        frame.add(panel);
        frame.setIconImage(new ImageIcon("DATA/textures/skins_icon.png").getImage());
        frame.setTitle("Skins");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            new SelectGameModeWindow();
        }

        if (e.getSource() == portalPackB){
            portalPackB.setEnabled(false);
            standard.setEnabled(true);
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            if(Bank.simpPack == 1){
                simpPackB.setEnabled(true);
            }
            if(Bank.sonicPack == 1){
                sonicPackB.setEnabled(true);
            }
            if(Bank.rickPack == 1){
                rickPackB.setEnabled(true);
            }
            Bank.selectPack = "Portal";
        }

        if (e.getSource() == rickPackB){
            rickPackB.setEnabled(false);
            standard.setEnabled(true);
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            if(Bank.simpPack == 1){
                simpPackB.setEnabled(true);
            }
            if(Bank.sonicPack == 1){
                sonicPackB.setEnabled(true);
            }
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            Bank.selectPack = "Rick";
        }

        if (e.getSource() == minePackB){
            minePackB.setEnabled(false);
            standard.setEnabled(true);
            if(Bank.portalPack == 1){
                portalPackB.setEnabled(true);
            }
            if(Bank.simpPack == 1){
                simpPackB.setEnabled(true);
            }
            if(Bank.sonicPack == 1){
                sonicPackB.setEnabled(true);
            }
            if(Bank.rickPack == 1){
                rickPackB.setEnabled(true);
            }
            Bank.selectPack = "Mine";
        }

        if (e.getSource() == simpPackB){
            simpPackB.setEnabled(false);
            standard.setEnabled(true);
            if(Bank.portalPack == 1){
                portalPackB.setEnabled(true);
            }
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            if(Bank.sonicPack == 1){
                sonicPackB.setEnabled(true);
            }
            if(Bank.rickPack == 1){
                rickPackB.setEnabled(true);
            }
            Bank.selectPack = "Simp";
        }

        if (e.getSource() == sonicPackB){
            sonicPackB.setEnabled(false);
            standard.setEnabled(true);
            if(Bank.portalPack == 1){
                portalPackB.setEnabled(true);
            }
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            if(Bank.simpPack == 1){
                simpPackB.setEnabled(true);
            }
            if(Bank.rickPack == 1){
                rickPackB.setEnabled(true);
            }
            Bank.selectPack = "Sonic";
        }

        if(e.getSource()==standard){
            standard.setEnabled(false);
            if(Bank.portalPack == 1){
                portalPackB.setEnabled(true);
            }
            if(Bank.minePack == 1){
                minePackB.setEnabled(true);
            }
            if(Bank.simpPack == 1){
                simpPackB.setEnabled(true);
            }
            if(Bank.rickPack == 1){
                rickPackB.setEnabled(true);
            }
            if(Bank.sonicPack == 1){
                sonicPackB.setEnabled(true);
            }
            Bank.selectPack = "Standard";
        }
    }
}
