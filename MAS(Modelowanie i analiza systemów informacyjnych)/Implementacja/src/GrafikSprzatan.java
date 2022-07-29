

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GrafikSprzatan {

    private Date data;
    private Time czasPoczatku;
    private Time czasKoncu;

    //BAG
    private Sprzatacz sprzatacz;
    private List<Pokoj> pokojs = new ArrayList<>();
    private static List<GrafikSprzatan> eksGrafik = new ArrayList<>();

    public GrafikSprzatan(Date data,Time czasPoczatku, Time czasKoncu, @NotNull Sprzatacz sprzatacz, @NotNull Pokoj pokoj){
        this.data = data;
        this.czasPoczatku = czasPoczatku;
        this.czasKoncu = czasKoncu;
        addPokoj(pokoj);
        setSprzatacz(sprzatacz);
        addGrafik(this);
    }

    public static void addGrafik(GrafikSprzatan grafikSprzatan){
        eksGrafik.add(grafikSprzatan);
    }

    public Sprzatacz getSprzatacz() {
        return sprzatacz;
    }

    public List<Pokoj> getPokojs() {
        return pokojs;
    }
    //POKOJ

    public void removePokoj(@NotNull Pokoj pokoj){
        if (!pokojs.contains(pokoj))
            return;
        pokojs.remove(pokoj);
        pokoj.removeGrafik(this);
    }

    public void addPokoj(@NotNull Pokoj pokoj) {
        if (pokojs.size() >= 5)
            return;
        if (pokojs.contains(pokoj))
            return;
        pokojs.add(pokoj);
        pokoj.addGrafik(this);
    }
    //SPRZATACZ
    public void setSprzatacz(@NotNull Sprzatacz sprzatacz) {
        removeSprzatacz();
        if (this.sprzatacz != null)
            this.sprzatacz.removeGrafik(this);
        this.sprzatacz = sprzatacz;
        sprzatacz.addGrafik(this);
    }

    public void removeSprzatacz(){
        if (sprzatacz == null)
            return;
        sprzatacz.removeGrafik(this);
        sprzatacz = null;
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksGrafik = (ArrayList<GrafikSprzatan>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksGrafik);
    }

    @Override
    public String toString() {
        return "GrafikSprzatan{" +
                "data=" + data +
                ", czasPoczatku=" + czasPoczatku +
                ", czasKoncu=" + czasKoncu +
                ", sprzatacz=" + sprzatacz +
                ", pokojs=" + pokojs +
                '}';
    }
}
