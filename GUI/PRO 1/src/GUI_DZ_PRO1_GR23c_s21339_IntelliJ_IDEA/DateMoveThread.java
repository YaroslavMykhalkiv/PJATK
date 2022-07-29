package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

import java.util.Calendar;

public class DateMoveThread extends  Thread {


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Mieszkanie.listaMieszkan.forEach(mieszkanie ->{
                    if (mieszkanie.currentDate != null) {
                        Calendar c = Calendar.getInstance();
                        c.setTime(mieszkanie.currentDate);
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        mieszkanie.currentDate = c.getTime();
                    }
                });
                MiejsceParkingowe.listaWszystkichMiejscParkingowych.forEach(miejsceParkingowe ->{
                    if (miejsceParkingowe.currentDate != null) {
                        Calendar c = Calendar.getInstance();
                        c.setTime(miejsceParkingowe.currentDate);
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        miejsceParkingowe.currentDate = c.getTime();
                    }
                });
                sleep(5000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
