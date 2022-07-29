package GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.stage.Screen;
import javafx.util.Duration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Game extends Application {
    public static int day = 0;
    double speed = 2;
    double crSize = 30 ;
    public static Pane pane1 = new Pane();
    public static Pane pane2 = new Pane();
    public static TextField dayPoints = new TextField();
    public static TextField setLevel = new TextField();
    public Label label = new Label("Prosze wpisac poziom trudnosci( 1-3 ): ");
    Screen screen = Screen.getPrimary();
    Rectangle2D screenBounds = screen.getBounds();
    double xSize = screenBounds.getWidth();
    double ySize = screenBounds.getHeight();
    Button ok = new Button("OK");
    Button improvements = new Button("Improvements");
    static JButton jbutton = new JButton("OK");
    static Button end = new Button("end");
    ImprovementWindow improvementWindow ;
    static BorderPane root = new BorderPane();
    static BorderPane root4 = new BorderPane();
    static JTextField nickName = new JTextField(16);


    @Override
    public void start(Stage primaryStage) {
        improvementWindow = new ImprovementWindow();
        BorderPane root2 = new BorderPane();
        BorderPane root3 = new BorderPane();
        VBox vbox = new VBox();
        Button start = new Button("New Game");
        Button exit = new Button("Exit");
        Button records = new Button("High Score");
        Country russia = new Country(960, 150, 100,"Russia",168000000);
        Country china = new Country(xSize-250, ySize-500, 50,"China",1700000000);
        Country ukraine = new Country(870, 300, 40,"Ukraine",45000000);
        Country canada = new Country(130, 100, 70,"Canada",38000000);
        Country poland = new Country(800, 290, crSize,"Poland",38000000);
        Country germany = new Country(750, 250, crSize,"Germany",83000000);
        Country france = new Country(700, 310, crSize,"France",66000000);
        Country india = new Country(1050, 400, 50,"India",1353000000);
        Country america = new Country(100, 250, 70,"America",328000000);
        Country italy = new Country(640, 350, crSize,"Italy",60000000);
        Country british = new Country(800, 190, 40,"British",66000000);
        Country spain = new Country(610, 280, crSize,"Spain",46000000);
        Country turkey = new Country(860, 400, crSize,"Turkey",82000000);
        Country kazahstan = new Country(960, 300, 40,"Kazahstan",18000000);

        dayPoints.setTranslateX(1300);
        improvements.setPrefSize(300,50);
        improvements.setStyle("-fx-background-color: gray");
        improvements.setFont(new Font("",30));
        end.setPrefSize(xSize,ySize);
        end.setStyle("-fx-background-color: gray");
        end.setFont(new Font("",30));

        final KeyCombination keyCombinationCTRC = new KeyCodeCombination(
                KeyCode.Q, KeyCombination.CONTROL_DOWN);


        pane2.getChildren().add(setLevel);
        pane1.getChildren().add(dayPoints);

        vbox.getChildren().addAll(start,records,exit);
        vbox.setAlignment(Pos.CENTER);
        root2.setCenter(vbox);

        root.setCenter(pane1);
        root.setBottom(improvements);
        root.getChildren().addAll(
                setPlain(7,america,russia),
                setPlain(8,canada,france),
                setPlain(6,spain,china),
                setPlain(4,germany,spain),
                setPlain(6,france,russia),
                setPlain(7,poland,china),
                setPlain(5,british,turkey),
                setPlain(7,kazahstan,russia),
                setShip(8,germany,america),
                setShip(8,poland,canada),
                setShip(6,ukraine,spain),
                setShip(6,british,america),
                setShip(6,india,china)
        );
        setBus(poland,germany);setBus(germany,france);setTrain(france,italy);
        setBus(italy,ukraine);setBus(kazahstan,india);setTrain(kazahstan,ukraine);setBus(india,turkey);
        setTrain(canada,america);setBus(italy,british);setTrain(italy,turkey);

        for (Country c : Country.listOfCountry) {
            root.getChildren().add(c);
            setButtonAction(c);
        }

        root3.setCenter(pane2);
        root3.setTop(label);
        root3.setRight(ok);
        root4.setBottom(end);

        Scene menu = new Scene(root2, xSize, ySize);
        Scene level = new Scene(root3,300,100);

        dayPoints.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (keyCombinationCTRC.match(event)) {
                    primaryStage.setScene(menu);
                }
            }
        });
        start.setOnAction(actionEvent -> {
            primaryStage.setScene(level);
        });
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                try {
                    String path = "src\\GUI_DZ_PRO2_GR23c_s21339_IntelliJ_IDEA\\Records";
                    String text = nickName.getText() + " Score: " + ((int)((ThreaOfInfection.sumaPopulation - ThreaOfInfection.sumaCured) / CoronaVirus.infectionRate * CoronaVirus.curedRate)/1000000) + "\n";
                    Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
        ok.setOnAction(actionEvent -> {
            Scene map = new Scene(root, xSize, ySize-50);
            primaryStage.setScene(map);
            new CoronaVirus(Integer.parseInt(setLevel.getText()));
            MyDaysThread t = new MyDaysThread();
            PrepareVaccineThread p = new PrepareVaccineThread();
            GivePointsThread g = new GivePointsThread();
            ThreaOfInfection tt = new ThreaOfInfection();
            t.start();
            g.start();
            tt.start();
            p.start();
        });
        exit.setOnAction(actionEvent -> {
            primaryStage.close();
        });
        records.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new HighScore();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        improvements.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                improvementWindow.createWindow();
            }
        });
        primaryStage.setFullScreenExitKeyCombination(keyCombinationCTRC);
        primaryStage.setScene(menu);
        primaryStage.show();
    }

    public Node setPlain(double speed, Country first,Country second){
        first.tabOfCountry.add(second);
        second.tabOfCountry.add(first);
        int repeats = Timeline.INDEFINITE;
        TranslateTransition t = new TranslateTransition(Duration.seconds(speed),first.plane);
        t.setToX(second.x-first.x);
        t.setToY(second.y-first.y);
        t.setCycleCount(repeats);
        t.setAutoReverse(true);
        t.setInterpolator(Interpolator.EASE_BOTH);
        t.play();
        return  first.plane;
    }

    public void setTrain(Country first,Country second){
        first.tabOfCountry.add(second);
        second.tabOfCountry.add(first);
    }

    public void setBus(Country first,Country second){
        first.tabOfCountry.add(second);
        second.tabOfCountry.add(first);
    }

    public Node setShip(double speed, Country first,Country second){
        first.tabOfCountry.add(second);
        second.tabOfCountry.add(first);
        int repeats = Timeline.INDEFINITE;
        TranslateTransition t = new TranslateTransition(Duration.seconds(speed),first.ship);
        t.setToX(second.x-first.x);
        t.setToY(second.y-first.y);
        t.setCycleCount(repeats);
        t.setAutoReverse(true);
        t.setInterpolator(Interpolator.EASE_BOTH);
        t.play();
        return  first.ship;
    }

    public void setButtonAction(Country circle){
        circle.setOnMouseClicked(mouseEvent -> {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                   circle.getInfo();
                }
            });
        });
    }

    public static void koniecGry(){
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("Enter your name: ");
        jPanel.add(jLabel);
        jPanel.add(nickName);
        jPanel.add(jbutton);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(jPanel);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(1100,300));
        root = root4;
    }

    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }

}