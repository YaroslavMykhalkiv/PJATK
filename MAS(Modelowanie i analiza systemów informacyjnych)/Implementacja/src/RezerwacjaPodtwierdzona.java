import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RezerwacjaPodtwierdzona extends Rezerwacja implements Serializable {

    private Date dataOplaty;

    private static List<RezerwacjaPodtwierdzona> eksRezPodtwierdzona = new ArrayList<>();



    public RezerwacjaPodtwierdzona(Date datePrzjazdu, Date dateOdjazdu, double kwota, @NotNull Klient klient, @NotNull Pokoj pokoj, Date dataOplaty) {
        super(datePrzjazdu, dateOdjazdu, kwota, klient, pokoj);
        this.dataOplaty = dataOplaty;
    }

    public RezerwacjaPodtwierdzona(Rezerwacja prevRezerwacja,Date dataOplaty ) {
        super(prevRezerwacja.getDatePrzjazdu(), prevRezerwacja.getDateOdjazdu(), prevRezerwacja.getKwota(), prevRezerwacja.getKlient(), prevRezerwacja.getPokojs());
        this.dataOplaty = dataOplaty;
    }

    public static List<RezerwacjaPodtwierdzona> getEksRezPodtwierdzona() {
        return eksRezPodtwierdzona;
    }

    public void addPodtwierdozna(RezerwacjaPodtwierdzona rezerwacja){
        eksRezPodtwierdzona.add(rezerwacja);
    }


    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksRezPodtwierdzona = (ArrayList<RezerwacjaPodtwierdzona>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksRezPodtwierdzona);
    }

    @Override
    public String toString() {
        return "Rezerwacja Podtwierdzona: " +
                super.toString() +
                ", Data Oplaty=" + getDMY(dataOplaty);
    }
}
