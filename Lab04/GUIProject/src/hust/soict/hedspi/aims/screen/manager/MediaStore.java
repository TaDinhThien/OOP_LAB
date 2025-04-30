// File: MediaStore.java
package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MediaStore extends JPanel {

    private final Media media;

    public MediaStore(Media media) {
        this.media = media;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setPreferredSize(new Dimension(240, 120));
        this.setBackground(Color.WHITE);

        JLabel title = new JLabel(this.media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", this.media.getCost()));
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        if (this.media instanceof Playable playableMedia) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener((ActionEvent e) -> {
                playableMedia.play();
                JOptionPane.showMessageDialog(this, "Playing Media", "Playing Media", JOptionPane.INFORMATION_MESSAGE);
            });
            buttonPanel.add(playButton);
        }

        this.add(Box.createVerticalStrut(10));
        this.add(title);
        this.add(Box.createVerticalStrut(5));
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(buttonPanel);
        this.add(Box.createVerticalStrut(10));
    }
}

