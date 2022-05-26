import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SelectGameModeWindow implements ActionListener {
    JFrame frame;
    Button mode1;
    Button mode2;
    Button mode3;
    Button mode4;
    Button mode5;
    Button mode6;
    Button shop;
    Button wardrobe;

    SelectGameModeWindow(){
        loadData();
        shop = new Button("Shop", 135, 200, 120, 40);
        shop.setIcon(new ImageIcon("DATA/textures/shop.png"));
        shop.addActionListener(this);

        mode1 = new Button("Classic", 10, 50, 120, 40);
        mode1.setIcon(new ImageIcon("DATA/textures/classic.png"));
        mode1.addActionListener(this);

        mode2 = new Button("Portal", 135, 50, 120, 40);
        mode2.setIcon(new ImageIcon("DATA/textures/skinPacks/Portal/portalA.png"));
        mode2.addActionListener(this);

        mode3 = new Button("Sonic", 260, 50, 120, 40);
        mode3.setIcon(new ImageIcon("DATA/textures/sonic.png"));
        mode3.addActionListener(this);

        mode4 = new Button("Minecraft", 70, 100, 120, 40);
        mode4.setFont(new Font("Ink Free", Font.BOLD, 12));
        mode4.setIcon(new ImageIcon("DATA/textures/pickaxe.png"));
        mode4.addActionListener(this);

        mode5 = new Button("Block Mode", 200, 100, 120, 40);
        mode5.setIcon(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png"));
        mode5.setFont(new Font("Ink Free", Font.BOLD, 10));
        mode5.addActionListener(this);

        wardrobe = new Button("Skins", 135, 245, 120, 40);
        wardrobe.setIcon(new ImageIcon("DATA/textures/skins_icon.png"));
        wardrobe.addActionListener(this);

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
        panel.add(shop);
        panel.add(wardrobe);
        panel.add(label);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setIconImage(new ImageIcon("DATA/textures/classic.png").getImage());
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

    public void loadData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("DATA/saves/save.txt"));
            Bank.money = Integer.parseInt(br.readLine());
            Bank.portalPack = Integer.parseInt(br.readLine());
            Bank.minePack = Integer.parseInt(br.readLine());
            Bank.rickPack = Integer.parseInt(br.readLine());
            Bank.simpPack = Integer.parseInt(br.readLine());
            Bank.sonicPack = Integer.parseInt(br.readLine());
            br.close();
        }
        catch (Exception e){
            Bank.money = 0;
            Bank.portalPack = 0;
            Bank.minePack = 0;
            Bank.rickPack = 0;
            Bank.simpPack = 0;
            Bank.sonicPack = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mode1){
            new GameFrame();
        }
        else if (e.getSource()==shop) {
                frame.dispose();
                new ShopWindow();
        }
        else if (e.getSource()==mode2) {
            new PortalFrame();
        }
        else if (e.getSource()==mode3) {
            new SonicModeFrame();
        }
        else if (e.getSource()==mode4) {
            new MineFrame();
        }
        else if (e.getSource()==mode5) {
            new BlockModeFrame();
        }
        if(e.getSource() == wardrobe){
            frame.dispose();
            new SkinsFrame();
        }
    }
}
