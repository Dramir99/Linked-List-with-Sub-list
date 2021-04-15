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
 * user what Node category they want.
 *
 * @author Daniel Ramirez
 * @version 1.0
 */

public class GetMainIndexCategory extends BorderPane {

    //Stage to show the user.
    Stage getMainCategoryStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane getMainCategoryGrid;
    //Text to be used as a title and be centered at the top.
    Text getMainCategoryTitle;

    public GetMainIndexCategory(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        getMainCategoryStage = new Stage();
        //create GridPane
        getMainCategoryGrid = mainIndexOptions();
        getMainCategoryGrid.setAlignment(Pos.CENTER);
        //create a title
        getMainCategoryTitle = GetMainIndexCategoryTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("GetMainIndexCategory");

        //place GridPane at center
        this.setCenter(getMainCategoryGrid);

        //place title at the top
        this.setAlignment(getMainCategoryTitle, Pos.TOP_CENTER);
        this.setTop(getMainCategoryTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        getMainCategoryStage.setScene(scene);
        //Set the title
        getMainCategoryStage.setTitle("Get the Category of the Main Index.");
        //set the size to the Scene.
        getMainCategoryStage.sizeToScene();
        //show the Scene.
        getMainCategoryStage.show();
    }

    /**
     * this will hold the Two TextFields and check if the input is correctly
     * inputted and will return a Label with the Category.
     *
     * This public GridPane will create Two TextFields and three Labels to inform
     * the user what they need to put to return the Category.
     *
     * @return A GridPane with two TextFields, three Labels, and Two Buttons.
     */
    public GridPane mainIndexOptions() {

        GridPane position = new GridPane();

        Label lb_GetMainIndex = new Label("Main Index: ");
        Label lb_GetMainIndexCategory = new Label("Category: ");
        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        lb_GetMainIndex.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_GetMainIndex.setTextFill(Color.WHITE);

        lb_GetMainIndexCategory.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_GetMainIndexCategory.setTextFill(Color.WHITE);

        position.setHgap(10);
        position.setVgap(10);

        TextField tf_GetMainIndex = new TextField();
        TextField tf_GetMainIndexCategory = new TextField();


        Button bt_complete = new Button("Get");
        Button bt_back = new Button("Back");

        tf_GetMainIndex.setPromptText("The Index from the Main List");
        tf_GetMainIndex.setEffect(ds());
        tf_GetMainIndex.getStyleClass().add("addNodeButton");

        tf_GetMainIndexCategory.setPromptText("The Category from the Index(1-3)");
        tf_GetMainIndexCategory.setEffect(ds());
        tf_GetMainIndexCategory.getStyleClass().add("addNodeButton");

        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("addNodeButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("addNodeButton");

        position.add(lb_GetMainIndex, 0, 0);
        position.add(tf_GetMainIndex, 1, 0);
        position.add(lb_GetMainIndexCategory, 0, 1);
        position.add(tf_GetMainIndexCategory, 1, 1);
        position.add(bt_complete, 1, 3);
        position.add(bt_back, 0, 3);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);

        position.add(lb_checker,0,4);
        GridPane.setColumnSpan(lb_checker, 5);

        bt_complete.setOnAction(e->{

            if (tf_GetMainIndex.getText().isEmpty() || tf_GetMainIndexCategory.getText().isEmpty() ){

                lb_checker.setText("Main Index is Empty or Category is empty");
            }
            else if( !( tf_GetMainIndex.getText().isEmpty() ) && !( tf_GetMainIndexCategory.getText().isEmpty() ) ){
                try{

                    checkNumber(tf_GetMainIndexCategory.getText());
                    checkNumber(tf_GetMainIndex.getText());

                    lb_checker.setText(AddNodeGUI.data.get(Integer.parseInt(tf_GetMainIndex.getText()),Integer.parseInt(tf_GetMainIndexCategory.getText())));
                }
                catch (InputMismatchException ex){
                    lb_checker.setText(ex.getMessage());
                }

            }

        });

        bt_back.setOnAction(e->{
            Second_Pane_LinkedList atras = new Second_Pane_LinkedList();
            getMainCategoryStage.close();
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
                throw new InputMismatchException("Main index and Category must be a number");
            }
        }

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text GetMainIndexCategoryTitle(){
        Text title = new Text(75,75,"Get A Category");
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
