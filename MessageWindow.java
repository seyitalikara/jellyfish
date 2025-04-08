import java.awt.*;
import javax.swing.*;

public class MessageWindow extends JFrame {
    public MessageWindow() {
        setTitle("Mesaj Penceresi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea messageArea = new JTextArea();
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        JButton sendButton = new JButton("Gönder");
        sendButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Mesaj gönderildi!");
            messageArea.setText("");
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
    }
}
