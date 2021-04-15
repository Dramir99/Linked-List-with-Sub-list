package Linked_List_W_Sub_List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class First_Pane_LinkedList extends BorderPane {

    //get the width and height of the pane
    final int width = 565;
    final int height = 501;

    //Stage to show the user.
    Stage menuStage;
    //Text to be used as a title and be centered at the top.
    Text title;
    //HBox that will hold the Buttons and be center in the middle.
    HBox button;

    public First_Pane_LinkedList(){

        //create the stage
        menuStage = new Stage();
        //create a title
        title = MenuTitle();
        //create buttons
        button = button();

        //center buttons
        button.setAlignment(Pos.CENTER);
        this.setCenter(button);

        //place title at top
        this.setAlignment(title, Pos.TOP_CENTER);
        this.setTop(title);

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("menuBackGround");

        //create a scene
        Scene scene = new Scene(this,width,height);

        //set the title
        menuStage.setTitle("Start Linked List.");
        //set scene
        menuStage.setScene(scene);
        //don't allow the user tp resize the window
        menuStage.setResizable(true);//----------------------------------------------------------------------------------
        //show stage
        menuStage.show();

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text MenuTitle(){
        Text title = new Text(75,75,"Linked List Menu");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
       // title.getStyleClass().add("title");
        title.setFill(Color.LIGHTBLUE);
        title.setEffect(reflection());

        return title;
    }

    /**
     * this method will create a Reflection to be used in the (@code addNodeTitle)
     * method
     *
     * @return an reflection effect
     */
    public Reflection reflection(){
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOffset(-20);

        return reflection;
    }

    /**
     * this method will create a DropShadow to be used in my Buttons
     *
     * @return a shadow effect.
     */
    public DropShadow ds(){
        DropShadow ds = new DropShadow();
        ds.setOffsetX(5.0);
        ds.setOffsetY(5.0);
        ds.setColor(Color.GRAY);
        return ds;
    }


    /**
     * this will hold the Two Buttons and allow the user to either start the program
     * or exit the program
     *
     * This public HBox will create Two Buttons and allow the user to start the
     * program or exit.
     *
     * @return A HBox with Two Buttons.
     */
    public HBox button(){

        HBox position = new HBox();

        Image playingCard = new Image("Style_LinkedList/Two_sided_arrow.jpeg");

        Button play = new Button("Start");

        //add effects
        play.setEffect(ds());
        play.getStyleClass().add("start");

        Button quit = new Button("Quit");

        quit.setEffect(ds());
        quit.getStyleClass().add("exit");

        Button setting = new Button("Setting");

        setting.setEffect(ds());
        setting.getStyleClass().add("start");

        position.setSpacing(5);

        position.getChildren().addAll(play,new ImageView(playingCard),setting,new ImageView(playingCard),quit);

        play.setOnAction(e ->{
            Second_Pane_LinkedList openSesame = new Second_Pane_LinkedList();
            menuStage.close();
        });

        setting.setOnAction(e->{
            UseCSVFileGUI file = new UseCSVFileGUI();
            menuStage.close();
        });

        quit.setOnAction(e ->{
            System.exit(0);
        });

        return position;
    }
}
