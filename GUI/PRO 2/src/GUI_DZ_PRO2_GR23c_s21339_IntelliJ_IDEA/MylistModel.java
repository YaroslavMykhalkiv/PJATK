package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import javax.swing.*;
import java.util.List;

public class MylistModel extends AbstractListModel<String> {
    List<String> list;

    public MylistModel(List<String> list){
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public String getElementAt(int i) {
        return list.get(i);
    }
}
