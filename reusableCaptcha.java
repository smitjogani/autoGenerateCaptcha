import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class reusableCaptcha extends JFrame {
    private JLabel captchaLable;
    private JTextField captchaTextField;
    private JButton generateButton;
    private String generateCaptcha;

    // Create Constructer
    public reusableCaptcha() {
        setTitle("Captcha Code");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLable = new JLabel();
        captchaLable.setFont(new Font("Arial", Font.BOLD, 20));
        captchaLable.setForeground(Color.BLUE);
        captchaTextField = new JTextField(10);
        generateButton = new JButton("Generate Captcha");
        generateButton.setForeground(Color.RED);
        generateButton.setFont(new Font("Arial", Font.BOLD, 20));

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateCaptcha = generateCaptcha();
                captchaLable.setText(generateCaptcha);
            };
        });

        JPanel panel = new JPanel();
        panel.add(captchaLable);
        panel.add(captchaTextField);
        panel.add(generateButton);
        add(panel);
    }

    private String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwyz";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            captcha.append(c);
        }
        return captcha.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new reusableCaptcha().setVisible(true);
            }
        });
    }
}