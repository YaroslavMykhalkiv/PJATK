package NAI;

import java.util.List;

public class Kwiat implements Comparable<Kwiat>{
    double sepalLen;
    double sepalWid;
    double pentalLen;
    double pentalWid;
    klassaKwiat kk;
    klassaKwiat compareKK;
    double dystance;

    @Override
    public int compareTo(Kwiat o) {
        return 0;
    }

    public enum klassaKwiat{setosa,versicolor,virginica}

    public Kwiat(double sepalLen, double sepalWid, double pentalLen, double pentalWid){
        this.sepalLen = sepalLen;
        this.sepalWid = sepalWid;
        this.pentalLen = pentalLen;
        this.pentalWid = pentalWid;
    }

    public Kwiat(double sepalLen, double sepalWid, double pentalLen, double pentalWid, String kwiat){
        this.sepalLen = sepalLen;
        this.sepalWid = sepalWid;
        this.pentalLen = pentalLen;
        this.pentalWid = pentalWid;
        setKlasseKwiat(kwiat);
    }

    public double calcDystance(Kwiat kwiat){
        return dystance = Math.sqrt(Math.pow(sepalLen- kwiat.sepalLen,2 ) + Math.pow(sepalWid- kwiat.sepalWid,2 )
                + Math.pow(pentalLen - kwiat.pentalLen,2 ) + Math.pow(pentalWid- kwiat.pentalWid,2 ));
    }

    public double getDystance(){
        return dystance;
    }

    public klassaKwiat setKlasseKwiat(String str){
        if (str.contains("setosa"))
            kk = klassaKwiat.setosa;
        if (str.contains("versicolor"))
            kk = klassaKwiat.versicolor;
        if (str.contains("virginica"))
            kk = klassaKwiat.virginica;
        return kk;
    }

    public klassaKwiat calcKlasse(List<Kwiat> lista){
        int setosa = 0;
        int versicolor = 0;
        int virginica = 0;
        klassaKwiat best = klassaKwiat.virginica;
        for (Kwiat x : lista){
            if (x.kk == klassaKwiat.setosa)
                setosa++;
            if (x.kk == klassaKwiat.versicolor)
                versicolor++;
            if (x.kk == klassaKwiat.virginica)
                virginica++;
        }
        if (setosa > virginica){
            if (virginica >= versicolor)
                best = klassaKwiat.setosa;
            else if (versicolor > setosa)
                best = klassaKwiat.versicolor;
        }else if (versicolor > virginica){
            best = klassaKwiat.versicolor;
        }
        if (kk == null)
            return kk = best;
        return  compareKK = best;
    }

    public static double calcProcent(List<Kwiat> lista){
        double procent = 0;
        for (Kwiat x : lista){
            if (x.kk == x.compareKK)
                procent++;
        }
        return (procent/35*100);
    }

    @Override
    public String toString() {
        return "" + kk;
    }
}
