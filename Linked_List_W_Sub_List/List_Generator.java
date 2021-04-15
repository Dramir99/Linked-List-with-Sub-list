package Linked_List_W_Sub_List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * This class is a BorderPane that will visually generate the LinkedList
 *
 * @author Daniel Ramirez
 * @version 1.0
 */

public class List_Generator extends BorderPane {

    //Stage to show the user.
    Stage List_GeneratorStage;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane List_GeneratorGrid;
    //Text to be used as a title and be centered at the top.
    Text List_GeneratorTitle;

    public List_Generator(){

        //add space so the Panes are separated
        Insets seperateWindow = new Insets(10,10,10,10);
        this.setPadding(seperateWindow);

        //create the stage
        List_GeneratorStage = new Stage();
        //create GridPane
        List_GeneratorGrid = List_GeneratorOptions();
        List_GeneratorGrid.setAlignment(Pos.CENTER);
        //create a title
        List_GeneratorTitle = List_GeneratorTitle();

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("ListGenerator");

        //place GridPane at Center
        this.setCenter(List_GeneratorGrid);
        //place Title at Top Center.
        this.setAlignment(List_GeneratorTitle, Pos.TOP_CENTER);
        this.setTop(List_GeneratorTitle);

        //create a scene
        Scene scene = new Scene(this,800,440);
        //set scene
        List_GeneratorStage.setScene(scene);
        //Set the title
        List_GeneratorStage.setTitle("View List");
        //set the size to the Scene.
        List_GeneratorStage.sizeToScene();
        //show the Scene.
        List_GeneratorStage.show();
    }

    /**
     * this will Generate a Visual look of a LinkedList with each Node connected
     * by double Arrows across and one Down arrow.
     *
     * This public GridPane will Generate a LinkedList based on anything the user does to the List.
     *
     * @return A GridPane that will Generate a Linked List.
     */
    public GridPane List_GeneratorOptions(){
        GridPane pane = new GridPane();

        ArrayList<Text> list = new ArrayList<>();
        Text each;

        for (int i = 0; i < AddNodeGUI.data.size(); i++){

            each = new Text(AddNodeGUI.data.get(i,1) + "\n" + AddNodeGUI.data.get(i,2) + "\n" + AddNodeGUI.data.get(i,3));
            each.setFill(Color.BLACK);
            list.add(each);
            for (int j = 0; j < AddNodeGUI.data.size(i)-1; j++){

                each = new Text(AddNodeGUI.data.get(i,j,1) + "\n" + AddNodeGUI.data.get(i,j,2) + "\n" + AddNodeGUI.data.get(i,j,3));
                list.add(each);
                each.setFill(Color.BLACK);
            }
        }

//        Rectangle node;

        Image doubleArrow = new Image("Style_LinkedList/Two_sided_arrow.jpeg");
        Image downArrow = new Image("Style_LinkedList/Down-Arrow.jpeg");

        int main = AddNodeGUI.data.size();

        int odd = main - 1;

        int listCounter = 0;

        for (int row = 0, values = 0; row < (main + odd); row++){

                int arrow = AddNodeGUI.data.size(values) - 1;

                int subSize = arrow + AddNodeGUI.data.size(values);

            for (int column = 0; column < subSize; column++){



                if (row % 2 == 0){

                    if (column % 2 == 0){

                        StackPane sp_pane = new StackPane();

                        Rectangle node = new Rectangle(70,70);
                        node.setFill(Color.WHITE);
                        node.setStroke(Color.BLACK);
                        node.setEffect(ds());

                        sp_pane.getChildren().addAll(node,list.get(listCounter));
                        pane.add(sp_pane,row,column);

                        listCounter++;
                    }

                    else{

                        pane.add(new ImageView(downArrow),row,column);
                    }


                }
                else{

                    values++;

                    pane.add(new ImageView(doubleArrow),row,column);

                    column = subSize + 1;

                }

            }
        }

        return pane;
    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text List_GeneratorTitle(){
        Text title = new Text(75,75,"List Generator");
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
     * this method will create a DropShadow to be used in my List
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
