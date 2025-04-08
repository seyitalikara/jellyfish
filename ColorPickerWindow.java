import java.awt.*;
import javax.swing.*;

public class ColorPickerWindow extends JFrame {
    public ColorPickerWindow() {
        setTitle("Renk Seçici");
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel colorPanel = new JPanel();
        JButton colorButton = new JButton("Renk Seç");
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Renk Seçin", Color.BLACK);
            if(color != null) {
                colorPanel.setBackground(color);
            }
        });
        
        setLayout(new BorderLayout());
        add(colorPanel, BorderLayout.CENTER);
        add(colorButton, BorderLayout.SOUTH);
    }
}
