import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Side {
    private static Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    private static int colorIndex = 0;

    public static void main(String[] args) {
        // Ana pencereyi oluştur
        JFrame frame = new JFrame("Hello World Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
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
                // Yeni pencere oluştur
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

        // Panelleri frame'e ekle
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);

        // Ana pencereyi görünür yap
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}