package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectView extends JFrame {

    private JButton btnFood, btnWines, btnLogin;
    private JLabel imageLabel;
    private JLabel chooseFoodLabel; // Label for "Choose food based on the wine you bought:"

    public SelectView() {
        setTitle("SelectView");
        setBounds(100, 100, 700, 550); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 228, 196));
        getContentPane().setLayout(null);

        // Add the label "Choose food based on the wine you bought:"
        chooseFoodLabel = new JLabel("Choose food based on the wine you bought:");
        chooseFoodLabel.setForeground(new Color(139, 69, 19));
        chooseFoodLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        chooseFoodLabel.setBounds(150, 320, 400, 30); // Positioning above the buttons
        getContentPane().add(chooseFoodLabel);

        btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(139, 69, 19));
        btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnLogin.setBounds(this.getWidth() - 150, 10, 100, 30); // Positioning at the top right
        this.getContentPane().add(btnLogin);

        // Load and set the image on top
        ImageIcon originalIcon = new ImageIcon("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/istockphoto-1316145932-612x612.jpg");
        Image image = originalIcon.getImage();
        Image newImg = image.getScaledInstance(600, 300, Image.SCALE_SMOOTH);
        ImageIcon smallIcon = new ImageIcon(newImg);
        imageLabel = new JLabel(smallIcon);
        imageLabel.setBounds(50, 10, smallIcon.getIconWidth(), smallIcon.getIconHeight());
        getContentPane().add(imageLabel);

        // Set up buttons
        btnFood = createButton("FOOD", 150, 400, 100, 50);
        btnWines = createButton("WINES", 450, 400, 100, 50);

        // Set up login button
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setForeground(new Color(139, 69, 19));
        button.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        button.setBounds(x, y, width, height);
        getContentPane().add(button);
        return button;
    }

    public void addLoginListener(ActionListener action) {
        btnLogin.addActionListener(action);
    }

    public void addFromSelectToMain(ActionListener action) {
        btnWines.addActionListener(action);
    }

    public void addFromSelectToFood(ActionListener action) {
        btnFood.addActionListener(action);
    }
}
