import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    private JButton showBtn;
    private JPanel welcomePanel;
    private JPanel extraPanel;
    private JPanel datePanel;
    private JButton btnBackDate;
    private JTextField fieldTo;
    private JTextField fieldFrom;
    private JButton okButton;
    private JList listRezerwacje;
    private JPanel panelRezerwacje;
    private JButton btnChange;
    private JButton btnExitRezerwacje;
    private DefaultListModel listModelRezerwacje;
    private DefaultListModel listModelPokoje;
    private List<Rezerwacja> rezerwacje = new ArrayList<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel panelPokoj;
    private JLabel labelIdRezerwacje;
    private JList listPokoje;
    private JButton btnExitPokoj;
    private JButton btnBackPokoj;


    public Window() {
        setContentPane(welcomePanel);
        setTitle("Hotel");
        setSize(850, 400);
        setMinimumSize(new Dimension(850,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        datePanel.setVisible(false);
        panelRezerwacje.setVisible(false);
        panelPokoj.setVisible(false);
        listModelRezerwacje = new DefaultListModel();
        listRezerwacje.setModel(listModelRezerwacje);
        listModelPokoje = new DefaultListModel();
        listPokoje.setModel(listModelPokoje);

        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(welcomePanel);
                setContentPane(datePanel);
                datePanel.setVisible(true);
                validate();
            }
        });
        btnBackDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(datePanel);
                fieldFrom.setText("");
                fieldTo.setText("");
                setContentPane(welcomePanel);
                datePanel.setVisible(true);
                validate();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectInputStream read = new ObjectInputStream(new FileInputStream("extent.txt"));
                    listModelRezerwacje.removeAllElements();
                    Rezerwacja.readExtent(read);
                    rezerwacje = Rezerwacja.wyswietlRezerwacjeWZadanymOkresie(Rezerwacja.format.parse(fieldFrom.getText()), Rezerwacja.format.parse(fieldTo.getText()));
                    rezerwacje.forEach(r -> {
                        System.out.println(r);
                        listModelRezerwacje.addElement(r);
                    });
                    if (listModelRezerwacje.size() == 0) {
                        Object[] options = {"Wyjsc", "Zmienic okres"};
                        int result = JOptionPane.showOptionDialog(null,
                                "Nie zlaleziono rezerwacje",
                                "Warning",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if (result == JOptionPane.YES_OPTION) {
                            remove(datePanel);
                            fieldFrom.setText("");
                            fieldTo.setText("");
                            setContentPane(welcomePanel);
                            datePanel.setVisible(true);
                            validate();                        }
                        return;
                    }
                    remove(datePanel);
                    setContentPane(panelRezerwacje);
                    panelRezerwacje.setVisible(true);
                    validate();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(Window.this,
                            "Nie poprawna data albo format daty",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelRezerwacje);
                panelRezerwacje.setVisible(false);
                setContentPane(datePanel);
                datePanel.setVisible(true);
                validate();
            }
        });
        btnExitRezerwacje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelRezerwacje);
                fieldFrom.setText("");
                fieldTo.setText("");
                panelRezerwacje.setVisible(false);
                setContentPane(welcomePanel);
                datePanel.setVisible(true);
                validate();
            }
        });
        listRezerwacje.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listModelPokoje.removeAllElements();
                int index = listRezerwacje.getSelectedIndex();
                if (index<0){
                    return;
                }
                Rezerwacja selectedRez = (Rezerwacja) listModelRezerwacje.get(index);
                labelIdRezerwacje.setText("Rezerwacja ID=" + selectedRez.getId());
                selectedRez.getPokojs().forEach(p -> {
                    listModelPokoje.addElement(p.wyswieltInfoPokokoju());
                });
                remove(panelRezerwacje);
                setContentPane(panelPokoj);
                panelPokoj.setVisible(true);
                validate();
            }
        });
        btnExitPokoj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelPokoj);
                fieldFrom.setText("");
                fieldTo.setText("");
                panelRezerwacje.setVisible(false);
                setContentPane(welcomePanel);
                validate();
            }
        });
        btnBackPokoj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelPokoj);
                setContentPane(panelRezerwacje);
                validate();
            }
        });
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}


