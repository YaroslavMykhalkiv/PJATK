import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Klient implements Serializable{
    private String imie;
    private String nazwisko;
    private String pesel;


    private List<Hotel> hotels = new ArrayList<>();
    private List<Rezerwacja> rezerwacjas = new ArrayList<>();
    private static List<Klient> eksKlients = new ArrayList<>();



    public Klient(String imie, String nazwisko, String pesel){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        addKlient(this);
    }

    public static List<Klient> getEksKlients() {
        return eksKlients;
    }

    public static void addKlient(Klient klient) {
        eksKlients.add(klient);
    }

    public void addRezerwacja(@NotNull Rezerwacja rezerwacja){
        if (this.rezerwacjas.contains(rezerwacja))
            return;
        rezerwacjas.add(rezerwacja);
    }


    public void removeRezerwacja(Rezerwacja rezerwacja) {
        if (!rezerwacjas.contains(rezerwacja))
            return;
        rezerwacjas.remove(rezerwacja);
        rezerwacja.removeKlient();
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksKlients = (ArrayList<Klient>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksKlients);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
