package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InfoAboutCountry {
    String country;
    int infected = 0,deaded = 0,cured = 0;
    public JLabel label1 = new JLabel();
    public JLabel label2 = new JLabel();
    public JLabel label3 = new JLabel();
    public JLabel label4 = new JLabel();
    JFrame frame = new JFrame(country);
    public InfoAboutCountry(String country, int population){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JPanel jPanel = new JPanel();
        JButton exit = new JButton("ok");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
            }
        });
        frame.setTitle(country);
        label1.setText(" Population : " + population);
        label2.setText(" Infected : " + infected);
        label3.setText(" Deaded :" + deaded);
        label4.setText(" Cured :" + cured);

        label1.setBounds(0,-80,500,200);
        label2.setBounds(0,-60,500,200);
        label3.setBounds(0,-40,500,200);
        label4.setBounds(0,-20,500,200);

        exit.setBounds(160,100,50,30);
        jPanel.add(exit);
        jPanel.setLayout(null);
        frame.toFront();
        frame.setState(JFrame.NORMAL);

        frame.getContentPane().add(label1);
        frame.getContentPane().add(label2);
        frame.getContentPane().add(label3);
        frame.getContentPane().add(label4);

        frame.add(jPanel);
        frame.setPreferredSize(new Dimension(400,200));
        frame.pack();
        frame.setVisible(false);

    }
    public void createGUI() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InfoAboutCountry(null,123123123);

            }
        });
    }
}
