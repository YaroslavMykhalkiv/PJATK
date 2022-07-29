package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImprovementWindow extends JFrame{
    String text;
    static MyJButton vaccine = new MyJButton("Scientists will start making a vaccine(++cured,-dead)",50);

    public ImprovementWindow(){
        setTitle("Improvements");
        JFrame.setDefaultLookAndFeelDecorated(true);
        JPanel jPanel = new JPanel();
        JButton exit = new JButton("ok");
        exit.setBackground(Color.GRAY);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
        MyJButton quarantine = new MyJButton("Activate a quarantine (-infection)",25);
        MyJButton immunity = new MyJButton("Increase immunity(-dead,+cured)",30);
        MyJButton washHands = new MyJButton("People will wash their hands(-infection)",15);
        MyJButton closeBorder = new MyJButton("Border will be closed(-infection)",20);
        MyJButton masks = new MyJButton("People will wear masks(-infection)",15);
        MyJButton hospitals = new MyJButton("Countries will build a new Hospitals(-dead,+cured)",35);
        MyJButton disinfection = new MyJButton("Public places will be disinfected(-infection)",10);

        setButtonColor(quarantine);
        setButtonColor(immunity);
        setButtonColor(washHands);
        setButtonColor(closeBorder);
        setButtonColor(masks);
        setButtonColor(hospitals);
        setButtonColor(vaccine);
        setButtonColor(disinfection);

        jPanel.add(quarantine);
        jPanel.add(immunity);
        jPanel.add(washHands);
        jPanel.add(closeBorder);
        jPanel.add(masks);
        jPanel.add(hospitals);
        jPanel.add(disinfection);
        jPanel.add(exit);
        jPanel.add(vaccine);
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setLayout(new GridLayout(3,3,5,5));

        vaccine.setBackground(Color.RED);
        quarantine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - quarantine.price >= 0 && closeBorder.getBackground() != Color.GREEN) {
                    CoronaVirus.infectionRate /= 2;
                    quarantine.setText("Quarantine introduced");
                }
            }
        });
        immunity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - immunity.price >= 0 && closeBorder.getBackground() != Color.GREEN) {
                    CoronaVirus.deadRate /= 2;
                    immunity.setText("Immunity increased");
                }

            }
        });
        washHands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - washHands.price >= 0 && closeBorder.getBackground() != Color.GREEN) {
                   CoronaVirus.infectionRate /= 1.2;
                   washHands.setText("People wash their hands every day");}

            }
        });
        vaccine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - vaccine.price >= 0 && vaccine.getBackground() != Color.GREEN && vaccine.getBackground() != Color.ORANGE) {
                    Country.points -= vaccine.price;
                    vaccine.setBackground(Color.ORANGE);
                }

            }
        });
        disinfection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - disinfection.price >= 0 && closeBorder.getBackground() != Color.GREEN){
                CoronaVirus.infectionRate /= 1.2;
                disinfection.setText("Public places is disinfected");
                }
            }
        });
        hospitals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - hospitals.price >= 0 && closeBorder.getBackground() != Color.GREEN){
                CoronaVirus.deadRate /= 1.3;
                CoronaVirus.curedRate *= 3;
                hospitals.setText("Hospitals are built");
                }

            }
        });
        masks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - masks.price >= 0 && closeBorder.getBackground() != Color.GREEN){
                CoronaVirus.infectionRate /= 1.3;
                masks.setText("People are wearing masks");
                }

            }
        });
        closeBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Country.points - closeBorder.price >= 0 && closeBorder.getBackground() != Color.GREEN){
                    CoronaVirus.infectionRate /= 1.5;
                    closeBorder.setText("Border is closed");

                }
            }
        });

        toFront();
        setState(JFrame.NORMAL);
        add(jPanel);
        setPreferredSize(new Dimension(1100,300));
        pack();
        setVisible(false);
    }

    public void setButtonColor(MyJButton b){
        b.setBackground(Color.RED);
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (Country.points - b.price >= 0 && b.getBackground() != Color.GREEN  && b != vaccine) {
                    b.setBackground(Color.GREEN);
                    Country.points -= b.price;
                    Country.chance -= 0.025;
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                text = b.getText();
                b.setText("Price: " + b.price);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                b.setText(text);
            }
        });

    }

    public void createWindow(){setVisible(true);}

    public static void createVaccine(){
        CoronaVirus.curedRate = 0.9;
        CoronaVirus.deadRate /= 1.2;
        vaccine.setText("Vaccine is ready");
        vaccine.setBackground(Color.GREEN);
        Country.chance -= 0.025;
    }

    public static void main(String[] args) {
        new ImprovementWindow();
    }
}
