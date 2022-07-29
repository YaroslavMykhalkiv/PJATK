import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;

public class s21339 {

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        Scanner scanner;
        try {
            scanner = new Scanner(path);
            String str ;
            Etykiet glowny = new Etykiet();
            while(scanner.hasNextLine()){
                str = scanner.nextLine();
                char e = str.charAt(0);
                if (str.length() > 1) {
                    String droga = str.substring(2);
                    Etykiet t = glowny;
                    for (int i = 0; i < droga.length(); i++) {
                        t = t.get(droga.charAt(i));
                    }
                    t.glowny = e;
                }else{
                    glowny.glowny = e;
                }
            }
            System.out.println(Etykiet.getWord(glowny));
            scanner.close();
        } catch (Exception e) {}
    }
}

class Etykiet extends Object{
    char glowny;
    Etykiet L;
    Etykiet R;
    Etykiet extend;

    static String message = "";
    static String curMessage = "";

    public Etykiet get(char lr) {
        if (R == null)
            R = new Etykiet();
        if (L == null)
            L = new Etykiet();
        if (lr == 'R') {
            R.extend = this;
            return R;
        } else if (lr == 'L') {
            L.extend = this;
            return L;
        }
        return null;
    }

    public static void sprawdz(Etykiet etykiet) {
        if (etykiet == null) {
            if(!message.equals("")){
                Comparator<String> comp = Comparator.naturalOrder();
                if(comp.compare(curMessage,message) > 0)
                    message = curMessage;
            }else
                message = curMessage;
        } else {
            curMessage += etykiet.glowny;
            sprawdz(etykiet.extend);
        }
        curMessage = "";
    }

    public static String getWord(Etykiet etykiet) {
        if (etykiet.R != null)
            getWord(etykiet.R);
        if (etykiet.L != null)
            getWord(etykiet.L);
        if (etykiet.L == null && etykiet.R == null)
            sprawdz(etykiet);
        return message;
    }



}

