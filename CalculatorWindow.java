import java.awt.*;
import javax.swing.*;

public class CalculatorWindow extends JFrame {
    public CalculatorWindow() {
        setTitle("Hesap Makinesi");
        setSize(300, 400);
        setLocationRelativeTo(null);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        for(String label : buttonLabels) {
            buttonPanel.add(new JButton(label));
        }
        
        setLayout(new BorderLayout());
        add(new JTextField(), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
