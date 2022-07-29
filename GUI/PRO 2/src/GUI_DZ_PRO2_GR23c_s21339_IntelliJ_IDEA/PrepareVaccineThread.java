package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import java.awt.*;

public class PrepareVaccineThread extends Thread {
    @Override
    public void run() {
        int p = 0;
        while (!Thread.currentThread().isInterrupted()) {
            if (ImprovementWindow.vaccine.getBackground() == Color.ORANGE && p <= 100) {
                ImprovementWindow.vaccine.setText("Vaccine is preparing: " + p++ + "%");
            } else if (p == 101) {
                ImprovementWindow.createVaccine();
                p++;
                this.stop();
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
