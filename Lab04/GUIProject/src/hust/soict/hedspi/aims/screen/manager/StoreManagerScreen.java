// File: StoreManagerScreen.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

public class StoreManagerScreen extends JFrame {

    private final Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        setTitle("AIMS - Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout: NORTH -> menu+header, CENTER -> media items
        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");

        // Actions
        addBook.addActionListener((ActionEvent e) -> {
            AddBookToStoreScreen screen = new AddBookToStoreScreen(store);
            screen.setVisible(true);
            dispose();
        });

        addCD.addActionListener((ActionEvent e) -> {
            new AddCompactDiscToStoreScreen(store).setVisible(true);
            dispose();
        });

        addDVD.addActionListener((ActionEvent e) -> {
            new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
            dispose();
        });

        viewStore.addActionListener((ActionEvent e) -> {
            StoreManagerScreen screen = new StoreManagerScreen(store);
            screen.setVisible(true);
            dispose();
        });

        menu.add(viewStore);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Store Manager View");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(Box.createVerticalStrut(10));
        header.add(title);
        header.add(subtitle);
        header.add(Box.createVerticalStrut(10));

        return header;
    }

    private JScrollPane createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 5, 5)); // auto rows, 3 columns

        List<Media> mediaList = store.getItemsInStore();
        for (Media media : mediaList) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    public static void main(String[] args) {
        Store store = new Store();
        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}

