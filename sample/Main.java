package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

import java.util.Queue;

public class Main extends Application implements EventHandler<ActionEvent> {
    Stage window;
    Scene menuScene, buisson, herbe, hexamaze, sierpinski;


    GraphicsContext gc;


    MenuItem menuItem1;
    MenuItem menuItem2;
    MenuItem menuItem3;
    MenuItem menuItem4;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;


        //Menu
        Menu menu = new Menu("Draw");
        menuItem1 = new MenuItem("Buisson");
        menuItem1.setOnAction(this);
        menuItem2 = new MenuItem("Herbe");
        menuItem2.setOnAction(this);
        menuItem3 = new MenuItem("Hexamaze");
        menuItem3.setOnAction(this);
        menuItem4 = new MenuItem("Sierpinski");
        menuItem4.setOnAction(this);

        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menuItem4);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);



        //Menu Scene
        Label label = new Label("Devoir IFT 2015 - Antoine Marcotte ~ Ethan MAI");
        VBox layout = new VBox(menuBar);
        layout.getChildren().add(label);
        menuScene = new Scene(layout, 800, 600);



        window.setScene(menuScene);
        window.show();
    }





    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==menuItem1) {
            System.out.println("Buisson");
            createBuissonScene();
        }
        else if(actionEvent.getSource()==menuItem2) {
            System.out.println("Herbe");
            createHerbeScene();
        }
        else if(actionEvent.getSource()==menuItem3) {
            System.out.println("Hexamaze");
            createHexamazeScene();
        }
        else if(actionEvent.getSource()==menuItem4) {
            System.out.println("Sierpinski");
            createSierpinskiScene();
        }
    }




    //Scenes

    public void createBuissonScene() {

        final Canvas canvas = new Canvas(300,300);
        gc = canvas.getGraphicsContext2D();
        Label label = new Label("Buisson");
        VBox layout = new VBox();
        layout.getChildren().addAll(label, canvas);
        buisson = new Scene(layout, 800, 600);

        drawBuisson(gc);
        window.setScene(buisson);
    }


    public void createHerbeScene() {
        final Canvas canvas = new Canvas(300,300);
        gc = canvas.getGraphicsContext2D();
        Label label = new Label("Herbe");
        VBox layout = new VBox();
        layout.getChildren().addAll(label, canvas);
        herbe = new Scene(layout, 800, 600);

        drawHerbe(gc);
        window.setScene(herbe);
    }

    public void createHexamazeScene() {
        final Canvas canvas = new Canvas(300,300);
        gc = canvas.getGraphicsContext2D();
        Label label = new Label("Hexamaze");
        VBox layout = new VBox();
        layout.getChildren().addAll(label, canvas);
        hexamaze = new Scene(layout, 800, 600);

        drawHexamaze(gc);
        window.setScene(hexamaze);
    }

    public void createSierpinskiScene() {
        final Canvas canvas = new Canvas(300,300);
        gc = canvas.getGraphicsContext2D();
        Label label = new Label("Sierpinski");
        VBox layout = new VBox();
        layout.getChildren().addAll(label, canvas);
        sierpinski = new Scene(layout, 800, 600);

        drawSierpinski(gc);
        window.setScene(sierpinski);
    }


    //Draw

    public void drawBuisson(GraphicsContext gc) {
        Turtle turtle = new Turtle();
        turtle.turnR(20.0);
        turtle.draw(100.0);
        turtle.move(50.0);
        turtle.draw(50.0);
        turtle.turnR(20.0);
        turtle.draw(100.0);

        Queue<Line2d> lines = turtle.getLines();
        for (Line2d line: lines) {
            line.draw(gc);
        }
    }

    public void drawHerbe(GraphicsContext gc) {
        Turtle turtle = new Turtle();
        turtle.turnR(20.0);
        turtle.draw(200.0);

        turtle.turnL(20.0);
        turtle.draw(100.0);

        Queue<Line2d> lines = turtle.getLines();
        for (Line2d line: lines) {
            line.draw(gc);
        }
    }

    public void drawHexamaze(GraphicsContext gc) {
        Turtle turtle = new Turtle();
        turtle.turnR(20.0);
        turtle.draw(200.0);

        turtle.turnL(40.0);
        turtle.draw(10.0);
        turtle.turnL(40.0);
        turtle.draw(10.0);

        Queue<Line2d> lines = turtle.getLines();
        for (Line2d line: lines) {
            line.draw(gc);
        }
    }

    public void drawSierpinski(GraphicsContext gc) {
        Turtle turtle = new Turtle();
        turtle.turnR(20.0);
        turtle.draw(200.0);

        turtle.turnR(40.0);
        turtle.draw(10.0);
        turtle.turnL(40.0);
        turtle.draw(10.0);

        Queue<Line2d> lines = turtle.getLines();
        for (Line2d line: lines) {
            line.draw(gc);
        }
    }


}
