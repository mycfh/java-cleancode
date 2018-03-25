package cfh.p4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ApplicationWindow extends Application {
    //starting point for the application
    //this is where we put the code for the user interface
    @Override
    public void start(Stage primaryStage) {
        //The primaryStage is the top-level container
        primaryStage.setTitle("Example Gui");
        
        //The choicebox is populated from an observableArrayList
        ChoiceBox<String> fruits = new ChoiceBox<String>(
        		FXCollections.observableArrayList("Asparagus", 
        		"Beans", "Broccoli", "Cabbage", "Carrot", "Celery", 
        		"Cucumber", "Leek", "Mushroom", "Pepper", "Radish", 
        		"Shallot", "Spinach", "Swede", "Turnip"));
        
		ListView<String> vegetables = new ListView<String>(
	        	FXCollections.observableArrayList("Apple", 
	        	"Apricot", "Banana", "Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));	
    	
    
        Label choiceLabel= new Label("Fruits");
        Label listLabel  = new Label("Vegetables");
        
        //The FlowPane is a container that uses a flow layout
        final FlowPane choicePane = new FlowPane();
        choicePane.setHgap(100);
        choicePane.getChildren().add(choiceLabel);
        choicePane.getChildren().add(fruits);
        choicePane.setStyle("-fx-background-color: #886699;");
        //choicePane.setVisible(true);
        
        final FlowPane listPane = new FlowPane();
        listPane.setHgap(100);
        listPane.getChildren().add(listLabel);
        listPane.getChildren().add(vegetables);
        listPane.setVisible(false);
        listPane.setStyle("-fx-background-color: #669900;");

        
        //The button uses an inner class to handle the button click event
        Button vegFruitButton = new Button("Fruit or Veg");
        vegFruitButton.setPrefSize(450, 50);
        vegFruitButton.setStyle("-fx-background-color: #336699;");
        vegFruitButton.setOnAction(e->{
                choicePane.setVisible(!choicePane.isVisible());
                listPane.setVisible(!listPane.isVisible());
		});
        
        //The BorderPane has the same areas laid out as the BorderLayout layout manager
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 0, 20, 20));
        componentLayout.setTop(choicePane);
        componentLayout.setCenter(listPane);
        componentLayout.setBottom(vegFruitButton);
        
        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout, 500, 500);
        
        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }
    
    //JavaFX application still use the main method.
    //It should only ever contain the call to the launch method
    public static void main(String[] args) {launch(args);}
}