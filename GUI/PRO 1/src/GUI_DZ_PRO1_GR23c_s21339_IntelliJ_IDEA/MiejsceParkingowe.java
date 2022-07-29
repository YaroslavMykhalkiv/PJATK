package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MiejsceParkingowe {
    static ArrayList<MiejsceParkingowe> listaWszystkichMiejscParkingowych = new ArrayList<>();
    static int countIdParkingu = 1;
    String  idParkingu = "P";
    double dlugosc, szerokosc,wysokosc;
    double objetosc;
    double uzywaneMiejsca = 0;
    ArrayList<Thing> things = new ArrayList<>();
    Osoba osoba;
    Date startDate;
    Date endDate;
    Date currentDate ;

    public MiejsceParkingowe(Osoba osoba,double dlugosc,double szerokosc,double wysokosc,Date startDate,Date endDate){
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentDate = startDate;
        this.osoba = osoba;
        objetosc = dlugosc * szerokosc * wysokosc;
        idParkingu += countIdParkingu++ + "P";
        listaWszystkichMiejscParkingowych.add(this);
    }

    public String toString(){
        return idParkingu + " objetosc: " + objetosc +  getListeThings();
    }

    public double getPowierchnia(){
        return objetosc-uzywaneMiejsca;
    }

    public void addThing(Thing thing) throws TooManyThingsException{
        if (osoba == null)
            System.out.println("Prosze ukazac wlasciciela tego miejsca");
        else {
            if ((uzywaneMiejsca + thing.objetosc) > objetosc) {
                throw new TooManyThingsException("Remove some old items to insert a new item, free place: " + (objetosc - uzywaneMiejsca));

            } else {
                things.add(thing);
                Thing t;
                for (int j = 0; j < things.size(); j++) {
                    for (int i = j + 1; i < things.size(); i++) {
                        if (things.get(i).nazwaRzeczy.compareTo(things.get(j).nazwaRzeczy) < 0) {
                            t = things.get(j);
                            things.set(j, things.get(i));
                            things.set(i, t);
                        }
                    }
                }
                uzywaneMiejsca += thing.objetosc;
                for(int i =things.size() - 1 ; i > 0 ; i--){
                    for(int j = 0 ; j < i ; j++){
                        if( things.get(j).objetosc > things.get(j+1).objetosc ){
                            Thing tmp = things.get(j);
                            things.set(j,things.get(j+1));
                            things.set(j+1,tmp);
                        }
                    }
                }
            }
        }
    }

    public  void removeThing(Thing thing){
        things.remove(thing);
        uzywaneMiejsca -= thing.objetosc;
    }
    public String getListeThings(){
        String text = " Liste przedmiotow: ";
        for (Thing t : things)
            text += "\n" + t ;
        return text;
    }

    public void przedluzycNajem(Date endDate) throws IOException {
        this.endDate = endDate;
        for (int i = 0; i < osoba.listaFile.size(); i++) {
            String sms = "";
            try(FileReader reader = new FileReader(osoba.listaFile.get(i)))
            {
                int c;
                while((c=reader.read())!=-1){
                    sms += c;
                }
                if (sms.contains(idParkingu)){
                    osoba.listaFile.remove(i);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

}
