package postgresProject.controllers;

import exceptions.NoWineException;
import exceptions.PriceException;
import exceptions.QuantityException;
import exceptions.RatingException;
import postgresProject.DatabaseConnection;
import postgresProject.models.Cellar;
import postgresProject.models.Wine;
import postgresProject.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.NumberFormat;


public class CellarController {

    private final CellarView view;
    private final MainView viewMain;
    private final Cellar cellar;
    private final PriceView viewPrice;
    private final RatingView viewRating;
    private final ColorView viewColor;
    private final ShopView viewShop;
    private final MakerView viewMaker;
    private final LoginView loginView;
    private final FirstView firstView;
    private final SelectView selectView;
    private final FoodView foodView;

    //add here
    private final DatabaseConnection databaseConnection;

    public CellarController(CellarView view,MainView viewMain,PriceView viewPrice,RatingView viewRating, ColorView viewColor,ShopView viewShop, MakerView viewMaker, LoginView loginView, Cellar cellar, FirstView firstView, SelectView selectView, FoodView foodView,DatabaseConnection databaseConnection) {
        this.view = view;
        this.cellar = cellar;
        this.viewMain = viewMain;
        this.viewPrice = viewPrice;
        this.viewRating = viewRating;
        this.viewColor = viewColor;
        this.viewShop = viewShop;
        this.viewMaker=viewMaker;
        this.loginView = loginView;
        this.firstView = firstView;
        this.selectView = selectView;
        this.foodView = foodView;


        this.databaseConnection = databaseConnection;

        this.viewMaker.dispose();
        this.view.dispose();
        this.viewPrice.dispose();
        this.viewRating.dispose();
        this.viewColor.dispose();
        this.viewShop.dispose();
        this.viewMain.dispose();
        this.viewShop.setTextTotal(0);
       //r this.loginView.dispose();
        this.selectView.dispose();


        //this.firstView.dispose();

        //legam listenerul de buton
        this.view.addShowlistener(new SelectListener());
        this.view.addBackListener(new BackToMainListener());
        this.view.addCreateListener(new InsertListener());
        this.loginView.addSignUpListener(new SignUpInsertListener());
        this.loginView.addLoginListener(new LoginInsertListener());

        this.viewMain.addToWines(new ToWines());
        this.viewMain.addFromMainToPriceListener(new FromMainToPrice());
        this.viewMain.addFromMainToRatingListener(new FromMainToRating());
        this.viewMain.addFromMainToColorListener(new FromMainToColor());
        this.viewMain.addFromMainToShopListener(new FromMainToShop());
        this.viewMain.addBackListener(new FromMainToSelect());
        this.foodView.addGoBackListener(new FromFoodToSelect());


       // this.viewMain.addLoginListener(new ToLoginListener());
        this.selectView.addLoginListener(new ToLoginFromSelectListener());
        this.selectView.addFromSelectToMain(new FromSelectToMain());
        this.selectView.addFromSelectToFood(new FromSelectToFood());


    this.firstView.addStartAppListener(new StartAppListener());

        this.viewPrice.addGoBackListener(new FromPriceToMain());
        this.viewPrice.addShowByPriceListener(new SelectByPrice());

        this.viewRating.addFromRatingToMainListener(new FromRatingToMain());
        this.viewRating.addShowWinesByRatingListener(new SelectByRating());

        this.viewColor.addFromColorToMainListener(new FromColorToMain());
        this.viewColor.addShowByColorListener(new SelectByColor());

        this.viewShop.addFromShopToMainListener(new FromShopToMain());
        this.viewShop.addShowAllWinesListener(new allWinesinShopListener());
        this.viewShop.addComputeTotalListener(new ComputeTotal());
        this.viewShop.addClearListener(new ClearTotal());

        this.viewMaker.addFromMakerToMainListener(new FromMakerToMain());

    }

    class FromMakerToMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewMaker.dispose();
            viewMain.setVisible(true);
        }
    }
    class FromSelectToFood implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            selectView.dispose();
            foodView.setVisible(true);
        }
    }

    class FromFoodToSelect implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            foodView.dispose();
            selectView.setVisible(true);
        }
    }

     class FromMainToSelect implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewMain.dispose();
            selectView.setVisible(true);
        }
    }



    class ClearTotal implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewShop.refreshName();
            viewShop.refreshQuantity();
            viewShop.setTextTotal(0);
        }
    }

    class FromMainToShop implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           // viewShop.setTextTotal(0);
            viewMain.dispose();
            viewShop.setVisible(true);
        }
    }

    class FromShopToMain implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            viewShop.refreshTextArea();
