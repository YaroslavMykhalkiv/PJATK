import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prezydencki extends Pokoj implements Serializable {

    private String hasloDoSejfu;

    private static List<Prezydencki> eksPrezydencki = new ArrayList<>();

    public Prezydencki(double cena, double powierzchnia, int maxLiczbOsob, String hasloDoSejfu, @NotNull Hotel hotel) throws Exception {
        super(cena, powierzchnia, maxLiczbOsob, hotel);
        if (hasloDoSejfu.length() > 4)
            throw new Exception("Haslo powinno miec nie wiecej 4 znakow");
        this.hasloDoSejfu = hasloDoSejfu;
        addPrezydencki(this);
    }

    public Prezydencki(int pricePerPerson, double square, int maxLiczbaLudzi, @NotNull Hotel hotel) throws Exception {
        super(pricePerPerson, square, maxLiczbaLudzi, hotel);
        addPrezydencki(this);
    }

    public static List<Prezydencki> getEksPrezydencki() {
        return eksPrezydencki;
    }

    public static void addPrezydencki(Prezydencki prezydencki){
        eksPrezydencki.add(prezydencki);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksPrezydencki = (ArrayList<Prezydencki>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksPrezydencki);
    }

    @Override
    public String toString() {
        return "Pokoj Prezydencki: " +
                super.toString() +
                ", Haslo Do Sejfu='" + hasloDoSejfu + '\'';
    }

    public void setHasloDoSejfu(String hasloDoSejfu) {
        this.hasloDoSejfu = hasloDoSejfu;
    }
}
