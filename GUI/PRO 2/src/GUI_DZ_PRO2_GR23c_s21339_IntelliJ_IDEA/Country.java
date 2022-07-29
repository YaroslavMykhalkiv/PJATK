package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.ArrayList;

class Country extends Circle {
     static double chance = 0.5;
     static int points = 0;
     static ArrayList<Country> listOfCountry = new ArrayList<>();
     int population,infected = 0,deaded = 0,cured = 0;
     double x, y, radius;
     Label infoOfCountry ;
     String country;
     ArrayList<Country> tabOfCountry = new ArrayList<>();
     Circle plane;
     Circle ship;
     boolean isAllInfected = false;
     boolean isAllCured = true;
     InfoAboutCountry testFrame;

    public Country(double x, double y, double radius,String country, int population){
        super(x,y,radius);
        if (country == "China") {
            infected = 1;
            isAllCured = false;
        }
        setFill(Color.DARKGREEN);
        this.country = country;
        this.x = x;
        this.y = y;
        this.population = population;
        this.radius = radius;
        plane = new Circle(x, y, 7.5, Color.GRAY);
        ship = new Circle(x, y, 10, Color.BLACK);
        testFrame = new InfoAboutCountry(country,population);
        listOfCountry.add(this);
    }

    public void getInfo(){
        testFrame.createGUI();
    }
}
