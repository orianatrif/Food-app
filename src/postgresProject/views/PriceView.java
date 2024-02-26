package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PriceView extends JFrame {

    private JFrame frame;
    private JLabel lblPriceTitle;
    private JLabel lblPrice;

    private JComboBox comboBox;

    private JTextArea textArea;

    private JButton btnBack;
    private JButton btnShowWines;
    


    public PriceView(){

        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setBounds(100, 100, 598, 407);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);


        lblPriceTitle = new JLabel("Select wine based on price");
        lblPriceTitle.setForeground(new Color(139, 69, 19));
        lblPriceTitle.setFont(new Font("Nanum Pen Script", Font.PLAIN, 33));
        lblPriceTitle.setBounds(151, 18, 359, 64);
        this.getContentPane().add(lblPriceTitle);

        comboBox = new JComboBox();
        comboBox.setForeground(new Color(139, 69, 19));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"cheap", "afordable", "medium", "expensive", "premium"}));
        comboBox.setBounds(43, 157, 146, 35);
        this.getContentPane().add(comboBox);

        lblPrice = new JLabel("Select:");
        lblPrice.setForeground(new Color(139, 69, 19));
        lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblPrice.setBounds(50, 101, 84, 35);
        this.getContentPane().add(lblPrice);

        textArea = new JTextArea();
        textArea.setBounds(232, 90, 346, 226);
        this.getContentPane().add(textArea);
       // scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //this.add(scroll);


        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        btnShowWines = new JButton("Show Wines");
        btnShowWines.setForeground(new Color(139, 69, 19));
        btnShowWines.setBounds(43, 222, 146, 49);
        this.getContentPane().add(btnShowWines);



    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getLblPriceTitle() {
        return lblPriceTitle;
    }

    public void setLblPriceTitle(JLabel lblPriceTitle) {
        this.lblPriceTitle = lblPriceTitle;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public void setLblPrice(JLabel lblPrice) {
        this.lblPrice = lblPrice;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void addGoBackListener(ActionListener action){
        btnBack.addActionListener(action);
    }
    public void addShowByPriceListener(ActionListener action){
        btnShowWines.addActionListener(action);
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public int getPriceInt(){
        if(this.comboBox.getSelectedItem().toString().equals("afordable")) return 1;
        if(this.comboBox.getSelectedItem().toString().equals("medium")) return 2;
        if(this.comboBox.getSelectedItem().toString().equals("expensive")) return 3;
        if(this.comboBox.getSelectedItem().toString().equals("premium")) return 4;
        else return 5;
    }

    public void refreshTextField(){
        textArea.setText(null);
    }


}
