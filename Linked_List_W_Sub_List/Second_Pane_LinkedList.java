package Linked_List_W_Sub_List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Second_Pane_LinkedList extends BorderPane {

    //get the width and height of the pane
    final int width = 800;
    final int height = 640;

    //Stage to show the user.
    Stage menuStage;
    //Text to be used as a title and be centered at the top.
    Text title;
    //GridPane that will hold the TextFields and be center in the middle.
    GridPane button;
    //HBox that will hold two buttons and be Centered at the Bottom.
    HBox view;

    public Second_Pane_LinkedList(){

        //create the stage
        menuStage = new Stage();
        //create a title
        title = MenuTitle();
        //create GridPane
        button = Menu_Linked_List_Options();
        //create Buttons
        view = getView();

        //center buttons
        button.setAlignment(Pos.CENTER);
        this.setCenter(button);

        //place title at top
        this.setAlignment(title, Pos.TOP_CENTER);
        this.setTop(title);

        //place Buttons at the Bottom
        this.setBottom(view);

        //get a background
        this.getStylesheets().add("Style_LinkedList/Effects.css");
        this.getStyleClass().add("MainMenuBackGround");

        //create a scene
        Scene scene = new Scene(this,width,height);
        //set the title
        menuStage.setTitle("Linked List Menu");
        //set scene
        menuStage.setScene(scene);
        //don't allow the user tp resize the window
        menuStage.setResizable(true);
        //show stage
        menuStage.show();

    }

    /**
     * This method will make a Text to create a title for the BorderPane
     *
     * @return a Text to be used as a title.
     */
    public Text MenuTitle(){
        Text title = new Text(75,75,"Linked List");
        title.setFont(Font.font("Lucida Handwriting", FontWeight.BOLD,45));
        title.setFill(Color.AQUA);
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
     * this will be GridPane that will visually look like a List but will just hld the methods.
     *
     * This public GridPane will hold the buttons that will allow the user to manipulate the
     * Linked List and will allow the user to see the LinkedList with the bottom button
     *
     * @return A GridPane that will allow the user to manipulate and See the Linked List.
     */
    public GridPane Menu_Linked_List_Options(){

        GridPane position = new GridPane();

        Label lb_checker = new Label();
        lb_checker.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 35));
        lb_checker.setTextFill(Color.WHITESMOKE);

        Image playingCard = new Image("Style_LinkedList/Two_sided_arrow.jpeg");
        Image downArrow = new Image("Style_LinkedList/Down-Arrow.jpeg");

        Button bt_AddNode = new Button("Add a Node");

        //add effects
        bt_AddNode.setEffect(ds());
        bt_AddNode.getStyleClass().add("MenuButton");

        Button bt_deleteFirstNode = new Button("Delete First Node");

        //add effects
        bt_deleteFirstNode.setEffect(ds());
        bt_deleteFirstNode.getStyleClass().add("MenuButton");

        Button bt_DeleteLastNode = new Button("Delete Last Node");

        //add effects
        bt_DeleteLastNode.setEffect(ds());
        bt_DeleteLastNode.getStyleClass().add("MenuButton");

        Button bt_DeleteAnyNode = new Button("Delete Any Node");

        //add effects
        bt_DeleteAnyNode.setEffect(ds());
        bt_DeleteAnyNode.getStyleClass().add("MenuButton");

        Button bt_GetNodeMainList = new Button("Get a Node's Category \nFrom the Main-List");

        //add effects
        bt_GetNodeMainList.setEffect(ds());
        bt_GetNodeMainList.getStyleClass().add("MenuButton");

        Button bt_GetNodeSubList = new Button("Get a Node's Category \nFrom the Sub-List");

        //add effects
        bt_GetNodeSubList.setEffect(ds());
        bt_GetNodeSubList.getStyleClass().add("MenuButton");

        Button bt_Regroup = new Button("Update list to a new Category");

        //add effects
        bt_Regroup.setEffect(ds());
        bt_Regroup.getStyleClass().add("MenuButton");

        Button bt_SizeofMainList = new Button("get the Size of the \nMain-List");

        //add effects
        bt_SizeofMainList.setEffect(ds());
        bt_SizeofMainList.getStyleClass().add("MenuButton");

        Button bt_SizeofSubList = new Button("get the Size of the \nSub-List relative to the\nMain-List");

        //add effects
        bt_SizeofSubList.setEffect(ds());
        bt_SizeofSubList.getStyleClass().add("MenuButton");

        Button bt_clearList = new Button("Clear the List");

        //add effects
        bt_clearList.setEffect(ds());
        bt_clearList.getStyleClass().add("MenuButton");


        position.setHgap(5);
        position.add(bt_AddNode,0,0);
        position.add(new ImageView(downArrow),0,1);
        position.add(bt_DeleteLastNode,0,2);
        position.add(new ImageView(downArrow),0,3);
        position.add(bt_deleteFirstNode,0,4);
        position.add(new ImageView(downArrow),0,5);
        position.add(bt_DeleteAnyNode,0,6);

        position.add(new ImageView(playingCard),1,0);

        position.add(bt_GetNodeMainList,2,0);
        position.add(new ImageView(downArrow),2,1);
        position.add(bt_GetNodeSubList,2,2);

        GridPane.setColumnSpan(lb_checker,4);
        GridPane.setRowSpan(lb_checker,4);
        position.add(lb_checker,2,6);

        position.add(new ImageView(playingCard),3,0);

        position.add(bt_Regroup,4,0);
        position.add(new ImageView(downArrow),4,1);
        position.add(bt_SizeofMainList,4,2);
        position.add(new ImageView(downArrow),4,3);
        position.add(bt_SizeofSubList,4,4);

        position.add(new ImageView(playingCard),5,0);

        position.add(bt_clearList,6,0);

        bt_AddNode.setOnAction(e ->{
            AddNodeGUI create = new AddNodeGUI();
            menuStage.close();
        });

        bt_deleteFirstNode.setOnAction(e ->{
            AddNodeGUI.data.deleteFirst();
            lb_checker.setText("First Node has been Deleted");
            lb_checker.setVisible(true);
        });

        bt_DeleteLastNode.setOnAction(e ->{
            AddNodeGUI.data.deleteLast();
            lb_checker.setText("Last Node has been Deleted");
            lb_checker.setVisible(true);
        });
        bt_DeleteAnyNode.setOnAction(e ->{
            DeleteNode gone = new DeleteNode();
            menuStage.close();
        });

        bt_GetNodeMainList.setOnAction(e->{
            GetMainIndexCategory GearsofWar = new GetMainIndexCategory();
            menuStage.close();
        });

        bt_GetNodeSubList.setOnAction(e->{
            GetSubIndexCategory DarkSouls = new GetSubIndexCategory();
            menuStage.close();
        });

        lb_checker.setOnMouseClicked(e->{
            this.getStyleClass().add("SecondMainMenuBackground");
            lb_checker.setVisible(false);
        });

        bt_Regroup.setOnAction(e->{
            Regroup JetSetRadioFuture = new Regroup();
            menuStage.close();
        });

        bt_SizeofMainList.setOnAction(e->{

            lb_checker.setText("Size of Main List: " + AddNodeGUI.data.size());
            lb_checker.setVisible(true);
        });

        bt_SizeofSubList.setOnAction(e->{
            SizeOfSubList RocketLeague = new SizeOfSubList();
            menuStage.close();
        });

        bt_clearList.setOnAction(e->{
            AddNodeGUI.data.clear();
            lb_checker.setText("List has been cleared");
            lb_checker.setVisible(true);
        });


        return position;
    }


    /**
     * this will hold the Two Buttons that allow you to go back to a previous
     * Pane or View the Linked List.
     *
     * This public HBox will create two Buttons to be used to go back or
     * view the List
     *
     * @return A HBox with Two Buttons.
     */
    public HBox getView(){
        HBox position = new HBox();

        position.setSpacing(5);
        position.setAlignment(Pos.BOTTOM_CENTER);
        Insets seperateWindow = new Insets(10,10,10,10);

        position.setPadding(seperateWindow);

        Button viewList = new Button("View List");

        //add effects
        viewList.setEffect(ds());
        viewList.getStyleClass().add("MenuButton");

        Button back = new Button("Back");

        //add effects
        back.setEffect(ds());
        back.getStyleClass().add("MenuButton");

        position.getChildren().addAll(back,viewList);

        viewList.setOnAction(e ->{
            List_Generator make = new List_Generator();
        });

        back.setOnAction(e ->{
            First_Pane_LinkedList reverse = new First_Pane_LinkedList();
            menuStage.close();
        });

        return position;
    }
}
