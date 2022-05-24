import javax.swing.*;
import java.awt.*;

public class ShopWindow{
    JFrame frame;

    ShopWindow(){
        JLabel label = new JLabel();
        label.setFont(new Font("Ink Free", Font.BOLD, 14));
        label.setText("Select your skin pack:");
        label.setBounds(125, 0, 140, 40);
        label.setLayout(null);
        label.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.add(label);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setLayout(null);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setTitle("Shop");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }
}
