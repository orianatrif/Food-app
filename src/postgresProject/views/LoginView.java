package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JTextField txtEmail;
    private JTextField txtName; // New field for name
    private JTextField txtSurname; // New field for surname
    private JTextField txtAge; // New field for age
    private JPasswordField txtPassword;
    private JButton btnSignUp; // Change button label to "Sign Up"
    private JLabel lblEmail;
    private JLabel lblName; // New label for name
    private JLabel lblSurname; // New label for surname
    private JLabel lblAge; // New label for age
    private JLabel lblPassword;
    private JButton btnLogin;  // New button for Login

    public LoginView() {
        // Setting up the frame
        this.setBounds(100, 100, 400, 400); // Adjust the height
        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Email Label
        lblEmail = new JLabel("Email:"); // Change label text to "Email"
        lblEmail.setBounds(50, 50, 80, 25);
        lblEmail.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(lblEmail);

        // Email Text Field
        txtEmail = new JTextField();
        txtEmail.setBounds(140, 50, 165, 25);
        this.getContentPane().add(txtEmail);

        // Name Label (New)
        lblName = new JLabel("Name:"); // Add label for name
        lblName.setBounds(50, 80, 80, 25);
        lblName.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(lblName);

        // Name Text Field (New)
        txtName = new JTextField();
        txtName.setBounds(140, 80, 165, 25);
        this.getContentPane().add(txtName);

        // Surname Label (New)
        lblSurname = new JLabel("Surname:"); // Add label for surname
        lblSurname.setBounds(50, 110, 80, 25);
        lblSurname.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(lblSurname);

        // Surname Text Field (New)
        txtSurname = new JTextField();
        txtSurname.setBounds(140, 110, 165, 25);
        this.getContentPane().add(txtSurname);

        // Age Label (New)
        lblAge = new JLabel("Age:"); // Add label for age
        lblAge.setBounds(50, 140, 80, 25);
        lblAge.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(lblAge);

        // Age Text Field (New)
        txtAge = new JTextField();
        txtAge.setBounds(140, 140, 165, 25);
        this.getContentPane().add(txtAge);

        // Password Label
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 170, 80, 25);
        lblPassword.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(lblPassword);

        // Password Text Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 170, 165, 25);
        this.getContentPane().add(txtPassword);

        // Sign Up Button (Change button label to "Sign Up")
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(100, 220, 100, 25); // Adjust the position
        btnSignUp.setForeground(new Color(139, 69, 19));
        btnSignUp.setBackground(new Color(210, 180, 140));
        this.getContentPane().add(btnSignUp);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(220, 220, 100, 25); // Adjust the position
        btnLogin.setForeground(new Color(139, 69, 19));
        btnLogin.setBackground(new Color(210, 180, 140));
        this.getContentPane().add(btnLogin);


       // this.setVisible(true);
    }

    // Methods to add action listeners
    public void addSignUpListener(ActionListener action) {
        btnSignUp.addActionListener(action);
    }

    // Getters for email, name, surname, age, and password
    public String getEmail() {
        return txtEmail.getText();
    }

    public String getName() { // Getter for name (New)
        return txtName.getText();
    }

    public String getSurname() { // Getter for surname (New)
        return txtSurname.getText();
    }

    public Integer getAge() { // Getter for age (New)
        return Integer.parseInt(txtAge.getText());
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public void addLoginListener(ActionListener action) {
        btnLogin.addActionListener(action);
    }

    // Method to clear input fields (New)
    public void clearFields() {
        txtEmail.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtAge.setText("");
        txtPassword.setText("");
    }
}
