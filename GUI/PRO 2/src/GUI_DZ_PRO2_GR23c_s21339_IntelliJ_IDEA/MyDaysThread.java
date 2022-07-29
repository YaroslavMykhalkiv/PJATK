package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

public class MyDaysThread extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Game.dayPoints.setText("Day: " + Game.day++ + "    Points: " + Country.points );//jesli rzuca bled, to przez ten "setText"
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
