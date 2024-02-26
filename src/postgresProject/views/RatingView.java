package postgresProject.views;

import exceptions.RatingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RatingView extends JFrame {

    private JFrame frame;
    private JLabel lblRatingTitle;
    private JLabel lblPrice;

    private JTextField textRating;
    private JTextArea textArea;

    private JButton btnBack;
    private JButton btnShowWines;


    public RatingView(){

        this.setBounds(100, 100, 598, 407);
        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setBounds(100, 100, 598, 407);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);


        lblRatingTitle = new JLabel("Select wine based on rating");
        lblRatingTitle.setForeground(new Color(139, 69, 19));
        lblRatingTitle.setFont(new Font("Nanum Pen Script", Font.PLAIN, 33));
        lblRatingTitle.setBounds(147, 6, 357, 64);
        this.getContentPane().add(lblRatingTitle);

        lblPrice = new JLabel("Insert rating:");
        lblPrice.setForeground(new Color(139, 69, 19));
        lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblPrice.setBounds(64, 112, 139, 26);
        this.getContentPane().add(lblPrice);

        textArea = new JTextArea();
        textArea.setBounds(238, 82, 341, 233);
        this.getContentPane().add(textArea);

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        btnShowWines = new JButton("Show Wines");
        btnShowWines.setForeground(new Color(139, 69, 19));
        btnShowWines.setBounds(57, 236, 146, 49);
        this.getContentPane().add(btnShowWines);

        textRating = new JTextField();
        textRating.setBounds(82, 149, 74, 40);
        this.getContentPane().add(textRating);
        textRating.setColumns(10);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getLblRatingTitle() {
        return lblRatingTitle;
    }

    public void setLblRatingTitle(JLabel lblRatingTitle) {
        this.lblRatingTitle = lblRatingTitle;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public void setLblPrice(JLabel lblPrice) {
        this.lblPrice = lblPrice;
    }

    public int getTextRating(){
        return Integer.parseInt(textRating.getText());
    }


    public void setTextRating(JTextField textRating) {
        this.textRating = textRating;
    }

    public void setTextWines(String textWines) {
        this.textArea.setText(textWines);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public void addFromRatingToMainListener(ActionListener action){
        btnBack.addActionListener(action);
    }

    public void addShowWinesByRatingListener (ActionListener action){
        btnShowWines.addActionListener(action);
    }


    public void refreshRating(){
        textRating.setText(null);
    }
    public void showRatingMessage2( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshRating();
    }
    public void refreshTextField(){
        textArea.setText(null);
    }



}
