package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;


import javafx.scene.paint.Color;

public class ThreaOfInfection extends Thread {
    static long sumaPopulation = 0;
    static long sumaCured = 0;
    @Override
    public void run() {
        int x = 0;
        int i = 0;

        while (!Thread.currentThread().isInterrupted()) {
            int countInfected = 0;
            int countCured = 0;
            sumaPopulation = 0;
            sumaCured = 0;
            for (Country c : Country.listOfCountry){
                sumaCured += c.cured;
                sumaPopulation += c.population;
                if (c.infected < c.population / 5) {
                    c.setFill(Color.DARKGREEN);
                }
                if (c.infected > c.population / 5) {
                    c.setFill(Color.GREENYELLOW);
                }
                if (c.infected > c.population / 5 * 2) {
                    c.setFill(Color.YELLOW);
                }
                if (c.infected > c.population / 5 * 3) {
                    c.setFill(Color.ORANGE);
                }
                if (c.infected > c.population / 5 * 4) {
                    c.setFill(Color.RED);
                }
                if (c.isAllInfected) {
                    c.setFill(Color.BLACK);
                }
                c.plane.setFill(Color.GRAY);
                for (Country cc : c.tabOfCountry) {
                    if (cc.infected > cc.population/100000) {
                        c.infected += 1;
                        c.isAllCured = false;
                        cc.isAllCured  = false;
                    }
                }
                if (c.infected != 0) {
                    if (!c.isAllInfected && !c.isAllCured) {
                        c.infected++;
                        c.infected += (int) (c.infected * CoronaVirus.infectionRate);
                    }else
                        c.infected--;
                    c.cured += (int) ((c.infected * CoronaVirus.infectionRate) * CoronaVirus.curedRate);
                    c.deaded += (int) ((c.infected * CoronaVirus.infectionRate) * CoronaVirus.deadRate) + i;
                    c.population -= (int) ((c.infected * CoronaVirus.infectionRate) * CoronaVirus.deadRate);
                    c.infected -= (int) (((c.infected * CoronaVirus.infectionRate) * CoronaVirus.deadRate)  + ((c.infected * CoronaVirus.infectionRate) * CoronaVirus.curedRate)) ;
                    if (c.infected + c.cured >= c.population) {
                        c.isAllInfected = true;
                        c.cured -= ((c.infected + c.cured) - c.population);

                    }
                    if (c.cured > c.infected){
                        c.isAllCured = true;
                    }

                    c.testFrame.label1.setText(" Population : " + c.population);
                    c.testFrame.label2.setText(" Infected : " + c.infected);
                    c.testFrame.label3.setText(" Deaded :" + c.deaded);
                    c.testFrame.label4.setText(" Cured :" + c.cured);
                }else{
                    c.isAllCured = true;
                }
                if (c.isAllInfected)
                    countInfected++;
                if (c.isAllCured)
                    countCured++;
            }
            if (countInfected == 14){
                System.out.println(
                        "Game over\n" +
                        "All people are infected");
                System.exit(0);
            }
            if (countCured == 14){
                Game.koniecGry();
                System.out.println(
                        "You win" +
                        "\nAll people are Cured" +
                        "\n Your score is: " +
                                (int)((sumaPopulation-sumaCured) / CoronaVirus.infectionRate * CoronaVirus.curedRate)/1000000 );
            }

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
