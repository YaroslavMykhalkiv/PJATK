package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

public class Thing {
    String nazwaRzeczy;
    double objetosc;

    public Thing(String nazwaRzeczy, double objetosc){
        this.nazwaRzeczy = nazwaRzeczy;
        this.objetosc = objetosc;
    }
    public String toString(){
        return nazwaRzeczy + " zajmuje: " + objetosc;
    }
}
