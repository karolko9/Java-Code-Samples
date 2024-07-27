import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSpinnerExample implements ActionListener {
    JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

    public void setGUI() {
        JFrame frame = new JFrame("JSpinner Example");
        JPanel panel = new JPanel();

        JButton getValueButton = new JButton("Get Value");
        getValueButton.addActionListener(this);

        panel.add(spinner);
        panel.add(getValueButton);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JSpinnerExample example = new JSpinnerExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Get Value")) {
            int value = (int) spinner.getValue();
            JOptionPane.showMessageDialog(null, "Selected value: " + value);
        }
    }
}