//            viewShop.refreshQuantity();
//            viewShop.refreshName();
            //viewShop.setTextTotal(0);
            viewShop.dispose();
            viewMain.setVisible(true);
        }
    }

    class FromMainToColor implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            viewMain.dispose();
            viewColor.setVisible(true);
        }
    }

    class FromColorToMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewColor.dispose();
            viewMain.setVisible(true);
        }
    }

    class LoginInsertListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Connection connection = databaseConnection.getConnection();
            String enteredEmail = loginView.getEmail();
            String enteredPassword = loginView.getPassword();

            // Query the database to check if the email and password match
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM login2 WHERE email = ? AND pass = ?");
            preparedStatement.setString(1, enteredEmail);
            preparedStatement.setString(2, enteredPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Login successful
                loginView.clearFields();
                JOptionPane.showMessageDialog(loginView, "Login Successful");
                connection.close();
                loginView.dispose();

                // Proceed to the SelectView
                selectView.setVisible(true);
            } else {
                // Login failed, show an error message
                JOptionPane.showMessageDialog(loginView, "Invalid email or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Error during login process", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    class ToLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Hide the MainView and show the LoginView
            viewMain.dispose();
            loginView.setVisible(true);
        }
    }

    class FromMainToRating implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewMain.dispose();
            viewRating.setVisible(true);
        }
    }

    class FromRatingToMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewRating.refreshRating();
            viewRating.refreshTextField();
            viewRating.dispose();
            viewMain.setVisible(true);
        }
    }

    class FromPriceToMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrice.refreshTextField();
            viewPrice.dispose();
            viewMain.setVisible(true);
        }
    }

    class ToWines implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewMain.dispose();
            view.setVisible(true);
        }
    }

    class FromMainToPrice implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewMain.dispose();
            viewPrice.setVisible(true);
        }
    }

    class FromSelectToMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            selectView.dispose();
            viewMain.setVisible(true);
        }
    }

    class BackToMainListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            view.refreshTextFiled();
            view.dispose();
            viewMain.setVisible(true);
        }
    }
    class StartAppListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        firstView.dispose();
        selectView.setVisible(true);
    }
}


