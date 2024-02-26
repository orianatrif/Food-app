package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstView extends JFrame {

    private JButton btnStartApp;
    private JLabel backgroundImageLabel;

    public FirstView() {
        setTitle("FirstView");
        setBounds(100, 100, 600, 550); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Set up the background image
        ImageIcon backgroundIcon = new ImageIcon("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/first.jpeg");
        backgroundImageLabel = new JLabel(backgroundIcon);
        backgroundImageLabel.setBounds(0, 0, this.getWidth(), this.getHeight()); // Cover the entire frame
        getContentPane().add(backgroundImageLabel);

        // Set up the "Start App" button
        btnStartApp = new JButton("Start App");
        btnStartApp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnStartApp.setBounds(200, 250, 200, 50); // Centrally located
        backgroundImageLabel.add(btnStartApp); // Add the button to the label

        setVisible(true);
    }

    // Method to add an ActionListener to the Start App button
    public void addStartAppListener(ActionListener action) {
        btnStartApp.addActionListener(action);
    }

    // Main method for testing
//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            try {
//                FirstView window = new FirstView();
//                window.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
