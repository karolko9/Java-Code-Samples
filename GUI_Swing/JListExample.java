import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListExample implements ActionListener {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> myList = new JList<>(listModel);

    public void setGUI() {
        JFrame frame = new JFrame("JList Example");
        JPanel panel = new JPanel();

        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(myList);
        panel.add(scrollPane);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(this);
        panel.add(addButton);

        JButton removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(this);
        panel.add(removeButton);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JListExample example = new JListExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Item")) {
            String newItem = JOptionPane.showInputDialog("Enter new item:");
            if (newItem != null && !newItem.trim().isEmpty()) {
                listModel.addElement(newItem);
            }
        } else if (e.getActionCommand().equals("Remove Selected")) {
            int selectedIndex = myList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }
}
