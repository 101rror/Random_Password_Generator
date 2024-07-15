import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomPasswordGenerator {
    private JPanel RandomPasswordGenerator;
    private JButton generateButton;
    private JButton copyButton;
    private JTextField passwordField;
    private JTextField lengthField;

    public RandomPasswordGenerator() {
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int len = Integer.parseInt(lengthField.getText());

                    if (len < 8 || len > 12) {
                        JOptionPane.showMessageDialog(null, "Please enter a length between 8 and 12");
                        return;
                    }

                    Random random = new Random();
                    String chars = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm./?!@#$%&*";

                    char[] pass = new char[len];
                    int len1 = chars.length();

                    for (int i = 0; i < len; i++) {
                        pass[i] = chars.charAt(random.nextInt(len1));
                    }

                    passwordField.setText(new String(pass));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Password copied to clipboard");
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
