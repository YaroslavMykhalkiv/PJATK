package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import javax.swing.*;

public class MyJButton extends JButton {
    public int price;
    public MyJButton(String text,int price){
        super(text);
        this.price = price;
    }
}
