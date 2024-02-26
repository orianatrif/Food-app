package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodView extends JFrame {

    private int totalCalories = 0;
    private JLabel totalCaloriesLabel;
    private JButton btnBack;
    private JScrollPane scrollPane;
    private JPanel mainPanel; // Panel to hold all components
     private JLabel titleLabel; // Label for the title

    public FoodView() {
        setTitle("Calculate Calories");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 1000)); // Set a preferred size larger than JFrame
        mainPanel.setBackground(new Color(255, 228, 196));

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        mainPanel.add(btnBack);

         titleLabel = new JLabel("Add dish and calculate calories");
        titleLabel.setForeground(new Color(139, 69, 19));
        titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        titleLabel.setBounds(200, 20, 400, 30); // Positioning at the top
        mainPanel.add(titleLabel);

        // Total calories label
        totalCaloriesLabel = new JLabel("Calories: 0");
        totalCaloriesLabel.setForeground(new Color(139, 69, 19));
        totalCaloriesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        totalCaloriesLabel.setBounds(650, 20, 150, 30);
        mainPanel.add(totalCaloriesLabel);

        // Add food items
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/ramen.jpg", "Ramen", 450, "Delicious Japanese noodle soup. For a delicious Japanese noodle soup, white wines are generally the preferred choice due to their ability to complement the dish's flavors and textures.", 50, 100);
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/burger.jpg", "Burger", 700, "Pairing a classic beef burger with red wine is a natural choice. The robust flavors of a perfectly cooked patty harmonize beautifully with the tannins and fruitiness found in red wines.", 300, 100);
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/salad.jpg", "Salad", 300, "Healthy green salad. This crisp and refreshing white wine pairs well with salads that have citrus-based dressings or ingredients like goat cheese and herbs.", 550, 100);
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/shrimp.jpeg", "Shrimp Scampi", 400, "Scrumptious shrimp scampi with garlic and lemon sauce. Shrimp scampi with garlic and lemon sauce is a flavorful and zesty dish, and it pairs well with several types of wine, especially with white wine", 50, 400); // Adjust Y value
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/watermelon-salad.jpg", "Watermelon Feta Salad", 250, "Refreshing watermelon feta salad with mint and balsamic reduction is perfect with rose wine", 300, 400); // Adjust Y value
        addFoodItem("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/sushi.jpg", "Sushi", 350, "Delightful assortment of sushi rolls and sashimi.  Its bright acidity and citrusy notes can complement the clean and fresh taste of raw fish - white wine", 550, 400); // Adjust Y value

        // Scroll pane for the entire FoodView
//        scrollPane = new JScrollPane(getContentPane());
//        setContentPane(scrollPane);

        scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setContentPane(scrollPane);

        //setVisible(true);
    }

   private void addFoodItem(String imagePath, String foodName, int calories, String description, int x, int y) {
        // Image label
        ImageIcon foodIcon = new ImageIcon(imagePath);
        JLabel foodLabel = new JLabel(new ImageIcon(foodIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        foodLabel.setBounds(x, y, 200, 150);
        mainPanel.add(foodLabel);

        // Description scroll pane with text area
        JTextArea descriptionText = new JTextArea(foodName + ": " + description + "\nCalories: " + calories);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setLineWrap(true);
        descriptionText.setEditable(false);
        descriptionText.setForeground(new Color(139, 69, 19));
        descriptionText.setBackground(new Color(255, 228, 196)); // Same as background color of the frame

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionText);
        descriptionScrollPane.setBounds(x, y + 160, 200, 80); // Adjust height as needed
        mainPanel.add(descriptionScrollPane);

        // Add button
        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(139, 69, 19));
        addButton.setBounds(x, y + 240, 200, 30); // Adjust Y position as needed
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalCalories += calories;
                totalCaloriesLabel.setText("Calories: " + totalCalories);
            }
        });
        mainPanel.add(addButton);
    }

    public void addGoBackListener(ActionListener action) {
        btnBack.addActionListener(action);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FoodView frame = new FoodView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
