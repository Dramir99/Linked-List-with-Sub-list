package Linked_List_W_Sub_List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.InputMismatchException;

/**
 * This class is a BorderPane that will hold three TextFields asking the
 * user what Node they want to create.
 *
 * @author Daniel Ramirez
 * @version 1.0
 */

public class AddNodeGUI extends BorderPane {

    //a Static LinkedList to be able to use it across my Classes.
    static LinkedList<String,Integer,Character> data = MainList();

    //Stage to show the user.
    Stage addNodeStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane addNodeGrid;
    //Text to be used as a title and be centered at the top.
    Text addNodeTitle;

    public AddNodeGUI(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        addNodeStage = new Stage();
        //create GridPane
        addNodeGrid = addOptions();
        addNodeGrid.setAlignment(Pos.CENTER);
        //create a title
        addNodeTitle = addNodeTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("addNodeBackGround");

        //place GridPane at center
        this.setCenter(addNodeGrid);
        //place title at top
        this.setAlignment(addNodeTitle, Pos.TOP_CENTER);
        this.setTop(addNodeTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        addNodeStage.setScene(scene);
        //Set the title
        addNodeStage.setTitle("Add a Node");
        //set the size to the Scene.
        addNodeStage.sizeToScene();
        //show the Scene.
        addNodeStage.show();
    }

    /**
     * this will hold the three TextFields and check if the input is correctly
     * inputted and will create a Node based on the info from the user.
     *
     * This public GridPane will create three TextFields and three Labels to inform
     * the user what they need to put to create a Node to be added to the list.
     *
     * @return A GridPane with three TextFields, four Labels, and Two Buttons.
     */
    public GridPane addOptions() {

        GridPane position = new GridPane();

        Label lb_VideoGameGenre = new Label("Genre(String)");
        Label lb_ReleaseYear = new Label("Release Year(Integer)");
        Label lb_Rating = new Label("ESRB Rating(Character)");
        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        lb_VideoGameGenre.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_VideoGameGenre.setTextFill(Color.WHITE);

        lb_ReleaseYear.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_ReleaseYear.setTextFill(Color.WHITE);

        lb_Rating.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_Rating.setTextFill(Color.WHITE);

        position.setHgap(10);
        position.setVgap(10);

        TextField tf_VideoGameGenre = new TextField();
        TextField tf_ReleaseYear = new TextField();
        TextField tf_ESRBRating = new TextField();

        Button bt_complete = new Button("Add");
        Button bt_back = new Button("Back");

        tf_VideoGameGenre.setPromptText("Genre of the Video Game");
        tf_VideoGameGenre.setEffect(ds());
        tf_VideoGameGenre.getStyleClass().add("addNodeButton");

        tf_ReleaseYear.setPromptText("Release year of the Video Game");
        tf_ReleaseYear.setEffect(ds());
        tf_ReleaseYear.getStyleClass().add("addNodeButton");

        tf_ESRBRating.setPromptText("ESRB Rating");
        tf_ESRBRating.setEffect(ds());
        tf_ESRBRating.getStyleClass().add("addNodeButton");

        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("addNodeButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("addNodeButton");

        position.add(lb_VideoGameGenre, 0, 0);
        position.add(tf_VideoGameGenre, 1, 0);
        position.add(lb_ReleaseYear, 0, 1);
        position.add(tf_ReleaseYear, 1, 1);
        position.add(lb_Rating, 0, 2);
        position.add(tf_ESRBRating, 1, 2);
        position.add(bt_complete, 1, 3);
        position.add(bt_back, 0, 3);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);

        position.add(lb_checker,0,4);
        GridPane.setColumnSpan(lb_checker, 5);

        bt_complete.setOnAction(e->{

            if (tf_VideoGameGenre.getText().isEmpty() || tf_ReleaseYear.getText().isEmpty() || tf_ESRBRating.getText().isEmpty()){

                lb_checker.setText("Video Game Genre is Empty or Release Year is Empty or ESRB rating is empty");
            }
            else if( !( tf_VideoGameGenre.getText().isEmpty() ) && !( tf_ReleaseYear.getText().isEmpty() ) && !( tf_ESRBRating.getText().isEmpty() )){
                try{

                    checkNumber(tf_ReleaseYear.getText());
                    checkChar(tf_ESRBRating.getText());

                    data.add(tf_VideoGameGenre.getText(),Integer.parseInt(tf_ReleaseYear.getText()),tf_ESRBRating.getText().charAt(0));

                    lb_checker.setText("Node has been added");
                }
                catch (InputMismatchException ex){
                    lb_checker.setText(ex.getMessage());
                }

            }

        });

        bt_back.setOnAction(e->{
            Second_Pane_LinkedList atras = new Second_Pane_LinkedList();
            addNodeStage.close();
        });

        return position;

    }

    /**
     * this will get a string and check if the string is a number and will throw a
     * InputMismatchException it's not.
     *
     * this method will check the string from the user and check if its able to be
     * parsed into a Integer at a later time.
     *
     * @param input Checks if the String is a number
     */

    public void checkNumber(String input){

        for (int i = 0; i < input.length(); i++){
            if ( !(Character.isDigit(input.charAt(i))) ){
                throw new InputMismatchException("Release year must be an Integer");
            }
        }

    }

    /**
     * this will get a string and check if the length of the string is one and will
     * throw an InputMismatchException if its longer than 1.
     *
     * this method will check if the the String can be used as a Character at a
     * later time.
     *
     * @param input A string to be used as a Character.
     */
    public void checkChar(String input){
        if (input.length() >1 || input.length() <= 0){
            throw new InputMismatchException("ESRB Rating must be one Character");
        }

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text addNodeTitle(){
        Text title = new Text(75,75,"Add Node");
        title.setFont(Font.font("Chlorinap",45));
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
     * this method will be a static Linked List to be used across all my Classes.
     *
     * @return a static LinkedList class
     */
    public static LinkedList<String,Integer,Character> MainList(){
        LinkedList<String,Integer,Character> list = new LinkedList<>(1);

        //Halo 3
        //group 1 = 1.1
        //group 2 = 1.1
        //group 3 = 1.1
        list.add("First-Person",2007,'M');

        //Rocket League
        //group 1 = 2.1
        //group 2 = 2.1
        //group 3 = 2.1
        list.add("Sports",2015,'E');

        //Dead by Daylight
        //group 1 = 3.1
        //group 2 = 3.1
        //group 3 = 1.2
        list.add("Horror",2016,'M');

        //Witcher 3
        //group 1 = 4.1
        //group 2 = 2.2
        //group 3 = 1.3
        list.add("Action RPG",2015,'M');

        //Alien Isolation
        //group 1 = 3.2
        //group 2 = 4.1
        //group 3 = 1.4
        list.add("Horror",2014,'M');


        //Call of Duty: Black Ops
        //group 1 = 1.2
        //group 2 = 5.1
        //group 3 = 1.5
        list.add("First-Person",2010,'M');


        //Jet Set Radio Future
        //group 1 = 2.2
        //group 2 = 6.1
        //group 3 = 3.1
        list.add("Sports",2002,'T');


        //Apex Legends
        //group 1 = 1.3
        //group 2 = 7.1
        //group 3 = 3.2
        list.add("First-Person",2019,'T');


        //FIFA 17
        //group 1 = 2.3
        //group 2 = 3.2
        //group 3 = 2.2
        list.add("Sports",2016,'E');

        //Plants vs Zombies Garden Warfare 2
        //group 1 = 3.3
        //group 2 = 3.3
        //group 3 = 2.3
        list.add("Horror",2016,'E');

        return list;
    }



    }
