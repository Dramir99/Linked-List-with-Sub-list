package hw05;

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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.util.InputMismatchException;


/**
 * This class is a BorderPane that will hold two TextFields asking the
 * user what Node they want to delete.
 *
 * @author Daniel Ramirez
 * @version 1.0
 */

public class SizeOfSubList extends BorderPane {

    //Stage to show the user.
    Stage sizeOfSubListStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane sizeOfSubListGrid;
    //Text to be used as a title and be centered at the top.
    Text sizeOfSubListTitle;

    public SizeOfSubList(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        sizeOfSubListStage = new Stage();
        //create GridPane
        sizeOfSubListGrid = sizeofSubListOptions();
        sizeOfSubListGrid.setAlignment(Pos.CENTER);
        //create a title
        sizeOfSubListTitle = SizeofSubListTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("SizeofSubList");

        //place GridPane at Center
        this.setCenter(sizeOfSubListGrid);
        //place Title at Top Center.
        this.setAlignment(sizeOfSubListTitle, Pos.TOP_CENTER);
        this.setTop(sizeOfSubListTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        sizeOfSubListStage.setScene(scene);
        //Set the title
        sizeOfSubListStage.setTitle("Size of the Sub List");
        //set the size to the Scene.
        sizeOfSubListStage.sizeToScene();
        //show the Scene.
        sizeOfSubListStage.show();
    }

    public GridPane sizeofSubListOptions() {

        GridPane position = new GridPane();

        Label lb_Main_Index = new Label("Main Index: ");
        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        lb_Main_Index.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_Main_Index.setTextFill(Color.WHITE);

        position.setHgap(10);
        position.setVgap(10);

        TextField tf_getMainIndexNumber = new TextField();

        Button bt_complete = new Button("Get");
        Button bt_back = new Button("Back");

        tf_getMainIndexNumber.setPromptText("Main index ");
        tf_getMainIndexNumber.setEffect(ds());
        tf_getMainIndexNumber.getStyleClass().add("addNodeButton");

        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("addNodeButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("addNodeButton");

        position.add(lb_Main_Index, 0, 0);
        position.add(tf_getMainIndexNumber, 1, 0);
        position.add(bt_complete, 1, 3);
        position.add(bt_back, 0, 3);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);

        position.add(lb_checker,0,4);
        GridPane.setColumnSpan(lb_checker, 5);

        bt_complete.setOnAction(e->{

            if (tf_getMainIndexNumber.getText().isEmpty() ){

                lb_checker.setText("Main index is empty");
            }
            else if( !( tf_getMainIndexNumber.getText().isEmpty() )  ){
                try{

                    checkNumber(tf_getMainIndexNumber.getText());

                    lb_checker.setText("Size of the Sub-List: " + AddNodeGUI.data.size( Integer.parseInt(tf_getMainIndexNumber.getText()) ));
                }
                catch (InputMismatchException ex){
                    lb_checker.setText(ex.getMessage());
                }

            }

        });

        bt_back.setOnAction(e->{
            Second_Pane_LinkedList atras = new Second_Pane_LinkedList();
            sizeOfSubListStage.close();
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
     * @param input Checks if the String is a number and is less than the Main Size
     */
    public void checkNumber(String input){

        for (int i = 0; i < input.length(); i++){
            if ( !(Character.isDigit(input.charAt(i))) ){
                throw new InputMismatchException("Regroup number must be an Integer");
            }
        }

        int num = Integer.parseInt(input);

        if ( num >= AddNodeGUI.data.size() ){

            throw new InputMismatchException("The Number is greater than the Main Size");
        }

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text SizeofSubListTitle(){
        Text title = new Text(75,75,"Get Sub Size");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,55));
        title.setFill(Color.WHITESMOKE);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(2);
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

}
