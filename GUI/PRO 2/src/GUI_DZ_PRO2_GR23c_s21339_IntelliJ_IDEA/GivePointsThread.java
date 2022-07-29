package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

public class GivePointsThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (Country c : Country.listOfCountry){
                if (Math.random() > 0.5 && c.infected != 0)
                    Country.points++;
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
