package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckCloseDateThread extends  Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Mieszkanie.listaMieszkan.forEach(mieszkanie ->{
                    if (mieszkanie.currentDate != null) {
                        if (mieszkanie.currentDate.compareTo(mieszkanie.endDate) > 0) {
                            Calendar c = Calendar.getInstance();
                            long diffInMillies = Math.abs(mieszkanie.currentDate.getTime() - mieszkanie.endDate.getTime());
                            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                            if (diff > 30) {
                                System.out.println("Mieszkanie " + mieszkanie.idMieszkania + " zostalo odebrane przez dlugie zadluzenia");
                                c.setTime(mieszkanie.currentDate);
                                c.add(Calendar.YEAR, 10000);//usuwam obiekt file z listy File
                                try {
                                    mieszkanie.przedluzycNajem(c.getTime());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mieszkanie.najemca.removeMieszkanie(mieszkanie);
                                for (MiejsceParkingowe m : mieszkanie.najemca.listaMiejscParkingowych) {
                                    for (Thing t : m.things) {
                                        if (t.nazwaRzeczy.toLowerCase() == "pojazd") {
                                            c.setTime(m.endDate);
                                            c.add(Calendar.MONTH, 2);
                                            m.endDate = c.getTime();
                                        }
                                    }
                                    m.things.clear();
                                }
                                mieszkanie.najemca.listaMiejscParkingowych.clear();
                                mieszkanie.najemca.removeMieszkanie(mieszkanie);
                            }
                            List<String> lines = Arrays.asList("Trzeba przedluzyc najem mieszkania: ", mieszkanie.idMieszkania);
                            Path file = Paths.get(mieszkanie.idMieszkania + " Przedluzenia.txt");
                            try {
                                if (!mieszkanie.najemca.listaFile.contains(Files.write(file, lines, StandardCharsets.UTF_8).toFile()))
                                    mieszkanie.najemca.listaFile.add(Files.write(file, lines, StandardCharsets.UTF_8).toFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                sleep(10000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
