import javax.swing.*;

public class RandomPasswordGenerator {
    private JPanel RandomPasswordGenerator;
    private JButton generateButton;
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Password Generator");
        frame.setContentPane(new RandomPasswordGenerator().RandomPasswordGenerator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
