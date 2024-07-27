import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample implements ActionListener {
    JTextField textField = new JTextField(20);
    JButton submitButton = new JButton("Submit");

    public void setGUI() {
        JFrame frame = new JFrame("JTextField Example");
        JPanel panel = new JPanel();

        submitButton.addActionListener(this);

        panel.add(new JLabel("Enter text: "));
        panel.add(textField);
        panel.add(submitButton);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JTextFieldExample example = new JTextFieldExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String enteredText = textField.getText();
            JOptionPane.showMessageDialog(null, "Entered text: " + enteredText);
        }
    }
}
