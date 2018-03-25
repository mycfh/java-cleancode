package cfh.simple3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonManagementDemo extends Application {
	PersonManagementDemo parent;
    BorderPane layout= new BorderPane();
	private TextArea status;
	
	private final Menu fileMenu    = new Menu("File");
	private final Menu optionsMenu = new Menu("Options");
	private final Menu helpMenu    = new Menu("Help");
	
	private final MenuItem newFileItem = new MenuItem("New File");
	private final MenuItem openFileItem= new MenuItem("Open File");
	private final MenuItem saveFileItem= new MenuItem("Save File");
	
	public MenuBar addMenu(){
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, optionsMenu, helpMenu);
		
		newFileItem.setOnAction(new EventHandler<ActionEvent>() {
		     public void handle(ActionEvent t) {
		    	 status.appendText("\nNewFile");
		    	 new PersonTableView(parent);
		     }
		});	
		fileMenu.getItems().add(newFileItem);
		
		openFileItem.setOnAction(new EventHandler<ActionEvent>() {
		     public void handle(ActionEvent t) {
		    	 status.appendText("\nOpenFile");
		     }
		});			
		fileMenu.getItems().add(openFileItem);
		
		saveFileItem.setOnAction(new EventHandler<ActionEvent>() {
		     public void handle(ActionEvent t) {
		    	 status.appendText("\nSaveFile");
		     }
		});				
		fileMenu.getItems().add(saveFileItem);

		return menuBar;
	}
	
	public VBox addCommands() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(20);
	    vbox.setStyle("-fx-background-color: #336699;");

	    Button buttonExit = new Button("Exit");
	    buttonExit.setPrefSize(100, 20);
	    buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Platform.exit();
            }
        });
	    vbox.getChildren().add(buttonExit);
	    
	    Button buttonSerial = new Button("StartSerial");
	    buttonSerial.setPrefSize(100, 20);
	    buttonSerial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
	    vbox.getChildren().addAll(buttonSerial);

	    return vbox;
	}
	
	public ScrollPane addStatus(){
		status= new TextArea();
		status.setWrapText(true);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setContent(status);
        scrollPane.setFitToWidth(true);

		return scrollPane;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
        stage.setTitle("Gui Console");
        parent= this;
        layout.setTop(addMenu());
        layout.setLeft(addCommands());
        layout.setBottom(addStatus());
        
    	Scene appScene= new Scene(layout, 800, 600);
        stage.setScene(appScene);
        stage.show();		
	}
    public static void main(String[] args) { launch(args); }
}