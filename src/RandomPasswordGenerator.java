import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class RandomPasswordGenerator {
    private JPanel RandomPasswordGenerator;
    private JButton generateButton;
    private JTextField textField1;

    public RandomPasswordGenerator() {
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Random random = new Random();
                String chars = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm./?!@#$%&*";
                int len = random.nextInt(8, 13);

                char[] pass = new char[len];
                int len1 = chars.length();

                for(int i = 0; i < len; i++){
                    pass[i] = chars.charAt(random.nextInt(len1));
                }

                textField1.setText(new String(pass));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Password Generator");

        ImageIcon icon = new ImageIcon("src/icon.png");
        Image originalImage = icon.getImage();

        Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        frame.setIconImage(resizedImage);

        frame.setContentPane(new RandomPasswordGenerator().RandomPasswordGenerator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
