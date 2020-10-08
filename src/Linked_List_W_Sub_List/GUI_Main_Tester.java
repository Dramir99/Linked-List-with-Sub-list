package hw05;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

/**
 * This class is a Main to start My LinkedList GUI.
 *
 * @author Daniel Ramirez
 * @version 1.0
 */
public class GUI_Main_Tester extends Application {

    public static void main(String[] args){

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Font.loadFont(GUI_Main_Tester.class.getResource("../Style_LinkedList/mario.ttf").toExternalForm(), 12);
        First_Pane_LinkedList first = new First_Pane_LinkedList();


    }

}
