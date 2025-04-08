import java.awt.*;
import javax.swing.*;

public class TimerWindow extends JFrame {
    public TimerWindow() {
        setTitle("Zamanlayıcı");
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout());
        JLabel timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JButton startButton = new JButton("Başlat");
        
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);
        
        add(panel);
    }
}
