import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Pracownik {


    private String imie;
    private String nazwisko;
    private String pesel;
    private Date dataZatrudnienia;
    private double pensja;

    private List<Hotel> hotels = new ArrayList<>();
    private static List<Pracownik> eksPracownik = new ArrayList<>();


    public Pracownik(String imie, String nazwisko, String pesel, Date dataZatrudnienia, double pensja){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.pensja = pensja;
        this.pesel = pesel;
        addPracownik(this);
    }

    public  static void addPracownik(Pracownik pracownik){
        eksPracownik.add(pracownik);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public String getImie() {
        return imie;
    }

    public void addHotel(Hotel hotel) {
        if ( this.hotels.size() > 2)
            return;
        if ( hotels.contains(hotel))
            return;
        if (hotel != null ) {
            hotels.add(hotel);
            hotel.addPracownik(this);
        }
    }



    public void removeHotel(Hotel hotel){
        if (!hotels.contains(hotel))
            return;
        if ( hotel!= null) {
            hotels.remove(hotel);
            hotel.removePracownik(this);
        }
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksPracownik = (ArrayList<Pracownik>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksPracownik);
    }


    @Override
    public String toString() {
        return "\n\t\tEmployee{" +
                "\n\t\t\timie='" + imie + '\'' +
                ", \n\t\t\thotels=" + hotels.stream().map(e->{return e.getHotel().getNazwa();}).collect(Collectors.toList()) +
                "\n\t\t}";
    }
}
