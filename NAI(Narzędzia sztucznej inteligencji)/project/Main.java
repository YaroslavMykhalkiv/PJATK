package NAI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scannerTest = null;
        Scanner scannerTrain = null;
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        try {
            scannerTest = new Scanner(new File(args[0]));
            scannerTrain = new Scanner(new File(args[1]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Kwiat> kwiatyTest = new ArrayList<>();
        List<Kwiat> kwiatyTrain = new ArrayList<>();
        while (scannerTest.hasNextLine()){
            String[] tab = scannerTest.nextLine().split(",");
            kwiatyTest.add(new Kwiat(Double.parseDouble(tab[1]),
                    Double.parseDouble(tab[2]),Double.parseDouble(tab[3]),Double.parseDouble(tab[4]),tab[5]));
        }
        while (scannerTrain.hasNextLine()){
            String[] tab = scannerTrain.nextLine().split(",");
            kwiatyTrain.add(new Kwiat(Double.parseDouble(tab[1]),
                    Double.parseDouble(tab[2]),Double.parseDouble(tab[3]),Double.parseDouble(tab[4]),tab[5]));

        }
        for (Kwiat a : kwiatyTest){
            for (Kwiat b : kwiatyTrain){
                b.calcDystance(a);
            }
            kwiatyTrain.sort(Comparator.comparing(Kwiat::getDystance));
            a.calcKlasse(kwiatyTrain.subList(0, Integer.parseInt(args[2])));
        }
        System.out.println("procent  " + Kwiat.calcProcent(kwiatyTest));
        List<Kwiat> kwiatyConsole = new ArrayList<>();
        int k = 0;
        while (isTrue){
            System.out.println("Zakonczyc wprowadzzenie dannych - wprowadz liczbe K\n" +
                    "Prosze wprowadzic dane przez przecinek(SepalLengthCm,SepalWidthCm,PetalLengthCm,PetalWidthCm): ");
            String str = scanner.nextLine();
            if (str.matches("\\d+")) {
                k = Integer.parseInt(str);
                break;
            }else {
                String[] tab = str.split(",");
                kwiatyConsole.add(new Kwiat(Double.parseDouble(tab[0]),
                        Double.parseDouble(tab[1]), Double.parseDouble(tab[2]), Double.parseDouble(tab[3])));
            }
        }
        for (Kwiat a : kwiatyConsole){
            for (Kwiat b : kwiatyTrain){
                b.calcDystance(a);
            }
            kwiatyTrain.sort(Comparator.comparing(Kwiat::getDystance));
            a.calcKlasse(kwiatyTrain.subList(0, k));
        }
        System.out.println(kwiatyConsole);


    }
}
