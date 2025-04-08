import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JFrame {
    public Message() {
        setTitle("Mesaj Penceresi");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("Mesaj Penceresi"));
        
        add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mesajlaşma Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Üst panel oluştur
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        // Elmas figürü için özel label
        JLabel diamondLabel = new JLabel("◆");
        diamondLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Sayı girişi için text field
        JTextField numberField = new JTextField(5);
        
        // Üst panele komponentleri ekle
        topPanel.add(diamondLabel);
        topPanel.add(numberField);

        // Alt panel oluştur
        JPanel bottomPanel = new JPanel(new FlowLayout());

        // Etiketi oluştur
        JLabel label = new JLabel("Hello World!");
        label.setFont(new Font("Arial", Font.BOLD, 24));

        // Renk değiştirme butonu
        JButton colorButton = new JButton("Rengi Değiştir");
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setForeground(colors[colorIndex]);
                colorIndex = (colorIndex + 1) % colors.length;
            }
        });

        // Yeni metin girişi butonu
        JButton textButton = new JButton("Metin Gir");
        textButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dialog penceresi oluştur
                JDialog dialog = new JDialog(frame, "Metin Girişi", true);
                dialog.setLayout(new FlowLayout());
                dialog.setSize(250, 150);
                dialog.setLocationRelativeTo(frame);

                // Metin kutusu oluştur
                JTextField textField = new JTextField(20);
                
                // Tamam butonu oluştur
                JButton okButton = new JButton("Tamam");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Ana etiketi güncelle ve pencereyi kapat
                        label.setText(textField.getText());
                        dialog.dispose();
                    }
                });

                // Bileşenleri dialog penceresine ekle
                dialog.add(textField);
                dialog.add(okButton);
                
                // Dialog penceresini görünür yap
                dialog.setVisible(true);
            }
        });

        // Bileşenleri alt panele ekle
        bottomPanel.add(label);
        bottomPanel.add(colorButton);
        bottomPanel.add(textButton);

        // Mesajlaşma alanı
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        
        // Mesaj gönderme paneli
        JPanel messagePanel = new JPanel(new BorderLayout());
        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Gönder");
        
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);

        // Gönder butonu işlevi
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (message != null && !message.trim().isEmpty()) {
                    chatArea.append(message.trim() + "\n");
                    messageField.setText("");
                }
            }
        });

        // Enter tuşu ile mesaj gönderme
        messageField.addActionListener(e -> sendButton.doClick());

        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Sol butonlar paneli
        JPanel leftButtonPanel = new JPanel(new GridLayout(3, 1, 10, 10));  // Boşluklar arttırıldı
        JButton leftButton1 = new JButton("Sol 1");
        JButton leftButton2 = new JButton("Sol 2");
        JButton leftButton3 = new JButton("Sol 3");
        leftButtonPanel.add(leftButton1);
        leftButtonPanel.add(leftButton2);
        leftButtonPanel.add(leftButton3);

        // Sağ butonlar paneli
        JPanel rightButtonPanel = new JPanel(new GridLayout(3, 1, 10, 10));  // Boşluklar arttırıldı
        JButton rightButton1 = new JButton("Sağ 1");
        JButton rightButton2 = new JButton("Sağ 2");
        JButton rightButton3 = new JButton("Sağ 3");
        rightButtonPanel.add(rightButton1);
        rightButtonPanel.add(rightButton2);
        rightButtonPanel.add(rightButton3);

        
        mainPanel.add(leftButtonPanel, BorderLayout.WEST);
        mainPanel.add(rightButtonPanel, BorderLayout.EAST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.SOUTH);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}