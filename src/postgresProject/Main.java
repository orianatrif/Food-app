package postgresProject;

import postgresProject.controllers.CellarController;
import postgresProject.models.Cellar;
import postgresProject.models.Wine;
import postgresProject.views.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      // List<Wine> wines = new ArrayList<>();
//        wines.add(new Wine(1, "Twix", 12, "red"));
//        wines.add(new Wine(2, "Lion", 14, "yellow"));
//        wines.add(new Wine(3, "Bounty", 24, "red"));
//        wines.add(new Wine(4, "Mars", 8, "red"));
//        wines.add(new Wine(5, "Snickers", 23, "red"));

        Cellar cellar = new Cellar("Leonidas");//shop
       // cellar.setWines(wines);

        DatabaseConnection databaseConnection=new DatabaseConnection();

        CellarView view=new CellarView();
        MainView viewMain = new MainView();
        PriceView viewPrice = new PriceView();
        RatingView viewRating = new RatingView();
        ColorView viewColor = new ColorView();
        ShopView shopView = new ShopView();
        MakerView viewMaker = new MakerView();
        LoginView loginView = new LoginView();
        FirstView firstViewView = new FirstView();
        SelectView selectView = new SelectView();
        FoodView foodView = new FoodView();

        CellarController controller = new CellarController(view,viewMain,viewPrice, viewRating, viewColor, shopView, viewMaker,loginView, cellar, firstViewView, selectView, foodView, databaseConnection);
       // CellarController ctrl= new CellarController(mainView)

    }
}
