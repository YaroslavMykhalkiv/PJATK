package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

public class Pojazd extends Thing {
    String nazwaRzeczy;
    double objetosc;
    enum  TypPojazdu{AMFIBIA,MOTOCYKL,LODZ,SAMOCHOD_TERENOWY,SAMOCHOD_MIEJSKI}
    TypPojazdu typPojazdu;
    double pojemnoscSilnika;
    String typSilnika;
    double maxSpeed;

    public Pojazd(String nazwaRzeczy, double objetosc,TypPojazdu typPojazdu,String typSilnika,double pojemnoscSilnika,double maxSpeed){
        super(nazwaRzeczy,objetosc);
        this.typPojazdu = typPojazdu;
        this.typSilnika = typSilnika;
        this.maxSpeed = maxSpeed;
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String toString(){
        return super.toString() + ", typ pojazdu: " + typPojazdu + " , typ silnika: " + typSilnika + " , pojemnosc silnika : " + pojemnoscSilnika + " , max speed(km/h): " + maxSpeed ;
    }

}
