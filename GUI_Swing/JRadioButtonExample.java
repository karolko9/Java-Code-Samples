import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonExample implements ActionListener {
    JRadioButton radioButton1 = new JRadioButton("Option 1");
    JRadioButton radioButton2 = new JRadioButton("Option 2");
    JRadioButton radioButton3 = new JRadioButton("Option 3");
    ButtonGroup buttonGroup = new ButtonGroup();

    public void setGUI() {
        JFrame frame = new JFrame("JRadioButton Example");
        JPanel panel = new JPanel();

        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton3.addActionListener(this);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JRadioButtonExample example = new JRadioButtonExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (radioButton1.isSelected()) {
            JOptionPane.showMessageDialog(null, "Option 1 selected");
        } else if (radioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Option 2 selected");
        } else if (radioButton3.isSelected()) {
            JOptionPane.showMessageDialog(null, "Option 3 selected");
        }
    }
}
