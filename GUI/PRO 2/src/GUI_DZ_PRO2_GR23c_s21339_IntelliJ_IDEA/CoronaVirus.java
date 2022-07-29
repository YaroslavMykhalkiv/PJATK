package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

public class CoronaVirus {
    static double infectionRate = 0.05;
    static double deadRate = 0.027;
    static double curedRate = 0.3;


     public CoronaVirus(int predkosc){
         predkosc += (predkosc - 1) * 0.5;
         infectionRate *= predkosc;
         deadRate *= predkosc;
         curedRate /= predkosc;
     }
}
