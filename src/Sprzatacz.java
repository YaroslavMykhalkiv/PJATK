import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprzatacz extends Pracownik implements Serializable {

    private List<GrafikSprzatan> grafikSprzatans = new ArrayList<>();

    private static List<Sprzatacz> eksSprzatacz = new ArrayList<>();



    public Sprzatacz(String imie, String nazwisko, String pesel, Date dataZatrudnienia, double pensja) {
        super(imie, nazwisko, pesel, dataZatrudnienia, pensja);
        addSprzatacz(this);
    }

    public void addSprzatacz(Sprzatacz sprzatacz){
        eksSprzatacz.add(sprzatacz);
    }

    public static List<Sprzatacz> getEksSprzatacz() {
        return eksSprzatacz;
    }

    public void addGrafik(@NotNull GrafikSprzatan grafikSprzatan){
        if (this.grafikSprzatans.contains(grafikSprzatan))
            return;
        grafikSprzatans.add(grafikSprzatan);
    }

    public void removeGrafik(GrafikSprzatan grafikSprzatan) {
        if (!grafikSprzatans.contains(grafikSprzatan))
            return;
        grafikSprzatans.remove(grafikSprzatan);
        grafikSprzatan.removeSprzatacz();
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksSprzatacz = (ArrayList<Sprzatacz>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksSprzatacz);
    }
}
