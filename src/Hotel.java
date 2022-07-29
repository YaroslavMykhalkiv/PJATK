import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class Hotel implements Serializable {
    private String nazwa;
    private String adres;
    private int liczba_pokoi;
    private int liczba_gwiazdek;


    private List<Pracownik> allEmps = new ArrayList<Pracownik>();
    private Map<Integer,Pokoj> pokojMap = new TreeMap<>();
    private static List<Hotel> eksHotel = new ArrayList<>();


    public Hotel(String nazwa,String adres, int liczba_gwiazdek){
        this.nazwa = nazwa;
        this.adres = adres;
        this.liczba_gwiazdek = liczba_gwiazdek;
        this.liczba_pokoi = 0;
        addHotel(this);
    }

    public String getNazwa() {
        return nazwa;
    }
    public Hotel getHotel(){
        return this;
    }

    public static void addHotel(Hotel hotel) {
        eksHotel.add(hotel);
    }

    public static List<Hotel> getEksHotel() {
        return eksHotel;
    }

    //PRACOWNIK

    public void addPracownik(Pracownik emp) {
        if ( allEmps.contains(emp))
            return;
        if (emp != null) {
            allEmps.add(emp);
            emp.addHotel(this);
        }
    }

    public void removePracownik(Pracownik emp){
        if (!allEmps.contains(emp))
            return;
        if ( emp!= null) {
            allEmps.remove(emp);
            emp.removeHotel(this);
        }
    }


//POKOJ
    public void removePokoj(Pokoj room){
        if (pokojMap.containsValue(room)) {
            pokojMap.remove(room.getId());
            liczba_pokoi--;
            room.removeHotel();
        }
    }

    public Map<Integer, Pokoj> getRooms() {
        return pokojMap;
    }

    public void addPokoj(@NotNull Pokoj newRoom) {
        if(!pokojMap.containsKey(newRoom.getId())) {
            pokojMap.put(newRoom.getId(), newRoom);
            liczba_pokoi++;
            newRoom.setHotel(this);
        }
    }

    public Pokoj findPokoj(int id) throws Exception {
        if(!pokojMap.containsKey(id)) {
            throw new Exception("Unable to find a room with id: " + id);
        }
        return pokojMap.get(id);
    }

    //Ekstencsja
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksHotel = (ArrayList<Hotel>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksHotel);
    }

    public static void writeReadAllExtents() throws IOException, ClassNotFoundException {
        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("extent.txt"));
        ObjectInputStream read = new ObjectInputStream(new FileInputStream("extent.txt"));

        //WRITE
        Rezerwacja.writeExtent(write);
        Pokoj.writeExtent(write);
        GrafikSprzatan.writeExtent(write);
        Hotel.writeExtent(write);
        Klient.writeExtent(write);
        Pracownik.writeExtent(write);
        Prezydencki.writeExtent(write);
        RezerwacjaAnulowana.writeExtent(write);
        RezerwacjaPodtwierdzona.writeExtent(write);
        RezerwacjaZlozona.writeExtent(write);
        Sprzatacz.writeExtent(write);
        Zwykly.writeExtent(write);
        write.close();

        //READ
        Rezerwacja.readExtent(read);
        Pokoj.readExtent(read);
        GrafikSprzatan.readExtent(read);
        Hotel.readExtent(read);
        Klient.readExtent(read);
        Pracownik.readExtent(read);
        Prezydencki.readExtent(read);
        RezerwacjaAnulowana.readExtent(read);
        RezerwacjaPodtwierdzona.readExtent(read);
        RezerwacjaZlozona.readExtent(read);
        Sprzatacz.readExtent(read);
        Zwykly.readExtent(read);
        read.close();
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "nazwa='" + nazwa + '\'' +
                ", adres='" + adres + '\'' +
                ", liczba_pokoi=" + liczba_pokoi +
                ", liczba_gwiazdek=" + liczba_gwiazdek +
                ", \nemps=" + allEmps +
                ", \nrooms=" + pokojMap.values() +
                "\n}";
    }
}
