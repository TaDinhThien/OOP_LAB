// File: AddItemToStoreScreen.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;
    protected final JTextField tfTitle = new JTextField(20);
    protected final JTextField tfCategory = new JTextField(20);
    protected final JTextField tfCost = new JTextField(20);

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Add Item");
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        north.add(Box.createVerticalStrut(10));
        north.add(header);
        north.add(Box.createVerticalStrut(10));

        return north;
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        panel.add(new JLabel("Title:"));
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        panel.add(tfCategory);

        panel.add(new JLabel("Cost:"));
        panel.add(tfCost);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addItem());

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            StoreManagerScreen screen = new StoreManagerScreen(store);
            screen.setVisible(true);
            dispose();
        });

        panel.add(btnBack);
        panel.add(btnAdd);
        return panel;
    }

    // Lớp con phải implement phương thức này để xử lý khi click "Add"
    protected abstract void addItem();
}

