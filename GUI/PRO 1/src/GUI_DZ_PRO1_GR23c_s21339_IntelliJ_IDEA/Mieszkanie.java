package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Mieszkanie {
    static ArrayList<Mieszkanie> listaMieszkan = new ArrayList<>();
    static int countIDMieszkania = 1;
    double powierzchnia;
    String  idMieszkania = "M";
    Osiedla osiedla;
    String numerBloku;
    int numerMieszkania;
    ArrayList<Osoba> listaOsob = new ArrayList<>();
    Osoba najemca;
    Date startDate;
    Date endDate;
    Date currentDate;

    public Mieszkanie(Osiedla osiedla,String numerBloku,int numerMieszkania,double powierzchnia,Osoba najemca, Date startDate,Date endDate){
        this.osiedla = osiedla;
        this.numerBloku = numerBloku;
        this.numerMieszkania = numerMieszkania;
        this.najemca = najemca;
        this.powierzchnia = powierzchnia;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentDate = startDate;
        idMieszkania += countIDMieszkania++ + "M";
        listaMieszkan.add(this);
        this.najemca = najemca;
        if (najemca != null) {
            try {
                najemca.addMieszkanie(this, startDate, endDate);
            } catch (ProblematicTenantException e) {
                e.printStackTrace();
            }
        }
    }

    public void addOsoba(Osoba osoba){
        if (!listaOsob.contains(osoba)) {
            listaOsob.add(osoba);
            if (najemca == null) {
                int day;
                int month;
                int year;
                Calendar c = Calendar.getInstance();
                osoba.typNajemca();
                najemca = osoba;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Prosze wybrac date poczatku wynajmu:\n" +
                        "Rok(YYYY): ");
                year = scanner.nextInt();
                System.out.println("Miesiac(MM): ");
                month = scanner.nextInt();
                System.out.println("Dzien(DD): ");
                day = scanner.nextInt();
                c.set(year, --month, day, 0, 0);
                Date start =c.getTime();
                System.out.println("Prosze wybrac date koncu wynajmu:\n" +
                        "Rok(YYYY): ");
                year = scanner.nextInt();
                System.out.println("Miesiac(MM): ");
                month = scanner.nextInt();
                System.out.println("Dzien(DD): ");
                day = scanner.nextInt();
                c.set(year, --month, day, 0, 0);
                Date end = c.getTime();
                this.startDate = start;
                this.endDate = end;
                this.currentDate = start;
            }
            osoba.mieszkanie = this;
        }else
            System.out.println("Osoba juz zameldowana w mieszkaniu");
    }

    public void removeOsoba(Osoba osoba){
        listaOsob.remove(osoba);
    }

    public String toString(){
        return idMieszkania + " powierzchnia: " + powierzchnia;
    }

    public void przedluzycNajem(Date endDate) throws IOException {
        this.endDate = endDate;
        String sms = "";
        FileReader fr= null;
        for (int i = 0; i < najemca.listaFile.size(); i++) {
            try {
                fr = new FileReader(najemca.listaFile.get(i));
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
            if (sms.contains(idMieszkania)){
                najemca.listaFile.remove(najemca.listaFile.get(i));
            }
            sms += "";
        }
    }

    public void getListeOsob(){
        String liste = "Liste osob:";
        for (Osoba o : listaOsob)
            liste += o + ", ";
        System.out.println(liste);
    }


}
