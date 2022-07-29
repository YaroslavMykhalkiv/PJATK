import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Rezerwacja implements Serializable {

    private int id;
    private Date datePrzjazdu;
    private Date dateOdjazdu;
    private double kwota;


    private Klient klient;
    private List<Pokoj> pokojs = new ArrayList<>();
    private static List<Rezerwacja> eksRezerwacja = new ArrayList<>();
    public static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Rezerwacja(Date datePrzjazdu, Date dateOdjazdu, double kwota, @NotNull Klient klient, @NotNull Pokoj pokoj){
        this.dateOdjazdu = trim(dateOdjazdu);
        this.datePrzjazdu = trim(datePrzjazdu);
        this.kwota = kwota;
        addPokoj(pokoj);
        setKlient(klient);
        addRezerwacje(this);
        id = eksRezerwacja.size();
    }

    public Rezerwacja(Date datePrzjazdu, Date dateOdjazdu, double kwota, @NotNull Klient klient, @NotNull List<Pokoj> pokojs){
        this.dateOdjazdu = trim(dateOdjazdu);
        this.datePrzjazdu = trim(datePrzjazdu);
        this.kwota = kwota;
        addAllPokojs(pokojs);
        setKlient(klient);
    }

    public static List<Rezerwacja> getEksRezerwacja() {
        return eksRezerwacja;
    }

    public void addRezerwacje(Rezerwacja rezerwacja){
        eksRezerwacja.add(rezerwacja);
    }

    public static List<Rezerwacja> wyswietlRezerwacjeWZadanymOkresie(Date from, Date to){
        return eksRezerwacja.stream().filter(r->{
            return (r.datePrzjazdu.after(from) && r.datePrzjazdu.before(to)) || r.datePrzjazdu.equals(from) || r.datePrzjazdu.equals(to);
        }).collect(Collectors.toList());
    }

    public static Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int getId() {
        return id;
    }

    public List<Pokoj> getPokojs() {
        return pokojs;
    }

    public double getKwota() {
        return kwota;
    }

    public Date getDateOdjazdu() {
        return dateOdjazdu;
    }

    public Date getDatePrzjazdu() {
        return datePrzjazdu;
    }

    public Klient getKlient() {
        return klient;
    }

    //POKOJ

    public void removePokoj(@NotNull Pokoj pokoj){
        if (!pokojs.contains(pokoj))
            return;
        pokojs.remove(pokoj);
        pokoj.removeRezerwacja(this);
    }

    public void addPokoj(@NotNull Pokoj pokoj) {
        if (pokojs.size() >= 3)
            return;
        if (pokojs.contains(pokoj))
            return;
        pokojs.add(pokoj);
        pokoj.addRezerwacja(this);
    }

    public void addAllPokojs(@NotNull List<Pokoj> pokojs){
        for(Pokoj pokoj : pokojs ){
            addPokoj(pokoj);
        }
    }
    //SPRZATACZ
    public void setKlient(@NotNull Klient klient) {
        removeKlient();
        if (this.klient != null)
            this.klient.removeRezerwacja(this);
        this.klient = klient;
        klient.addRezerwacja(this);
    }

    public void removeKlient(){
        if (klient == null)
            return;
        klient.removeRezerwacja(this);
        klient = null;
    }
    //Ekstensja

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksRezerwacja = (ArrayList<Rezerwacja>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksRezerwacja);
    }


    public static String getDMY(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return  "ID=" + id +
                ", Date Przjazdu=" + getDMY(datePrzjazdu) +
                ", Date Odjazdu=" + getDMY(dateOdjazdu);
    }
}
