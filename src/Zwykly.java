import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Zwykly extends Pokoj implements Serializable {

    private boolean klimatyzacja;
    private boolean tv;

    private static List<Zwykly> eksZwykly = new ArrayList<>();


    public Zwykly(double cena, double powierzchnia, int maxLiczbOsob, boolean klimatyzacja, boolean tv, @NotNull Hotel hotel) throws Exception {
        super(cena, powierzchnia, maxLiczbOsob, hotel);
        this.klimatyzacja = klimatyzacja;
        this.tv = tv;
    }

    public static List<Zwykly> getEksZwykly() {
        return eksZwykly;
    }

    public void addZwykly(Zwykly zwykly){
        eksZwykly.add(zwykly);
    }


    @Override
    public String toString() {
        return "Pokoj Zwykly: " +
                super.toString() +
                ", Klimatyzacja=" + (klimatyzacja? "Jest" : "Nie ma") +
                ", TV=" + (tv? "Jest" : "Nie ma");
    }

    public void setKlimatyzacja(boolean klimatyzacja) {
        this.klimatyzacja = klimatyzacja;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksZwykly = (ArrayList<Zwykly>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksZwykly);
    }
}
