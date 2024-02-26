package postgresProject.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JFrame frameM;
    private JButton  btnWines;
    private JLabel lblMainPage;
    private JButton btnPrice;
    private JLabel lblNewLabel;
    private JLabel lblAddWineIn;
    private JButton btnRating;
    private JButton btnColor;
    private JButton btnBuyWine;
     private JLabel imageLabel;
     private JButton btnBack;

    public MainView(){

        //frameM = new JFrame();
        this.setBounds(100, 100, 700, 650);
        this.getContentPane().setBackground(new Color(255, 228, 196));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnBack = new JButton("<-");
        btnBack.setForeground(new Color(139, 69, 19));
        btnBack.setBounds(17, 16, 61, 29);
        this.getContentPane().add(btnBack);

        btnWines = new JButton("Add wines");
        this.getContentPane().setLayout(null);
        this.getContentPane().add(btnWines);
        btnWines.setForeground(new Color(139, 69, 19));
        btnWines.setBounds(78, 375, 129, 52);
		this.getContentPane().add(btnWines);

        lblMainPage = new JLabel("Wines");
        lblMainPage.setForeground(new Color(255, 255, 255));
        lblMainPage.setBounds(302,130, 200, 44);
        lblMainPage.setFont(new Font("Nanum Pen Script", Font.PLAIN, 41));
        this.getContentPane().add(lblMainPage);

        btnPrice = new JButton("Price");
        btnPrice.setForeground(new Color(139, 69, 19));
        btnPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnPrice.setBackground(new Color(139, 69, 19));
        btnPrice.setBounds(399, 360, 129, 47);
		this.getContentPane().add(btnPrice);

        lblNewLabel = new JLabel("Find wine based on:");
        lblNewLabel.setForeground(new Color(139, 69, 19));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblNewLabel.setBounds(367, 330, 219, 16);
		this.getContentPane().add(lblNewLabel);

        btnRating = new JButton("Rating");
        btnRating.setForeground(new Color(139, 69, 19));
        btnRating.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnRating.setBounds(399, 420, 129, 47);
        this.getContentPane().add(btnRating);

        btnColor = new JButton("Color");
        btnColor.setForeground(new Color(139, 69, 19));
        btnColor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnColor.setBounds(399, 480, 129, 47);
        this.getContentPane().add(btnColor);

        btnBuyWine = new JButton("Buy wine");
        btnBuyWine.setForeground(new Color(139, 69, 19));
        btnBuyWine.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnBuyWine.setBounds(78, 460, 129, 61);

		this.getContentPane().add(btnBuyWine);

//        lblClickHereTo = new JLabel("Click here to buy wine:");
//        lblClickHereTo.setForeground(new Color(139, 69, 19));
//        lblClickHereTo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//        lblClickHereTo.setBounds(76, 240, 214, 29);
//        this.getContentPane().add(lblClickHereTo);

        lblAddWineIn = new JLabel("Add wine in cellar:");
        lblAddWineIn.setForeground(new Color(139, 69, 19));
        lblAddWineIn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblAddWineIn.setBounds(88, 326, 167, 29);
        this.getContentPane().add(lblAddWineIn);



         ImageIcon originalIcon = new ImageIcon("/Users/triforiana/Documents/facultate/scs/proiect/wineCellar/wines.png"); // Replace with your image path
        Image image = originalIcon.getImage(); // Convert ImageIcon to Image
        Image newimg = image.getScaledInstance(600, 300,  java.awt.Image.SCALE_SMOOTH); // Scale it to smaller size
        ImageIcon smallIcon = new ImageIcon(newimg);  // Convert back to ImageIcon

        //int yOffset = imageIcon.getIconHeight() + 20; // Offset for the buttons

        JLabel imageLabel = new JLabel(smallIcon);
        int imageYPos = 10; // Adjust this value as needed to move the image up or down
        imageLabel.setBounds(50, imageYPos, smallIcon.getIconWidth(), smallIcon.getIconHeight());
        this.getContentPane().add(imageLabel);

        //addImageLabel(50, 170, smallIcon);  // Adjust x, y positions accordingly
       //addImageLabel(200, 170, smallIcon); // Repeat for each component
 int yOffset = imageYPos + smallIcon.getIconHeight() + 20; // Adjust the space between image and buttons
        //this.setVisible(true);

    }

    private void addImageLabel(int x, int y, ImageIcon icon) {
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        this.getContentPane().add(imageLabel);
    }

    public JFrame getFrameM() {
        return frameM;
    }

    public void setFrameM(JFrame frameM) {
        this.frameM = frameM;
    }

    public void  addToWines(ActionListener action){
        btnWines.addActionListener(action);
    }

    public void addFromMainToPriceListener( ActionListener action){
        btnPrice.addActionListener(action);
    }

    public void addFromMainToRatingListener(ActionListener action){
        btnRating.addActionListener(action);
    }

    public void addFromMainToColorListener( ActionListener action){
        btnColor.addActionListener(action);
    }

    public void addFromMainToShopListener(ActionListener action){
        btnBuyWine.addActionListener(action);
    }

    public void addBackListener(ActionListener action){
        btnBack.addActionListener(action);
    }

}