//    class CreateListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                // ne luam datele de pe view
//                String name = view.getNameTextField();
//                //System.out.println(name);
//                double price = view.getPriceTextField();
//                String color = view.getComboBoxPrice();
//
//                Wine wine = new Wine(0, name, price, color);
//                cellar.getWines().add(wine);
//            }
//            catch (Exception exception){
//                view.showErrorMessage("Bad input");
//
//            }
//        }
//    }

    class ToLoginFromSelectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        selectView.setVisible(false); // Hide SelectView
        loginView.setVisible(true);   // Show LoginView
    }
}

    class ComputeTotal implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                cellar.getWines().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * from wine1 WHERE wine_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, viewShop.getTextName());
               // badRatingCheck(viewRating.getTextRating());
                ResultSet result1 = preparedStatement.executeQuery();
                if(result1.next()==false)
                    wrongWine(0);
                else{
                   do{
                        double price = result1.getDouble(6);
                        int quantity = viewShop.getTextQuantity();
                        wrongQuantityCheck(quantity);
                        double oldValue = viewShop.getTextTotal();
                        double totalPrice = price * quantity + oldValue;
                        viewShop.setTextTotal(totalPrice);
                        viewShop.refreshName();
                        viewShop.refreshQuantity();
                    }
                   while (result1.next());
                }

            }
            catch (NoWineException nw){
                viewShop.showErrorNoWine(nw.getMessage());
            }
            catch (QuantityException q){
                viewShop.showQuantityMessage(q.getMessage());
            }
            catch(NumberFormatException nb) {
                viewShop.showErrorLetters("Letters in number fields");
            }

            catch (Exception ex){
                //System.out.println("Something went wrong!");
                viewShop.showErrorNoWine("This wine is not in the cellar!");

            }

        }
    }

    class allWinesinShopListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            try {

                cellar.getWines().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * from wine1 ORDER BY wine1_id";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);


                while (result.next()) {
                    int id = result.getInt(9);
                    String name = result.getString(1);
                    double price = result.getDouble(6);
                    int colorId = result.getInt(2);
                    //  shop.getCandies().add(new Wine(id, name, price));
                    cellar.getWines().add(new Wine(id, name, price, colorId));
                }
                viewShop.setTextWines(cellar.getWines().toString());
                connection.close();
            } catch (Exception ex) {
//                view.showMessage("Something went wrong!");
                System.out.println("Something went wrong!");
                ex.printStackTrace();
            }

        }

    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                cellar.getWines().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * from wine1 ORDER BY wine1_id";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);


                while (result.next()) {
                    int id = result.getInt(9);
                    String name = result.getString(1);
                    double price = result.getDouble(6);
                    int colorId = result.getInt(2);
                    //  shop.getCandies().add(new Wine(id, name, price));
                    cellar.getWines().add(new Wine(id, name, price, colorId));
                }
                view.setTextWines(cellar.getWines().toString());
                connection.close();
            } catch (Exception ex) {
//                view.showMessage("Something went wrong!");
                System.out.println("Something went wrong!");
                ex.printStackTrace();
            }

        }
    }

    class SelectByRating implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cellar.getWines().clear();
                Connection connection = databaseConnection.getConnection();
                String sql2 = "SELECT * from wine1 WHERE wine_p = ?";
                //String sql = "SELECT * from wine1 ORDER BY wine1_id";
                PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1,viewRating.getTextRating());
                badRatingCheck(viewRating.getTextRating());
                ResultSet result1 = preparedStatement.executeQuery();

                while(result1.next()){
                    int id = result1.getInt(9);
                    String name = result1.getString(1);
                    int colorId = result1.getInt(2);
                    double price = result1.getDouble(6);
                    cellar.getWines().add(new Wine(id, name,price, colorId));
                    // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
                    // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
                }
                viewRating.setTextArea(cellar.getWines().toString());
                connection.close();
            }
            catch(RatingException r){
                viewRating.showRatingMessage2(r.getMessage());
            }
            catch (Exception e1){

                viewRating.showRatingMessage2("Bad input Rating");

            }
        }
    }

    class SelectByPrice implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        try {
            cellar.getWines().clear();
            Connection connection = databaseConnection.getConnection();
            String sql2 = "SELECT * from wine1 WHERE wine_p = ?";
            //String sql = "SELECT * from wine1 ORDER BY wine1_id";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1,viewPrice.getPriceInt());
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int id = result.getInt(9);
                String name = result.getString(1);
                int colorId = result.getInt(2);
                double price = result.getDouble(6);
                    cellar.getWines().add(new Wine(id, name,price, colorId));
                   // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
                   // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
            }
            viewPrice.setTextArea(cellar.getWines().toString());
            connection.close();
        }

        catch (Exception ex){
            System.out.println("Something went wrong!");
        }
        }
    }

    class SelectByColor implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cellar.getWines().clear();
                Connection connection = databaseConnection.getConnection();
                String sql2 = "SELECT * from wine1 WHERE wine_color = ?";
                //String sql = "SELECT * from wine1 ORDER BY wine1_id";
                PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1,viewColor.getColorInt());
                ResultSet result = preparedStatement.executeQuery();

                while(result.next()){
                    int id = result.getInt(9);
                    String name = result.getString(1);
                    int colorId = result.getInt(2);
                    double price = result.getDouble(6);
                    cellar.getWines().add(new Wine(id, name, price, colorId));
                    // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
                    // viewPrice.setTextArea("Wine id:" + id + ", name:" + name + "color: "+ colorId);
                }
                viewColor.setTextArea(cellar.getWines().toString());
                connection.close();
            }

            catch (Exception ex){
                System.out.println("Something went wrong!");
            }
        }
    }

    class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into wine1 (wine_name, wine_price, wine_color,wine_rating, wine_seller )" + "values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, view.getNameTextField());
                preparedStatement.setDouble(2, view.getPriceTextField());
                preparedStatement.setInt(3, view.getColorInt());
                preparedStatement.setInt(4, view.getTextRating());
                preparedStatement.setString(5, view.getTextSeller());
                badRatingCheck(view.getTextRating());
                wrongPriceCheck(view.getPriceTextField());
                preparedStatement.executeUpdate();
                view.refresh();
                connection.close();
            }
            catch(PriceException pe){
                view.showErrorPrice(pe.getMessage());
            }
            catch (RatingException r){
                view.showRatingMessage(r.getMessage());
            }
            catch(NumberFormatException nb) {
                view.showErrorLetters("Letters in number fields");
            }
            catch (Exception ex) {
               view.showErrorMessage("Bad input!");
;

            }
        }
    }

   class SignUpInsertListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into login2 (email, pass, name, surname, age)" + "values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, loginView.getEmail());
            preparedStatement.setString(2, loginView.getPassword());
            preparedStatement.setString(3, loginView.getName());
            preparedStatement.setString(4, loginView.getSurname());

            int age = loginView.getAge(); // Get the age as an int

            // Check if the age is less than 18
            if (age < 18) {
                JOptionPane.showMessageDialog(loginView, "You must be at least 18 years old to create an account.", "Age Requirement", JOptionPane.ERROR_MESSAGE);
                loginView.clearFields();
            } else {
                preparedStatement.setInt(5, age); // Set the age if it meets the requirement
                preparedStatement.executeUpdate();
                loginView.clearFields();
                JOptionPane.showMessageDialog(loginView, "SignUp Successfully and Connected");
                connection.close();
                loginView.dispose();
                selectView.setVisible(true);
            }
        } catch (Exception ex) {
            view.showRatingMessage(ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Error during login process", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    public void badRatingCheck ( int rating) throws RatingException {
        if(rating>5 || rating<0) {
            throw new RatingException("Rating should be in the range 1-5");
        }
    }

    public void wrongQuantityCheck( int quantity) throws QuantityException{
        if(quantity<0)
            throw  new QuantityException("Negative quantity");
    }

    public void wrongWine (int price) throws NoWineException{
        if(price==0)
            throw new NoWineException("This wine is not in the cellar");
    }

    public void wrongPriceCheck( double price) throws PriceException{
        if(price<0)
            throw new PriceException("Negative Price");
    }


}
