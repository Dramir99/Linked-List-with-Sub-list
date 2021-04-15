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

public class DeleteNode extends BorderPane {

    //Stage to show the user.
    Stage deleteNodeStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane deleteNodeGrid;
    //Text to be used as a title and be centered at the top.
    Text deleteNodeTitle;

    public DeleteNode(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        deleteNodeStage = new Stage();
        //create GridPane
        deleteNodeGrid = deleteOptions();
        deleteNodeGrid.setAlignment(Pos.CENTER);
        //create a title
        deleteNodeTitle = addNodeTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("DeleteNodeBackGround");

        //place GridPane at Center
        this.setCenter(deleteNodeGrid);
        //place Title at Top Center.
        this.setAlignment(deleteNodeTitle, Pos.TOP_CENTER);
        this.setTop(deleteNodeTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        deleteNodeStage.setScene(scene);
        //Set the title
        deleteNodeStage.setTitle("Delete A Node");
        //set the size to the Scene.
        deleteNodeStage.sizeToScene();
        //show the Scene.
        deleteNodeStage.show();
    }

    /**
     * this will hold the Two TextFields and check if the input is correctly
     * inputted and will delete a Node based on the info from the user.
     *
     * This public GridPane will create two TextFields and Two Labels to inform
     * the user what they need to put to delete a Node from the list.
     *
     * @return A GridPane with two TextFields, three Labels, and Two Buttons.
     */
    public GridPane deleteOptions() {

        GridPane position = new GridPane();

        Label lb_MainIndex = new Label("Main Index");
        Label lb_SubIndex = new Label("Sub Index");
        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        lb_MainIndex.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_MainIndex.setTextFill(Color.WHITE);

        lb_SubIndex.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_SubIndex.setTextFill(Color.WHITE);

        position.setHgap(10);
        position.setVgap(10);

        TextField tf_MainIndex = new TextField();
        TextField tf_SubIndex = new TextField();

        Button bt_complete = new Button("Delete");
        Button bt_back = new Button("Back");

        tf_MainIndex.setPromptText("Select an Index from the Main list(Starting from 0)");
        tf_MainIndex.setEffect(ds());
        tf_MainIndex.getStyleClass().add("addNodeButton");

        tf_SubIndex.setPromptText("Select an Index from the Sub list(Starting from 0)");
        tf_SubIndex.setEffect(ds());
        tf_SubIndex.getStyleClass().add("addNodeButton");

        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("addNodeButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("addNodeButton");

        position.add(lb_MainIndex, 0, 0);
        position.add(tf_MainIndex, 1, 0);
        position.add(lb_SubIndex, 0, 1);
        position.add(tf_SubIndex, 1, 1);
        position.add(bt_complete, 1, 3);
        position.add(bt_back, 0, 3);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);

        position.add(lb_checker,0,4);
        GridPane.setColumnSpan(lb_checker, 5);

        bt_complete.setOnAction(e->{

            if (tf_MainIndex.getText().isEmpty() || tf_SubIndex.getText().isEmpty()){

                lb_checker.setText("Main-Index is Empty or Sub-Index is Empty");
            }
            else if( !( tf_MainIndex.getText().isEmpty() ) && !( tf_SubIndex.getText().isEmpty() ) ){
                try{

                    checkNumber(tf_MainIndex.getText());
                    checkNumber(tf_SubIndex.getText());

                    AddNodeGUI.data.delete( Integer.parseInt(tf_MainIndex.getText()),Integer.parseInt(tf_SubIndex.getText()) );
                    if (AddNodeGUI.data.head == null){
                        lb_checker.setText("List is Empty");
                    }
                    else{
                        lb_checker.setText("Node has been Deleted");
                    }

                }
                catch (InputMismatchException ex){
                    lb_checker.setText(ex.getMessage());
                }

            }

        });

        bt_back.setOnAction(e->{
            Second_Pane_LinkedList atras = new Second_Pane_LinkedList();
            deleteNodeStage.close();
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
                throw new InputMismatchException("Main Index and Sub Index must be an Integer");
            }
        }

        int num = Integer.parseInt(input);

        for (int row = 0; row < AddNodeGUI.data.size(); row++){

                if (num > AddNodeGUI.data.size() && num > AddNodeGUI.data.size(row)){
                    throw new InputMismatchException("Number is greater than Size of List");
                }
        }

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text addNodeTitle(){
        Text title = new Text(75,75,"Delete a Node");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
        title.setFill(Color.WHITESMOKE);
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
