import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckBoxExample implements ActionListener {
    JCheckBox checkBox = new JCheckBox("Check me!");

    public void setGUI() {
        JFrame frame = new JFrame("JCheckBox Example");
        JPanel panel = new JPanel();

        checkBox.addActionListener(this);

        panel.add(checkBox);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JCheckBoxExample example = new JCheckBoxExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            System.out.println("Checkbox checked!");
        } else {
            System.out.println("Checkbox unchecked!");
        }
    }
}
