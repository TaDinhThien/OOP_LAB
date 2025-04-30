// File: AddBookToStoreScreen.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();

        if (title.isEmpty() || category.isEmpty() || costStr.isEmpty()) {
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

        Book newBook = new Book(title, category, cost);
        store.addMedia(newBook);
        JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear inputs
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
    }
}
