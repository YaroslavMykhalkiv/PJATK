import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RezerwacjaZlozona extends Rezerwacja implements Serializable {

    private double zaliczka;
    private Date dataZlozenia;

    private static List<RezerwacjaZlozona> eksRezZlozona = new ArrayList<>();


    public RezerwacjaZlozona(Date datePrzjazdu, Date dateOdjazdu, double kwota, @NotNull Klient klient, @NotNull Pokoj pokoj, double zaliczka, Date dataZlozenia) {
        super(datePrzjazdu, dateOdjazdu, kwota, klient, pokoj);
        this.dataZlozenia = dataZlozenia;
        this.zaliczka = zaliczka;
        addZlozona(this);
    }

    public RezerwacjaZlozona(Rezerwacja prevRezerwacja, double zaliczka, Date dataZlozenia) {
        super(prevRezerwacja.getDatePrzjazdu(), prevRezerwacja.getDateOdjazdu(), prevRezerwacja.getKwota(), prevRezerwacja.getKlient(), prevRezerwacja.getPokojs());
        this.dataZlozenia = dataZlozenia;
        this.zaliczka = zaliczka;
        addZlozona(this);
    }

    public static List<RezerwacjaZlozona> getEksRezZlozona() {
        return eksRezZlozona;
    }

    public void addZlozona(RezerwacjaZlozona rezerwacja){
        eksRezZlozona.add(rezerwacja);
    }


    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksRezZlozona = (ArrayList<RezerwacjaZlozona>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksRezZlozona);
    }

    @Override
    public String toString() {
        return "Rezerwacja Zlozona: " +

                super.toString() +
                ", Data Zlozenia=" + getDMY(dataZlozenia);
    }
}
