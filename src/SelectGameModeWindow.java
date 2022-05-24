import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class SelectGameModeWindow implements ActionListener {
    JPanel panel;
    JFrame frame;
    JButton mode1;
    JButton mode2;
    JButton mode3;
    JButton mode4;
    JButton mode5;
    JButton mode6;

    SelectGameModeWindow(){
        mode1 = new JButton();
        mode1.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode1.setText("Classic");
        mode1.setFocusable(false);
        mode1.setBounds(10, 50, 120, 40);
        mode1.addActionListener(this);

        mode2 = new JButton();
        mode2.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode2.setText("Portal");
        mode2.setFocusable(false);
        mode2.setBounds(135, 50, 120, 40);
        mode2.addActionListener(this);

        mode3 = new JButton();
        mode3.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode3.setText("Sonic");
        mode3.setFocusable(false);
        mode3.setBounds(260, 50, 120, 40);
        mode3.addActionListener(this);

        mode4 = new JButton();
        mode4.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode4.setText("Minecraft");
        mode4.setFocusable(false);
        mode4.setBounds(10, 100, 120, 40);
        mode4.addActionListener(this);

        mode5 = new JButton();
        mode5.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode5.setText("Block Mode");
        mode5.setFocusable(false);
        mode5.setBounds(135, 100, 120, 40);
        mode5.addActionListener(this);

        mode6 = new JButton();
        mode6.setFont(new Font("Ink Free", Font.BOLD, 14));
        mode6.setText("Danger zone");
        mode6.setFocusable(false);
        mode6.setBounds(260, 100, 120, 40);
        mode6.addActionListener(this);

        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 14));
        label.setText("Select your mode:");
        label.setBounds(140, 0, 120, 40);
        label.setLayout(null);
        label.setForeground(Color.white);

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(mode1);
        panel.add(mode2);
        panel.add(mode3);
        panel.add(mode4);
        panel.add(mode5);
        panel.add(mode6);
        panel.add(label);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);


        frame = new JFrame();
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

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = panel.getFontMetrics(g.getFont());
        g.drawString("Select your mode", 0, 0);
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
        }
    }
}
