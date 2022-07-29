package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        DateMoveThread dt = new DateMoveThread();
        CheckCloseDateThread dc = new CheckCloseDateThread();
        dc.start();
        dt.start();
        Osiedla osiedla = new Osiedla("Yuzny");

        boolean exit = false;
        Mieszkanie m0 = new Mieszkanie(osiedla,"12a",30,70,null,null,null);
        Mieszkanie m1 = new Mieszkanie(osiedla,"12a",31,65,null,null,null);
        Mieszkanie m2 = new Mieszkanie(osiedla,"12a",32,67,null,null,null);
        Mieszkanie m3 = new Mieszkanie(osiedla,"12a",33,90,null,null,null);
        Mieszkanie m4 = new Mieszkanie(osiedla,"12a",34,130,null,null,null);
        Mieszkanie m5 = new Mieszkanie(osiedla,"12a",14,30,null,null,null);
        Mieszkanie m6 = new Mieszkanie(osiedla,"12b",45,47,null,null,null);
        Mieszkanie m7 = new Mieszkanie(osiedla,"12b",63,69,null,null,null);
        Mieszkanie m8 = new Mieszkanie(osiedla,"12b",23,34,null,null,null);
        Mieszkanie m9 = new Mieszkanie(osiedla,"12b",56,86,null,null,null);
        Mieszkanie m10 = new Mieszkanie(osiedla,"12b",50,80,null,null,null);

        MiejsceParkingowe p1 = new MiejsceParkingowe(null,5,4,3,null,null);
        MiejsceParkingowe p2 = new MiejsceParkingowe(null,6,3,3,null,null);
        MiejsceParkingowe p3 = new MiejsceParkingowe(null,3,7.8,3,null,null);
        MiejsceParkingowe p4 = new MiejsceParkingowe(null,2,5.6,3,null,null);
        MiejsceParkingowe p5 = new MiejsceParkingowe(null,4.5,7,3,null,null);
        MiejsceParkingowe p6 = new MiejsceParkingowe(null,4,5,3,null,null);
        MiejsceParkingowe p7 = new MiejsceParkingowe(null,5,3,3,null,null);

        Osoba najemca1 = new Osoba("Ivan","Moroz","123454322",null, "1999");
        Osoba najemca2 = new Osoba("Gasia","Kravec","123454644",null, "1999");
        Osoba najemca3 = new Osoba("Bodya","Moka","123455674",null, "1999");
        Osoba najemca4 = new Osoba("Ahmed","Piwo","946885686",null, "1999");
        Osoba najemca5 = new Osoba("Irina","Kilogram","234562345",null, "1999");
        Osoba najemca6 = new Osoba("Katya","Boczek","357345252",null, "1999");
        Osoba najemca7 = new Osoba("Olya","Kamilan","525236336",null, "1999");
        Osoba osoba1 = new Osoba("Sanya","Moroz","123454322",null, "233414");
        Osoba osoba2 = new Osoba("Szmara","Kravec","123454644",null, "233414");
        Osoba osoba3 = new Osoba("Ivan","Moka","123455674",null, "233414");
        Osoba osoba4 = new Osoba("Galil","Piwo","946885686",null, "233414");
        Osoba osoba5 = new Osoba("Katya","Kilogram","234562345",null, "233414");
        Osoba osoba6 = new Osoba("Bodya","Boczek","357345252",null, "233414");
        Osoba osoba7 = new Osoba("Kosia","Kamilan","525236336",null, "233414");

        Scanner scanner = new Scanner(System.in);
        String startDate = null;
        String endDate;
        String text;
        Pojazd.TypPojazdu typPojazdu;
        double pojemnoscSilnika;
        String typSilnika;
        double maxSpeed;
        Date start;
        Date end;
        Calendar c = Calendar.getInstance();
        int day;
        int month;
        int year;
        int funkcja;
        int podFunkcja;
        int index = 1;
        double objetosc;
        while (!exit){
           System.out.println("" +
                   "1. Wyświetl wolne pomieszczenia\n" +
                   "2. Wynajmij pomieszczenie\n" +
                   "3. Zamelduj osobę w pomieszczeniu\n"+
                   "4. Eksmitowac osobe z pomieszczenia\n"+
                   "5. Przedluzyc najem mieszkania\n" +
                   "6. Wolna powierzchnia miejsca parkingowego\n"+
                   "7. Dodac rzecz do miejsca parkingowego\n"+
                   "8. Usunac rzecz z miejsca parkingowego\n"+
                   "9. Zakonc wynajmowac pomieszczenie\n" +
                   "10. Wyswietl wynajmowane pomieszczenia konkretnego najemcy\n" +
                   "11. Wynajmij miejsce parkingowe\n" +
                   "12. Zakonc wynajmowac miejsce parkingowe\n" +
                   "13. Wyswietl wynajmowane miejsca parkingowe konkretnej osoby\n"+
                   "14. Wyswietlic osoby w mieszkaniu\n"+
                   "15. Wyswietlic rzeczy na konkretnym miejscu parkingowym\n"+
                   "16. Przedluzyc najem miejsca parkingowego\n" +
                   "17. Pokazac zadluzenia osoby\n" +
                   "18. EXIT\n" +
                   "19. Zapisac stan calej osiedli"
           );
           funkcja = scanner.nextInt();

           if (funkcja == 1){
               for (Mieszkanie mie : Mieszkanie.listaMieszkan){
                   if (mie.najemca == null)
                       System.out.println(mie.idMieszkania);
               }
           }else if (funkcja == 2){
               System.out.println(
                       "Czy jest najemca juz zarejestrowany?\n"+
                               "1.Tak\n"+
                               "2.Nie\n"+
                               "3.Exit"
               );
               funkcja = scanner.nextInt();
               if (funkcja == 1){
                   index = 1;
                   System.out.println("Prosze wybrac ktora najemca bendzie wynajmowac mieszkanie: ");
                   for (Osoba osoba : Osoba.listaWszystkichNajemc){
                           System.out.println(index + "." + osoba);
                       index++;
                   }
                   System.out.print("Numer najemcy: ");
                   podFunkcja = scanner.nextInt();
                   index = 1;
                   System.out.println("Prosze wybrac date poczatku wynajmu:\n" +
                           "Rok(YYYY): ");
                   year = scanner.nextInt();
                   System.out.println("Miesiac(MM): ");
                   month = scanner.nextInt();
                   System.out.println("Dzien(DD): ");
                   day = scanner.nextInt();
                    c.set(year, --month, day, 0, 0);
                    start =c.getTime();
                   System.out.println("Prosze wybrac date koncu wynajmu:\n" +
                           "Rok(YYYY): ");
                   year = scanner.nextInt();
                   System.out.println("Miesiac(MM): ");
                   month = scanner.nextInt();
                   System.out.println("Dzien(DD): ");
                   day = scanner.nextInt();
                    c.set(year, --month, day, 0, 0);
                    end = c.getTime();
                   System.out.println("Prosze wybrac ktore mieszkanie?");
                   for (Mieszkanie mieszkanie : Mieszkanie.listaMieszkan){
                       if (mieszkanie.najemca == null) {
                           System.out.println(index + "." + mieszkanie);
                       }
                       index++;
                   }
                   System.out.print("Numer mieszkania: ");
                   funkcja = scanner.nextInt();
                   try {
                       Osoba.listaWszystkichNajemc.get(--podFunkcja).addMieszkanie(Mieszkanie.listaMieszkan.get(--funkcja),start,end);
                   } catch (ProblematicTenantException e) {
                       e.printStackTrace();
                   }
                   System.out.println("Najemce wynajmuje mieszkanie");
               }else if (funkcja==3){
               }else{
                   index=1;
                   System.out.println("Prosze wybrac osobe");
                   for (Osoba osoba : Osoba.listaWszystkichOsob) {
                       System.out.println(index + "." + osoba);
                       index++;
                   }
                   System.out.print("Numer osoby: ");
                   podFunkcja = scanner.nextInt();
                   Osoba.listaWszystkichOsob.get(--podFunkcja).typNajemca();
               }

           }else if (funkcja == 3){
               System.out.println(
                       "Czy jest osoba juz zarejestrowana?\n"+
                               "1.Tak\n"+
                               "2.Nie\n"+
                               "3.Exit"
               );
               funkcja = scanner.nextInt();
               if (funkcja == 1) {
                   index = 1;
                   System.out.println("Prosze wybrac osobe");
                   for (Osoba osoba : Osoba.listaWszystkichOsob) {
                       System.out.println(index + "." + osoba);
                       index++;
                   }
                   System.out.print("Numer osoby: ");
                   podFunkcja = scanner.nextInt();
                   index = 1;
                   System.out.println("Prosze wybrac ktore mieszkanie?");
                   for (Mieszkanie mieszkanie : Mieszkanie.listaMieszkan) {
                       System.out.println(index + "." + mieszkanie);
                       index++;
                   }
                   System.out.print("Numer mieszkania: ");
                   funkcja = scanner.nextInt();
                   Mieszkanie.listaMieszkan.get(--funkcja).addOsoba(Osoba.listaWszystkichOsob.get(--podFunkcja));
                   System.out.println("Osoba zameldowana w mieszkaniu");
               }else if (funkcja==3){

               }else
                   System.out.println("Prosze zarejestrowac osobe");


           }else if (funkcja == 4){
               index = 1;
               System.out.println("Prosze wybrac osobe");
               for (Osoba osoba : Osoba.listaWszystkichOsob) {
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer osoby: ");
               podFunkcja = scanner.nextInt();
               Osoba.listaWszystkichOsob.get(--podFunkcja).mieszkanie.removeOsoba(Osoba.listaWszystkichOsob.get(podFunkcja));
           }else if (funkcja == 5){
               index = 1;
               System.out.println("Prosze wybrac ktore mieszkanie?");
               for (Mieszkanie mieszkanie : Mieszkanie.listaMieszkan) {
                   System.out.println(index + "." + mieszkanie);
                   index++;
               }
               System.out.print("Numer mieszkania: ");
               funkcja = scanner.nextInt();
               System.out.println("Prosze wybrac date koncu wynajmu:\n" +
                       "Rok(YYYY): ");
               year = scanner.nextInt();
               System.out.println("Miesiac(MM): ");
               month = scanner.nextInt();
               System.out.println("Dzien(DD): ");
               day = scanner.nextInt();
               c.set(year, --month, day, 0, 0);
               end = c.getTime();
               Mieszkanie.listaMieszkan.get(--funkcja).przedluzycNajem(end);
           }else if (funkcja == 6){
               index = 1;
               System.out.println("Prosze wybrac ktore miejsce?");
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych) {
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.print("Numer miejsca: ");
               funkcja = scanner.nextInt();
               System.out.println(MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja).getPowierchnia());
           }else if (funkcja == 7){
               System.out.println("Kontynowac?\n" +
                       "1.Tak\n"+
                       "2.Nie"
               );
               Thing tt = null;
               funkcja = scanner.nextInt();
               if (funkcja == 1) {
                   System.out.println("Czy to jest pojazd?\n"+
                           "1.Tak\n"+
                           "2.Nie"
                   );
                   funkcja = scanner.nextInt();
                   if (funkcja == 2) {
                       index = 1;
                       System.out.println("Prosze ukazaz nazwe: ");
                       text = scanner.nextLine();
                       startDate = scanner.nextLine();
                       System.out.println("Prosze ukazac objetosc");
                       objetosc = scanner.nextDouble();
                       tt = new Thing(startDate,objetosc);
                   }else if (funkcja == 1){
                       startDate = "pojazd";
                       System.out.println("Prosze ukazac charakterystyke pojazdu:\n"+
                               "Typ pojazdu"
                       );
                       index = 1;
                       Pojazd.TypPojazdu [] tab = Pojazd.TypPojazdu.values();
                       for(Pojazd.TypPojazdu t : tab){
                           System.out.println(index + "." + t.name());
                           index++;
                       }
                       funkcja = scanner.nextInt();
                       typPojazdu = tab[--funkcja];
                       System.out.println("Typ silnika: ");
                       text = scanner.nextLine();
                       typSilnika = scanner.nextLine();
                       System.out.println("Max predkosc: ");
                       maxSpeed = scanner.nextDouble();
                       System.out.println("Pojemnosc silnika: ");
                       pojemnoscSilnika = scanner.nextDouble();
                       System.out.println("Prosze ukazac objetosc");
                       objetosc = scanner.nextDouble();
                       tt = new Pojazd(startDate,objetosc,typPojazdu,typSilnika,pojemnoscSilnika,maxSpeed);
                   }
                   index = 1;
                   System.out.println("Prosze wybrac ktore miejsce?");
                   for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych) {
                           System.out.println(index + "." + m);
                           index++;
                       }
                   System.out.print("Numer miejsca: ");
                   funkcja = scanner.nextInt();
                       try {
                           MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja).addThing(tt);
                       } catch (TooManyThingsException e) {
                           e.printStackTrace();
                       }

               }

           }else if (funkcja == 8){
               index = 1;
               System.out.println("Prosze wybrac ktore miejsce?");
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych) {
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.print("Numer miejsca: ");
               funkcja = scanner.nextInt();
               index = 1;
               System.out.println("Prosze ukazaz rzecz: ");
               for (Thing t : MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja).things){
                   System.out.println(index + "." + t);
                   index++;
               }
               podFunkcja = scanner.nextInt();

               MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(funkcja).removeThing(MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(funkcja).things.get(--podFunkcja));

           }else if(funkcja == 9){
               index = 1;
               System.out.println("Prosze wybrac ktore mieszkanie?");
               for (Mieszkanie mieszkanie : Mieszkanie.listaMieszkan) {
                   System.out.println(index + "." + mieszkanie);
                   index++;
               }
               System.out.print("Numer mieszkania: ");
               funkcja = scanner.nextInt();
               Mieszkanie.listaMieszkan.get(--funkcja).najemca.removeMieszkanie( Mieszkanie.listaMieszkan.get(funkcja));
           }else if(funkcja == 10){
               index = 1;
               System.out.println("Prosze wybrac najemce : ");
               for (Osoba osoba : Osoba.listaWszystkichNajemc){
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer najemcy: ");
               podFunkcja = scanner.nextInt();
               System.out.println(Osoba.listaWszystkichNajemc.get(--podFunkcja).getListaMieszkan());
           }else if (funkcja == 11){
               index = 1;
               System.out.println("Prosze wybrac osobe : ");
               for (Osoba osoba : Osoba.listaWszystkichOsobINajemc){
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer osoby: ");
               podFunkcja = scanner.nextInt();
               index = 1;
               System.out.println("Prosze wybrac miejsce: ");
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych){
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.println("Numer miejsca: ");
               funkcja = scanner.nextInt();
               Osoba.listaWszystkichOsobINajemc.get(--podFunkcja).addMiejsceParkingowe( MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja));
               System.out.println(najemca1.getListaMiejscParkingowych());
           }else if(funkcja == 12){
               index = 1;
               System.out.println("Prosze wybrac osobe : ");
               for (Osoba osoba : Osoba.listaWszystkichOsobINajemc){
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer najemcy: ");
               podFunkcja = scanner.nextInt();
               podFunkcja -= 1;
               index = 1;
               System.out.println("Prosze wybrac miejsce: ");
               for (MiejsceParkingowe m : Osoba.listaWszystkichOsobINajemc.get(podFunkcja).listaMiejscParkingowych){
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.println("Numer miejsca: ");
               funkcja = scanner.nextInt();
               funkcja -= 1;
               Osoba.listaWszystkichOsobINajemc.get(podFunkcja).removeMiejsceParkingowe(Osoba.listaWszystkichOsobINajemc.get(podFunkcja).listaMiejscParkingowych.get(funkcja));
           }else if (funkcja == 13){
               index = 1;
               System.out.println("Prosze wybrac osobe : ");
               for (Osoba osoba : Osoba.listaWszystkichOsobINajemc){
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer najemcy: ");
               podFunkcja = scanner.nextInt();
               System.out.println(Osoba.listaWszystkichOsobINajemc.get(--podFunkcja).getListaMiejscParkingowych());
           }else  if (funkcja == 14){
               index = 1;
               System.out.println("Prosze wybrac ktore mieszkanie?");
               for (Mieszkanie mieszkanie : Mieszkanie.listaMieszkan) {
                   System.out.println(index + "." + mieszkanie);
                   index++;
               }
               System.out.print("Numer mieszkania: ");
               funkcja = scanner.nextInt();
               Mieszkanie.listaMieszkan.get(--funkcja).getListeOsob();
           } else if(funkcja == 15){
               index = 1;
               System.out.println("Prosze wybrac miejsce: ");
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych){
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.println("Numer miejsca: ");
               funkcja = scanner.nextInt();
               System.out.println(MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja).getListeThings());
           }else if (funkcja == 16){
               index = 1;
               System.out.println("Prosze wybrac miejsce: ");
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych){
                   System.out.println(index + "." + m);
                   index++;
               }
               System.out.println("Numer miejsca: ");
               funkcja = scanner.nextInt();
               System.out.println("Prosze wybrac date koncu wynajmu:\n" +
                       "Rok(YYYY): ");
               year = scanner.nextInt();
               System.out.println("Miesiac(MM): ");
               month = scanner.nextInt();
               System.out.println("Dzien(DD): ");
               day = scanner.nextInt();
               c.set(year, --month, day, 0, 0);
               end = c.getTime();
               MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(--funkcja).przedluzycNajem(end);
           }else if (funkcja == 17){
               index = 1;
               System.out.println("Prosze wybrac osobe : ");
               for (Osoba osoba : Osoba.listaWszystkichOsobINajemc){
                   System.out.println(index + "." + osoba);
                   index++;
               }
               System.out.print("Numer najemcy: ");
               podFunkcja = scanner.nextInt();
               Osoba.listaWszystkichOsobINajemc.get(--podFunkcja).getListFile();
           } else if (funkcja == 18){
               exit = true;
           } else if (funkcja == 19){
               for(int i = Mieszkanie.listaMieszkan.size() - 1 ; i > 0 ; i--){
                   for(int j = 0 ; j < i ; j++){
                        if( Mieszkanie.listaMieszkan.get(j).powierzchnia > Mieszkanie.listaMieszkan.get(j+1).powierzchnia ){
                        Mieszkanie tmp = Mieszkanie.listaMieszkan.get(j);
                        Mieszkanie.listaMieszkan.set(j,Mieszkanie.listaMieszkan.get(j+1));
                        Mieszkanie.listaMieszkan.set(j+1,tmp);
                        }
                    }
                }
               for(int i = MiejsceParkingowe.listaWszystkichMiejscParkingowych.size() - 1 ; i > 0 ; i--){
                   for(int j = 0 ; j < i ; j++){
                       if( MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(j).objetosc > MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(j+1).objetosc ){
                           MiejsceParkingowe tmp = MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(j);
                           MiejsceParkingowe.listaWszystkichMiejscParkingowych.set(j, MiejsceParkingowe.listaWszystkichMiejscParkingowych.get(j+1));
                           MiejsceParkingowe.listaWszystkichMiejscParkingowych.set(j+1,tmp);
                       }
                   }
               }
               String inFileMiejsca = "";
               String inFileMieszkania = "";
               for(Mieszkanie m : Mieszkanie.listaMieszkan){
                   inFileMieszkania += m + " , Najemce : " + m.najemca +"\n";
                   m.getListeOsob();
               }
               for (MiejsceParkingowe m : MiejsceParkingowe.listaWszystkichMiejscParkingowych){
                   inFileMiejsca += m + "\n ";
               }
               List<String> lines = Arrays.asList(" " + osiedla.nazwaOsiedli,"Wszystkie mieszkania: ",inFileMieszkania,"Wszytskie miejsca parkingowe ", inFileMiejsca);
               Path file = Paths.get("Stan osiedli.txt");
               try {
                       File stan = Files.write(file, lines, StandardCharsets.UTF_8).toFile();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

       }
       dc.stop();
       dt.stop();


    }
}
