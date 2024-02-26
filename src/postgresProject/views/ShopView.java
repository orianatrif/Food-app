package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShopView extends JFrame {

    private JFrame frame;

    private JTextField textName;
    private JTextField textQuantity;

    private JTextArea textWines;
    private JTextArea textTotal;

    private JButton btnClear;
    private JButton btnShowWines;
    private JButton btnBack;
    private JButton btnTotal;

    public JLabel lblNewLabel;
    private JLabel lblId;
    private JLabel lblQuantity;
    private JLabel lblNewLabel_1;



    public ShopView(){

        //frame = new JFrame();
        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setBounds(100, 100, 694, 463);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        lblNewLabel = new JLabel("Wine Shop");
        lblNewLabel.setForeground(new Color(139, 69, 19));
        lblNewLabel.setFont(new Font("Nanum Pen Script", Font.PLAIN, 35));
        lblNewLabel.setBounds(262, 16, 178, 72);
        this.getContentPane().add(lblNewLabel);

        btnClear = new JButton("Clear");
        btnClear.setForeground(new Color(139, 69, 19));
        btnClear.setBounds(117, 348, 129, 35);
        this.getContentPane().add(btnClear);

        textWines = new JTextArea();
        textWines.setBounds(309, 100, 340, 219);
        this.getContentPane().add(textWines);

        JScrollPane scroll = new JScrollPane(textWines);
        scroll.setBounds(316, 81, 351, 219);                     // <-- THIS
        getContentPane().add(scroll);

        btnShowWines = new JButton("Show Wines");
        btnShowWines.setForeground(new Color(139, 69, 19));
        btnShowWines.setBounds(441, 342, 129, 47);
        this.getContentPane().add(btnShowWines);

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        lblId = new JLabel("Name");
        lblId.setForeground(new Color(139, 69, 19));
        lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblId.setBounds(39, 113, 62, 16);
        this.getContentPane().add(lblId);

        textName = new JTextField();
        textName.setBounds(116, 101, 130, 41);
        this.getContentPane().add(textName);
        textName.setColumns(10);

        textQuantity = new JTextField();
        textQuantity.setColumns(10);
        textQuantity.setBounds(118, 157, 130, 41);
        this.getContentPane().add(textQuantity);

        lblQuantity = new JLabel("Quantity");
        lblQuantity.setForeground(new Color(139, 69, 19));
        lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblQuantity.setBounds(39, 172, 84, 16);
        this.getContentPane().add(lblQuantity);

        btnTotal = new JButton("Compute Total");
        btnTotal.setForeground(new Color(139, 69, 19));

        btnTotal.setBounds(116, 224, 129, 35);
        this.getContentPane().add(btnTotal);

        textTotal = new JTextArea();
        textTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        textTotal.setBounds(117, 284, 129, 35);
        this.getContentPane().add(textTotal);

        lblNewLabel_1 = new JLabel("Total:");
        lblNewLabel_1.setForeground(new Color(139, 69, 19));
        lblNewLabel_1.setBounds(39, 291, 61, 16);
        this.getContentPane().add(lblNewLabel_1);


    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public String getTextName() {
        return textName.getText();
    }

    public void setTextName(JTextField textName) {
        this.textName = textName;
    }

    public int getTextQuantity() {
        return Integer.parseInt(textQuantity.getText());
    }

    public void setTextQuantity(JTextField textQuantity) {
        this.textQuantity = textQuantity;
    }

    public JTextArea getTextWines() {
        return textWines;
    }

    public void setTextWines(String textWines) {
        this.textWines.setText(textWines);
    }

    public double getTextTotal() {
        return Double.parseDouble(textTotal.getText());
    }

    public void setTextTotal(double textTotal) {
        this.textTotal.setText(String.valueOf(textTotal));
    }

    public void addFromShopToMainListener(ActionListener action){
        btnBack.addActionListener(action);
    }

    public void addShowAllWinesListener ( ActionListener action){
        btnShowWines.addActionListener(action);
    }

    public void addComputeTotalListener(ActionListener action){
        btnTotal.addActionListener(action);
    }

    public void addClearListener(ActionListener action){
        //setTextTotal(0);
        btnClear.addActionListener(action);
    }

    public void showQuantityMessage( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshQuantity();
    }

    public  void refreshQuantity(){
        textQuantity.setText(null);
    }

    public void showErrorLetters( String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshQuantity();
    }

    public void refreshName(){
        textName.setText(null);
    }

    public void refreshTextArea(){
        textWines.setText(null);
    }

    public void showErrorNoWine(String message){
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.ERROR_MESSAGE);
        refreshName();
    }



}
