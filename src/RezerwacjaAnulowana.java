import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RezerwacjaAnulowana extends Rezerwacja implements Serializable {

    private Date dataAnulowania;

    private static List<RezerwacjaAnulowana> eksRezAnulowana = new ArrayList<>();


    public RezerwacjaAnulowana(Date datePrzjazdu, Date dateOdjazdu, double kwota, @NotNull Klient klient, @NotNull Pokoj pokoj , Date dataAnulowania) {
        super(datePrzjazdu, dateOdjazdu, kwota, klient, pokoj);
        this.dataAnulowania = dataAnulowania;
        addAnulowana(this);
    }

    public RezerwacjaAnulowana(Rezerwacja prevRezerwacja, Date dataAnulowania) {
        super(prevRezerwacja.getDatePrzjazdu(), prevRezerwacja.getDateOdjazdu(), prevRezerwacja.getKwota(), prevRezerwacja.getKlient(), prevRezerwacja.getPokojs());
        this.dataAnulowania = dataAnulowania;
        addAnulowana(this);
    }

    public static List<RezerwacjaAnulowana> getEksRezAnulowana() {
        return eksRezAnulowana;
    }

    public void addAnulowana(RezerwacjaAnulowana rezerwacja){
        eksRezAnulowana.add(rezerwacja);
    }


    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksRezAnulowana = (ArrayList<RezerwacjaAnulowana>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksRezAnulowana);
    }

    @Override
    public String toString() {
        return "Rezerwacja Anulowana: " +
                super.toString() +
                ", Data Anulowania=" + getDMY(dataAnulowania);
    }
}
