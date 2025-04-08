import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    private JButton[] buttons = new JButton[6];
    private JFrame[] windows = new JFrame[6];
    private String[] buttonNames = {
        "Hello Penceresi",
        "Checklist Penceresi",
        "Hesap Makinesi",
        "Not Defteri",
        "Renk Seçici",
        "Zamanlayıcı"
    };

    private void openWindow(JFrame window, int index) {
        if (window != null) {
            window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setEnabled(true);
                    windows[index] = null;
                }
            });
            setEnabled(false);
            window.setVisible(true);
        }
    }

    public Main() {
        setTitle("Ana Pencere");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        for (int i = 0; i < 6; i++) {
            final int index = i;
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].addActionListener(e -> {
                if (windows[index] == null) {
                    switch (index) {
                        case 0: windows[index] = new HelloWindow(); break;
                        case 1: windows[index] = new ChecklistWindow(); break;
                        case 2: windows[index] = new CalculatorWindow(); break;
                        case 3: windows[index] = new NotesWindow(); break;
                        case 4: windows[index] = new ColorPickerWindow(); break;
                        case 5: windows[index] = new TimerWindow(); break;
                    }
                    openWindow(windows[index], index);
                }
            });
            buttonPanel.add(buttons[i]);
        }
        
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
