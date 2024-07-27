import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonExample implements ActionListener {
    JButton button = new JButton("Click me!");

    public void setGUI() {
        JFrame frame = new JFrame("JButton Example");
        JPanel panel = new JPanel();

        button.addActionListener(this);

        panel.add(button);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JButtonExample example = new JButtonExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
}
