package GUI_DZ_PRO1_GR23c_s21339_IntelliJ_IDEA;

import java.util.ArrayList;

public class Osiedla {
    String nazwaOsiedli;
    ArrayList<Mieszkanie> listaMieszkan = new ArrayList<>();
    public Osiedla(String nazwaOsiedli){
        this.nazwaOsiedli = nazwaOsiedli;
    }

    public void addMieszkanie(Mieszkanie m){
        listaMieszkan.add(m);
        m.osiedla = this;
    }

    public void removeMieszkanie(Mieszkanie m){
        listaMieszkan.remove(m);
    }
}
