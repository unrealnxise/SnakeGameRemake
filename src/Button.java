import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    Button(String t, int x, int y, int width, int height) {
        setFocusable(false);
        setFont(new Font("Ink Free", Font.BOLD, 14));
        setText(t);
        setBounds(x, y, width, height);
    }
}