package postgresProject.views;

import exceptions.RatingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CellarView extends JFrame{
    //private JFrame frame;

    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField textRating;
    private JTextField textSeller;

    private JButton btnNewButton;
    private JButton btnShowWines;
    private JButton btnBack;

    private JLabel priceLable;
    private JLabel nameLable_1;
    private JLabel ColorLabel;
    private JLabel LableRating;

    private JTextArea textWines;
    private JComboBox<String> comboBoxPrice;

    public CellarView(){

       // frame = new JFrame();
        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setBounds(100, 100, 687, 461);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Wine");
        lblNewLabel.setForeground(new Color(139, 69, 19));
        lblNewLabel.setFont(new Font("Nanum Pen Script", Font.PLAIN, 25));
        lblNewLabel.setBounds(152, 16, 129, 59);
        this.getContentPane().add(lblNewLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(109, 87, 148, 35);
        this.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        priceLable = new JLabel("Price");
        priceLable.setForeground(new Color(139, 69, 19));
        priceLable.setBounds(36, 143, 61, 16);
        this.getContentPane().add(priceLable);

        nameLable_1 = new JLabel("Name");
        nameLable_1.setForeground(new Color(139, 69, 19));
        nameLable_1.setBounds(36, 96, 61, 16);
        this.getContentPane().add(nameLable_1);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(109, 134, 148, 35);
        this.getContentPane().add(priceTextField);

        ColorLabel = new JLabel("Color");
        ColorLabel.setForeground(new Color(139, 69, 19));
        ColorLabel.setBounds(36, 198, 61, 16);
        this.getContentPane().add(ColorLabel);

        comboBoxPrice = new JComboBox<>();
        comboBoxPrice.setForeground(new Color(139, 69, 19));
        comboBoxPrice.setModel(new DefaultComboBoxModel(new String[] {"red", "white", "pink"}));
        comboBoxPrice.setBounds(109, 194, 148, 27);
        this.getContentPane().add(comboBoxPrice);

        btnNewButton = new JButton("Add wine");
        btnNewButton.setForeground(new Color(139, 69, 19));
        btnNewButton.setBounds(109, 353, 129, 35);
        this.getContentPane().add(btnNewButton);

        textWines = new JTextArea();
        textWines.setBounds(309, 100, 340, 219);
        this.getContentPane().add(textWines);

        JScrollPane scroll = new JScrollPane(textWines);
        scroll.setBounds(316, 81, 351, 219);                     // <-- THIS
        getContentPane().add(scroll);



        btnShowWines = new JButton("Show Wines");
        btnShowWines.setForeground(new Color(139, 69, 19));
        btnShowWines.setBounds(410, 341, 129, 47);
        this.getContentPane().add(btnShowWines);

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        textRating = new JTextField();
        textRating.setColumns(10);
        textRating.setBounds(109, 243, 148, 35);
        this.getContentPane().add(textRating);

        LableRating = new JLabel("Rating");
        LableRating.setForeground(new Color(139, 69, 19));
        LableRating.setBounds(36, 252, 61, 16);
        this.getContentPane().add(LableRating);

        JLabel lblSeller = new JLabel("Seller");
        lblSeller.setForeground(new Color(139, 69, 19));
        lblSeller.setBounds(36, 306, 61, 16);
        this.getContentPane().add(lblSeller);

        textSeller = new JTextField();
        textSeller.setColumns(10);
        textSeller.setBounds(109, 290, 148, 35);
        this.getContentPane().add(textSeller);

        //this.setVisible(true);

    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public String getTextSeller(){
        return textSeller.getText();
    }

    public int getTextRating(){
        return Integer.parseInt(textRating.getText());
    }

    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }


    public JLabel getPriceLable() {
        return priceLable;
    }

    public void setPriceLable(JLabel priceLable) {
        this.priceLable = priceLable;
    }

    public JLabel getNameLable_1() {
        return nameLable_1;
    }

    public void setNameLable_1(JLabel nameLable_1) {
        this.nameLable_1 = nameLable_1;
    }

    //si la price
    public double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }
    public int getColorInt(){

       if( this.comboBoxPrice.getSelectedItem().toString().equals("red") )return 1;
       if( this.comboBoxPrice.getSelectedItem().toString().equals("white") )return 2;
    else return 3;
    }



    public void setPriceTextField(double priceTextField) {
        this.priceTextField.setText(String.valueOf(priceTextField));//il face stirng
    }

    public JLabel getColorLabel() {
        return ColorLabel;
    }

    public void setColorLabel(JLabel colorLabel) {
        ColorLabel = colorLabel;
    }


    public String getTextWines() {
        return textWines.getText();
    }

    public void setTextWines(String textWines) {
        this.textWines.setText(textWines);
    }

    public String getComboBoxPrice() {
        return Objects.requireNonNull(comboBoxPrice.getSelectedItem()).toString();
    }

    //poate aici?

    public void setComboBoxPrice(JComboBox<String> comboBoxPrice) {
        this.comboBoxPrice = comboBoxPrice;
    }

    public void addShowlistener(ActionListener action){
        btnShowWines.addActionListener(action);
    }
    public void addBackListener(ActionListener action){
        btnBack.addActionListener(action);
    }

    public void addCreateListener (ActionListener action){
        btnNewButton.addActionListener(action);
    }

    public void showErrorMessage( String message) {
        //System.out.println("failed!");
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public void showErrorLetters( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public void showErrorPrice( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshPrice();
    }

    public void showRatingMessage( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshRating();
    }

    public void refreshRating(){
        textRating.setText(null);
    }

    public void refresh(){
        nameTextField.setText(null);
        priceTextField.setText(null);
        textRating.setText(null);
        textSeller.setText(null);
    }

    public void refreshTextFiled(){
        textWines.setText(null);
    }

    public void refreshPrice(){
        priceTextField.setText(null);
    }



}
