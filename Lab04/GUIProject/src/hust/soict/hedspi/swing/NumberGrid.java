package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private final JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private final JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        ButtonListener listener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(listener);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panel.add(btnDelete);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panel.add(btnNumbers[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panel.add(btnReset);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            if (src instanceof JButton btn) {
                String label = btn.getText();
                switch (label) {
                    case "DEL" -> {
                        String current = tfDisplay.getText();
                        if (!current.isEmpty()) {
                            tfDisplay.setText(current.substring(0, current.length() - 1));
                        }
                    }
                    case "C" -> tfDisplay.setText("");
                    default -> tfDisplay.setText(tfDisplay.getText() + label);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGrid::new);
    }
}
