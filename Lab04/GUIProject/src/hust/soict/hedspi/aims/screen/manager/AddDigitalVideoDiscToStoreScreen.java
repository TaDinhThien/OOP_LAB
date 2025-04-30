// File: AddDigitalVideoDiscToStoreScreen.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private final JTextField tfDirector = new JTextField(20);
    private final JTextField tfLength = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add Digital Video Disc");

        addExtraFields();
    }

    private void addExtraFields() {
        JPanel formPanel = (JPanel) getContentPane().getComponent(1);
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        formPanel.add(new JLabel("Director:"));
        formPanel.add(tfDirector);

        formPanel.add(new JLabel("Length (in seconds):"));
        formPanel.add(tfLength);

        revalidate();
        repaint();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        String lengthStr = tfLength.getText().trim();
        String costStr = tfCost.getText().trim();

        if (title.isEmpty() || category.isEmpty() || director.isEmpty() || lengthStr.isEmpty() || costStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int length;
        float cost;
        try {
            length = Integer.parseInt(lengthStr);
            cost = Float.parseFloat(costStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number for length or cost.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(newDVD);

        JOptionPane.showMessageDialog(this, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        tfTitle.setText("");
        tfCategory.setText("");
        tfDirector.setText("");
        tfLength.setText("");
        tfCost.setText("");
    }
}
