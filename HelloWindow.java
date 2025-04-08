import java.awt.*;
import javax.swing.*;

public class HelloWindow extends JFrame {
    public HelloWindow() {
        setTitle("Hello Penceresi");
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Merhaba!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);
    }
}
