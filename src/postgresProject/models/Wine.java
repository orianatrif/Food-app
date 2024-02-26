package postgresProject.models;

import exceptions.RatingException;

public class Wine {

    private int id;
    private String name;
    private double price;
    private String color;
    private int colorRepr;
    private int ratingInt;

    public Wine(int id, String name, double price, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }
    public Wine(int id, String name, double price, int colorId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = getColorNumber(colorId);
    }
    public Wine(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Wine(int id, String name, int colorId) {
        this.id = id;
        this.name = name;
        this.color = getColorNumber(colorId);
    }


    public String getColorNumber(int colorId) {
        if (colorId == 1) return "red";
        if (colorId == 2) return "white";
        return "pink";
    }

    public int getNumberColor( String colorName){
        if(colorName=="red") return 1;
        if(colorName=="white") return 2;
        return 3;

    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String print(){
        return "Wine "+name+" has id "+ id + " and color " +color+"\n";
    }

    @Override
    public String toString() {
        return "Wine  " +  name +
                "  has  id=" + id +
                ",  price=" + price +
                ",  color= " + color +
                 "\n";
    }
    


}
