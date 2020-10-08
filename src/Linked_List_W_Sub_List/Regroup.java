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
 * This class is a BorderPane that will hold one TextFields asking the
 * user how they want the List to be Grouped.
 *
 * @author Daniel Ramirez
 * @version 1.0
 */

public class Regroup extends BorderPane {

    //Stage to show the user.
    Stage regroupedStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane regroupedGrid;
    //Text to be used as a title and be centered at the top.
    Text regroupedTitle;

    public Regroup(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        regroupedStage = new Stage();
        //create GridPane
        regroupedGrid = RegroupedOptions();
        regroupedGrid.setAlignment(Pos.CENTER);
        //create a title
        regroupedTitle = RegroupedTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("Regroup");

        //place GridPane at Center
        this.setCenter(regroupedGrid);
        //place Title at Top Center.
        this.setAlignment(regroupedTitle, Pos.TOP_CENTER);
        this.setTop(regroupedTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        regroupedStage.setScene(scene);
        //Set the title
        regroupedStage.setTitle("Regroup the List into the new Category");
        //set the size to the Scene.
        regroupedStage.sizeToScene();
        //show the Scene.
        regroupedStage.show();

    }

    public GridPane RegroupedOptions() {

        GridPane position = new GridPane();

        Label lb_Regroup = new Label("Regroup: ");
        Label lb_checker = new Label();

        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_checker.setTextFill(Color.WHITE);

        lb_Regroup.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        lb_Regroup.setTextFill(Color.WHITE);

        position.setHgap(10);
        position.setVgap(10);

        TextField tf_getRegroupNumber = new TextField();

        Button bt_complete = new Button("Regroup");
        Button bt_back = new Button("Back");

        tf_getRegroupNumber.setPromptText("Regroup the List From (1-3)");
        tf_getRegroupNumber.setEffect(ds());
        tf_getRegroupNumber.getStyleClass().add("addNodeButton");

        bt_complete.setEffect(ds());
        bt_complete.getStyleClass().add("addNodeButton");

        bt_back.setEffect(ds());
        bt_back.getStyleClass().add("addNodeButton");

        position.add(lb_Regroup, 0, 0);
        position.add(tf_getRegroupNumber, 1, 0);
        position.add(bt_complete, 1, 3);
        position.add(bt_back, 0, 3);
        position.setHalignment(bt_complete, HPos.RIGHT);
        position.setHalignment(bt_back, HPos.RIGHT);

        position.add(lb_checker,0,4);
        GridPane.setColumnSpan(lb_checker, 5);

        bt_complete.setOnAction(e->{

            if (tf_getRegroupNumber.getText().isEmpty() ){

                lb_checker.setText("Regroup is empty");
            }
            else if( !( tf_getRegroupNumber.getText().isEmpty() )  ){
                try{

                    checkNumber(tf_getRegroupNumber.getText());

                    AddNodeGUI.data.regroup( Integer.parseInt(tf_getRegroupNumber.getText()) );

                    lb_checker.setText("List has been Regrouped.");
                }
                catch (InputMismatchException ex){
                    lb_checker.setText(ex.getMessage());
                }

            }

        });

        bt_back.setOnAction(e->{
            Second_Pane_LinkedList atras = new Second_Pane_LinkedList();
            regroupedStage.close();
        });

        return position;

    }

    public void checkNumber(String input){

        for (int i = 0; i < input.length(); i++){
            if ( !(Character.isDigit(input.charAt(i))) ){
                throw new InputMismatchException("Regroup number must be an Integer");
            }
        }

        String one = "1";
        String two = "2";
        String three = "3";

        if (  !input.matches(one) && !input.matches(two) && !input.matches(three)){

            throw new InputMismatchException("The Number can only be (1,2,3)");
        }

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text RegroupedTitle(){
        Text title = new Text(75,75,"Regroup List");
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
