package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorView extends JFrame {

    private JFrame frame;
    private JComboBox comboBox;
    private JLabel lblColor;
    private JTextArea textArea;

    private JButton btnBack;
    private JButton btnShowWines;


    public ColorView(){

        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setBounds(100, 100, 598, 407);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblColorTitle = new JLabel("Select wine based on color");
        lblColorTitle.setForeground(new Color(139, 69, 19));
        lblColorTitle.setFont(new Font("Nanum Pen Script", Font.PLAIN, 33));
        lblColorTitle.setBounds(147, 6, 326, 64);
        this.getContentPane().add(lblColorTitle);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"red", "white", "pink"}));
        comboBox.setForeground(new Color(139, 69, 19));
        comboBox.setBounds(43, 157, 146, 35);
        this.getContentPane().add(comboBox);

        lblColor = new JLabel("Select:");
        lblColor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblColor.setForeground(new Color(139, 69, 19));
        lblColor.setBounds(64, 112, 139, 26);
        this.getContentPane().add(lblColor);

        textArea = new JTextArea();
        textArea.setBounds(232, 90, 346, 226);
        this.getContentPane().add(textArea);

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        btnShowWines = new JButton("Show Wines");
        btnShowWines.setBounds(57, 236, 146, 49);
        btnShowWines.setForeground(new Color(139, 69, 19));
        this.getContentPane().add(btnShowWines);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }
    public void addFromColorToMainListener(ActionListener action){
        btnBack.addActionListener(action);
    }

    public void addShowByColorListener(ActionListener action){
        btnShowWines.addActionListener(action);
    }

    public int getColorInt(){
        if(this.comboBox.getSelectedItem().toString().equals("red")) return 1;
        if(this.comboBox.getSelectedItem().toString().equals("white")) return 2;
        return 3;

    }
}
