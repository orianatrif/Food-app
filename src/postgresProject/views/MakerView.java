package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MakerView extends JFrame {

    private JFrame frame;
    private JTextField textField;

    private JLabel lblNewLabel;
    private JButton btnBack;

    public MakerView (){

        this.setBounds(100, 100, 570, 417);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        lblNewLabel = new JLabel("Our best winemakers are:");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel.setBounds(49, 54, 252, 49);
        this.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(44, 135, 340, 199);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        btnBack = new JButton("<-");
        btnBack.setBounds(16, 13, 69, 29);
        this.getContentPane().add(btnBack);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLblNewLabel() {
        return lblNewLabel;
    }

    public void setLblNewLabel(JLabel lblNewLabel) {
        this.lblNewLabel = lblNewLabel;
    }

    public void addFromMakerToMainListener(ActionListener action){
        btnBack.addActionListener(action);
    }
}
