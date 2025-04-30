// File: AddCompactDiscToStoreScreen.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private final JTextField tfArtist = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add Compact Disc");

        // Thêm field artist vào form
        addArtistField();
    }

    private void addArtistField() {
        // Chèn artist vào giữa category và cost
        JPanel formPanel = (JPanel) getContentPane().getComponent(1);
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Artist:"));
        formPanel.add(tfArtist);

        revalidate();
        repaint();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String artist = tfArtist.getText().trim();
        String costStr = tfCost.getText().trim();

        if (title.isEmpty() || category.isEmpty() || artist.isEmpty() || costStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        float cost;
        try {
            cost = Float.parseFloat(costStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CompactDisc newCD = new CompactDisc(title, category, artist, cost);
        store.addMedia(newCD);

        JOptionPane.showMessageDialog(this, "Compact Disc added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        tfTitle.setText("");
        tfCategory.setText("");
        tfArtist.setText("");
        tfCost.setText("");
    }
}
