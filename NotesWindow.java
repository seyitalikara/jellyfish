import javax.swing.*;

public class NotesWindow extends JFrame {
    public NotesWindow() {
        setTitle("Not Defteri");
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea();
        add(new JScrollPane(textArea));
    }
}
