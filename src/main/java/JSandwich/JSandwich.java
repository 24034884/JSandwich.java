package JSandwich;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSandwich extends JFrame {

    private JList<String> ingredientList;
    private JList<String> breadList;
    private JLabel priceLabel;

    public JSandwich() {

        setTitle("Sublime Sandwich Shop");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("SUBLIME SANDWICH SHOP");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Sandwich ingredients
        String[] ingredients = {
            "Chicken - R25.00",
            "Beef - R30.00",
            "Cheese - R20.00"
        };

        ingredientList = new JList<>(ingredients);
        ingredientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Bread types
        String[] breads = {
            "White Bread",
            "Brown Bread",
            "Rye Bread"
        };

        breadList = new JList<>(breads);
        breadList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Labels
        JLabel ingredientLabel = new JLabel("Choose Sandwich Ingredient:");
        JLabel breadLabel = new JLabel("Choose Bread:");

        // Calculate button
        JButton calculateButton = new JButton("Calculate Price");

        priceLabel = new JLabel("Price: R0.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Button action
        calculateButton.addActionListener((ActionEvent e) -> {
            int selected = ingredientList.getSelectedIndex();
            
            if (selected == -1) {
                JOptionPane.showMessageDialog(
                        JSandwich.this,
                        "Please select a sandwich ingredient."
                );
                return;
            }
            
            double price = 0;
            
            if (selected == 0) {
                price = 25.00;
            } else if (selected == 1) {
                price = 30.00;
            } else if (selected == 2) {
                price = 20.00;
            }
            
            priceLabel.setText(String.format("Price: R%.2f", price));
        });

        // Panels
        JPanel ingredientPanel = new JPanel(new BorderLayout());
        ingredientPanel.add(ingredientLabel, BorderLayout.NORTH);
        ingredientPanel.add(new JScrollPane(ingredientList), BorderLayout.CENTER);

        JPanel breadPanel = new JPanel(new BorderLayout());
        breadPanel.add(breadLabel, BorderLayout.NORTH);
        breadPanel.add(new JScrollPane(breadList), BorderLayout.CENTER);

        JPanel selectionPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        selectionPanel.add(ingredientPanel);
        selectionPanel.add(breadPanel);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(calculateButton);
        bottomPanel.add(priceLabel);

        // Main layout
        setLayout(new BorderLayout(15, 15));

        add(titleLabel, BorderLayout.NORTH);
        add(selectionPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new JSandwich().setVisible(true);
        });
    }
}

