import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPasswordFieldExample implements ActionListener {
    JPasswordField passwordField = new JPasswordField(20);
    JButton submitButton = new JButton("Submit");

    public void setGUI() {
        JFrame frame = new JFrame("JPasswordField Example");
        JPanel panel = new JPanel();

        submitButton.addActionListener(this);

        panel.add(new JLabel("Enter password: "));
        panel.add(passwordField);
        panel.add(submitButton);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JPasswordFieldExample example = new JPasswordFieldExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            // Dla bezpieczeństwa zaleca się używać metod obsługujących char[]
            // jednakże w celach edukacyjnych używamy konwersji do String
            JOptionPane.showMessageDialog(null, "Entered password: " + password);
        }
    }
}
