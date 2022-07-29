import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pokoj implements Serializable{


    private int id;
    private double square;
    private double price;
    private int maxLiczbaLudzi;

    private Hotel hotel;
    private List<GrafikSprzatan> grafikSprzatans = new ArrayList<>();
    private List<Rezerwacja> rezerwacjas = new ArrayList<>();
    public final static float minimumPrice = 300;
    public final static float maximumPrice = 1000;
    private static int curId = 1;
    private static List<Pokoj> eksPokoje = new ArrayList<>();



    public Pokoj(double price, double square, int maxLiczbaLudzi, @NotNull Hotel hotel) throws Exception {
        this.square = square;
        this.maxLiczbaLudzi = maxLiczbaLudzi;
        id = curId;
        curId++;
        setPrice(price);
        setHotel(hotel);
        addPokoje(this);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public static void addPokoje(Pokoj pokoj) {
        eksPokoje.add(pokoj);
    }

    public static List<Pokoj> getEksPokoje() {
        return eksPokoje;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price < minimumPrice || price > maximumPrice){
            throw new Exception("The new price should be from 300 to 1000");
        }
        this.price = price;
    }

    public void setHotel(@NotNull Hotel hotel) {
        if (this.hotel != hotel) {
            if (this.hotel != null)
                this.hotel.removePokoj(this);
            this.hotel = hotel;
            hotel.addPokoj(this);
        }
    }

    public void removeHotel(){
        if (hotel != null){
            hotel.removePokoj(this);
            hotel = null;
        }
    }

    public String wyswieltInfoPokokoju(){
        return toString();
    }

    @Override
    public String toString() {
        return  "ID=" + id +
                ", Powierzchnia=" + square +
                ", Cena=" + price +
                ", Maksymalna ilosc osob=" + maxLiczbaLudzi;
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

    public void addRezerwacja(@NotNull Rezerwacja rezerwacja){
        if (this.rezerwacjas.contains(rezerwacja)) {
            System.out.println("eeeeeee");
            return;
        }
        rezerwacjas.add(rezerwacja);
    }


    public void removeRezerwacja(Rezerwacja rezerwacja) {
        if (!rezerwacjas.contains(rezerwacja))
            return;
        rezerwacjas.remove(rezerwacja);
        rezerwacja.removePokoj(this);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        eksPokoje = (ArrayList<Pokoj>)stream.readObject();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(eksPokoje);
    }
}
