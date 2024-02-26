package postgresProject.models;

import java.util.ArrayList;
import java.util.List;

public class Cellar {

    private String name;
    private List<Wine> wines;

    public Cellar(String name) {
        this.name = name;
        this.wines=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }


    @Override
    public String toString() {
        return "Cellar{" +
                "name='" + name + '\'' +
                ", wines=" + wines +
                '}';
    }
}
