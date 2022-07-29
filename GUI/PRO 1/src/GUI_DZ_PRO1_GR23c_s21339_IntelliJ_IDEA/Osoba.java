package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;import java.util.Date;
import java.util.Scanner;

public class Osoba {
    static ArrayList<Osoba> listaWszystkichOsob = new ArrayList<>();
    static ArrayList<Osoba> listaWszystkichOsobINajemc = new ArrayList<>();
    static ArrayList<Osoba> listaWszystkichNajemc = new ArrayList<>();
    Mieszkanie mieszkanie;
    String imie,nazwisko,pesel,adresOsoby ,dataUrodzenia;
    ArrayList<MiejsceParkingowe> listaMiejscParkingowych = new ArrayList<>();
    ArrayList<Mieszkanie> listaWynajmMieszkania = new ArrayList<>();
    ArrayList<File> listaFile = new ArrayList<>();
    String typ = "osoba";


    public Osoba(String imie,String nazwisko,String pesel,String adresOsoby,String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adresOsoby = adresOsoby;
        this.dataUrodzenia = dataUrodzenia;
        listaWszystkichOsob.add(this);
        listaWszystkichOsobINajemc.add(this);
    }

    public Osoba(Osoba osoba){
        this.imie = osoba.imie;
        this.nazwisko = osoba.nazwisko;
        this.pesel = osoba.pesel;
        this.adresOsoby = osoba.adresOsoby;
        this.dataUrodzenia = osoba.dataUrodzenia;
        listaWszystkichOsob.add(this);
        listaWszystkichOsobINajemc.add(this);
    }

    public void addMiejsceParkingowe(MiejsceParkingowe mp){
        if (listaMiejscParkingowych.size() < 5) {
            listaMiejscParkingowych.add(mp);
            mp.osoba = this;
        }else
            System.out.println("Osoba juz wunajmuje 5 miejsc parkingowych");
    }
    public String getListaMiejscParkingowych(){
        String miejsca = "";
        for (MiejsceParkingowe m : listaMiejscParkingowych){
            miejsca += m + "\n";
        }
        return miejsca;
    }

    public void removeMiejsceParkingowe(MiejsceParkingowe mp){
        listaMiejscParkingowych.remove(mp);
        mp.things.clear();
        mp.osoba = null;
        mp.startDate = null;
        mp.endDate = null;
    }


    public void addMieszkanie(Mieszkanie mieszkanie, Date start, Date end) throws ProblematicTenantException {
        if ( typ.toLowerCase() == "najemca") {
            if (listaWynajmMieszkania.size() < 5 && listaFile.size() < 3) {
                listaWynajmMieszkania.add(mieszkanie);
                System.out.println(getListaMieszkan());
                mieszkanie.najemca = this;
                mieszkanie.startDate = start;
                mieszkanie.endDate = end;
                mieszkanie.currentDate = start;
            } else if (listaFile.size() >= 3) {
                throw new ProblematicTenantException("Osoba " + imie + " " + nazwisko + " posiadała już najem pomieszczeń:" + getListaMieszkan() + getListaMiejscParkingowych());
            } else
                System.out.println("Najemca juz wunajmuje 5 mieszkan");
        }
    }

    public void removeMieszkanie(Mieszkanie mieszkanie){
        if (typ.toLowerCase() == "najemca") {
            listaWynajmMieszkania.remove(mieszkanie);
            mieszkanie.listaOsob.clear();
            mieszkanie.najemca = null;
            mieszkanie.startDate = null;
            mieszkanie.endDate = null;
        }else
            System.out.println("Tylko najemca moze usuwac wynajmowane mieszkania");
    }

    public void addOsoba(Osoba osoba,Mieszkanie mieszkanie){
        if (typ.toLowerCase() == "najemca") {
            mieszkanie.addOsoba(osoba);
        }else
            System.out.println("Tylko najemca moze dodawac osob do mieszkania");
    }

    public void removeOsoba(Osoba osoba,Mieszkanie mieszkanie){
        if (typ.toLowerCase() == "najemca") {
            mieszkanie.removeOsoba(osoba);
        }else
            System.out.println("Tylko najemca moze usuwac osob z mieszkania");    }

    public String getListaMieszkan(){
        String mieszkania = "";
        for (Mieszkanie m : listaWynajmMieszkania){
            mieszkania += m + "\n";
        }
        return mieszkania;
    }

    public void typNajemca(){
        typ = "najemca";
        listaWszystkichNajemc.add(this);
        listaWszystkichOsob.remove(this);
    }

    public String toString(){
        if (typ.toLowerCase() == "najemca" )
        return imie + " " + nazwisko + " wynajmuje mieszkania : " + getListaMieszkan();
        return imie + " " + nazwisko;
    }

    public void getListFile(){
        String sms = "";
        FileReader fr= null;
        for (int i = 0; i < listaFile.size(); i++) {

            try {
                fr = new FileReader(listaFile.get(i));
                Scanner scan = new Scanner(fr);
                while (scan.hasNextLine()) {
                    sms += scan.nextLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sms += "\n";
        }
        System.out.println(sms);
    }
}
