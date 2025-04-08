import javax.swing.*;

public class NewWindow extends JFrame {
    public NewWindow() {
        setTitle("Yeni Pencere");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Hello");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}
