import javax.swing.*;

public class ChecklistWindow extends JFrame {
    public ChecklistWindow() {
        setTitle("Checklist Penceresi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        for(int i = 1; i <= 5; i++) {
            panel.add(new JCheckBox("Görev " + i));
        }
        
        add(new JScrollPane(panel));
    }
}
