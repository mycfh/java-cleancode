package cfh.snow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SnowGUI extends Application {
	private TextArea status;
	private BorderPane layout;
	private Snow snow= new Snow();
	
	public VBox buildFunctions() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(20);
	    vbox.setStyle("-fx-background-color: #336699;");

	    Button buttonExit = new Button("Exit");
	    buttonExit.setPrefSize(100, 20);
	    buttonExit.setOnAction( (e)-> Platform.exit());
	    
	    Button snowButton = new Button("Snow");
	    snowButton.setPrefSize(100, 20);
	    snowButton.setOnAction( (e)-> snow.snow());
	    vbox.getChildren().addAll(buttonExit, snowButton);

	    return vbox;
	}
	
	public ScrollPane buildStatus(){
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
        stage.setTitle("Pattern Generators");
        layout= new BorderPane();
        
        layout.setLeft(buildFunctions());
        layout.setBottom(buildStatus());
        layout.setCenter(snow.buildCanvas());
        
    	Scene appScene= new Scene(layout);
        stage.setScene(appScene);
        stage.sizeToScene();
        stage.show();		
	}

	@Override
	public void stop() {

	}
	
	public BorderPane getLayout() {
		return layout;
	}
	
    public static void main(String[] args) {launch(args);}
}    
