import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Hotel hotel2 = new Hotel("Huotel","sdfsd",2);
        Klient klient = new Klient("Ivan", "Kuij", "34243424");

        Pokoj pokoj1 = new Prezydencki(400,23,2,"2331",hotel2);
        Pokoj pokoj2 = new Zwykly(500,43,2,true,true,hotel2);
        Pokoj pokoj3 = new Prezydencki(300,33,2,"111",hotel2);

        Rezerwacja rezerwacja = new RezerwacjaZlozona(new Date(), new Date(122, Calendar.JUNE,29),500,klient,pokoj1,300,new Date());
        Rezerwacja rezerwacja1 = new RezerwacjaAnulowana(new Date(122, Calendar.JUNE,23), new Date(122, Calendar.JUNE,29),500,klient,pokoj2,new Date());
        Rezerwacja rezerwacja2 = new RezerwacjaPodtwierdzona(new Date(122, Calendar.JUNE,25), new Date(122, Calendar.JUNE,29),500,klient,pokoj2,new Date());

        rezerwacja.addPokoj(pokoj2);
        rezerwacja1.addPokoj(pokoj3);

//        System.out.println(rezerwacja);
//        System.out.println(Rezerwacja.getRezerwacjas());
//        Rezerwacja.wyswietlRezerwacjeWZadanymOkresie(new Date(122,Calendar.MAY,17),new Date(122,Calendar.JUNE,22)).forEach(r-> System.out.println(r));
//        System.out.println(Rezerwacja.getRezerwacjas());

        System.out.println(Rezerwacja.getEksRezerwacja());
        System.out.println(Pokoj.getEksPokoje());
        System.out.println(Hotel.getEksHotel());
        System.out.println(pokoj2.getHotel());

        Hotel.writeReadAllExtents();

        System.out.println(Rezerwacja.getEksRezerwacja());
        System.out.println("---" + Pokoj.getEksPokoje());
        System.out.println(Klient.getEksKlients());
        System.out.println(Hotel.getEksHotel());
    }
}
