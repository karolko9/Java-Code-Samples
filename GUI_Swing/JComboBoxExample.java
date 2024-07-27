import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxExample implements ActionListener {
    String[] options = {"Option 1", "Option 2", "Option 3"};
    JComboBox<String> comboBox = new JComboBox<>(options);

    public void setGUI() {
        JFrame frame = new JFrame("JComboBox Example");
        JPanel panel = new JPanel();

        comboBox.addActionListener(this);

        panel.add(comboBox);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JComboBoxExample example = new JComboBoxExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) comboBox.getSelectedItem();
        System.out.println("Selected option: " + selectedOption);
    }
}
