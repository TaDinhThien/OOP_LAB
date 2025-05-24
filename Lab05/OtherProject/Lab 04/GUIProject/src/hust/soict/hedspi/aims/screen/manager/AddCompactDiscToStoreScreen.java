package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private static int cdIdCounter = 0;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); // 6 fields + button

        // Create labels and text fields
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();

        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthField = new JTextField();

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        // Add button
        JButton addButton = new JButton("Add CD");
        addButton.addActionListener((ActionEvent e) -> {
            try {
                String title = titleField.getText().trim();
                String category = categoryField.getText().trim();
                float cost = Float.parseFloat(costField.getText().trim());
                String director = directorField.getText().trim();
                int length = Integer.parseInt(lengthField.getText().trim());
                String artist = artistField.getText().trim();

                int id = ++cdIdCounter;
                CompactDisc cd = new CompactDisc(id, title, category, cost, length, director, artist);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully!");
                dispose();
                new StoreManagerScreen(store);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please check your data.");
            }
        });

        // Add components to panel
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.add(titleLabel);    panel.add(titleField);
        panel.add(categoryLabel); panel.add(categoryField);
        panel.add(costLabel);     panel.add(costField);
        panel.add(directorLabel); panel.add(directorField);
        panel.add(lengthLabel);   panel.add(lengthField);
        panel.add(artistLabel);   panel.add(artistField);
        panel.add(new JLabel());  panel.add(addButton);

        return panel;
    }
}
