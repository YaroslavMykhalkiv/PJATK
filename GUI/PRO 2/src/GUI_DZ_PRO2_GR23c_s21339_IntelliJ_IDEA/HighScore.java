package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;


import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighScore extends JFrame {

    public HighScore() throws FileNotFoundException {
        List<String > list = new ArrayList<>();
        JList<String> jList = new JList<>();
        FileReader fr = new FileReader("src\\GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA\\Records");
        Scanner scanner = new Scanner(fr);
        String s;
        while (scanner.hasNextLine()){
            s = scanner.nextLine();
            list.add(s);
        }
        MylistModel mylistModel = new MylistModel(list);
        jList.setModel(mylistModel);
        add(new JScrollPane(jList));
        setSize (400,600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            new HighScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
