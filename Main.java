package jellyfish;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    private static int colorIndex = 0;

    public static void main(String[] args) {
        // Ana pencereyi oluştur
        JFrame frame = new JFrame("Hello World Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

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

        // Bileşenleri ana pencereye ekle
        frame.add(label);
        frame.add(colorButton);
        frame.add(textButton);

        // Ana pencereyi görünür yap
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}