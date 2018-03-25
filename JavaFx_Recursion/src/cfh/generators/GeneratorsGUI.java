package cfh.generators;

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

public class GeneratorsGUI extends Application implements AppManager{
	private TextArea status;
	private BorderPane layout;
	private Button lastButton;
	private Snow snow= new Snow();
	private Tree tree= new Tree();
	private Mandelbrot mandelbrot= new Mandelbrot();
	
	public VBox buildFunctions() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(20);
	    vbox.setStyle("-fx-background-color: #336699;");

	    Button buttonExit = new Button("Exit");
	    buttonExit.setPrefSize(100, 20);
	    buttonExit.setOnAction( e-> Platform.exit());
	    
	    Button snowButton = new Button("Snow");
	    snowButton.setPrefSize(100, 20);
	    snowButton.setOnAction( e -> {lastButton= snowButton;layout.setCenter(snow); snow.snow();});
	    
	    Button treeButton = new Button("Tree");
	    treeButton.setPrefSize(100, 20);
	    treeButton.setOnAction( e -> {lastButton= treeButton;layout.setCenter(tree); tree.tree();});
	    
	    Button mandelButton = new Button("Mandelbrot");
	    mandelButton.setPrefSize(100, 20);
	    mandelButton.setOnAction( e -> {lastButton= mandelButton;layout.setCenter(mandelbrot); mandelbrot.mandelbrot();});
	    
	    vbox.getChildren().addAll(buttonExit, snowButton, treeButton, mandelButton);	    
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
        snow.setAppManager(this);
        tree.setAppManager(this);
        mandelbrot.setAppManager(this);
        
        layout= new BorderPane();
        layout.setLeft(buildFunctions());
        layout.setBottom(buildStatus());
        
    	Scene appScene= new Scene(layout);
        stage.setScene(appScene);
        stage.sizeToScene();
        stage.show();		
	}

	@Override
	public void stop() {

	}
	
	
    public static void main(String[] args) {launch(args);}

	@Override
	public void appendToStatus(String m) {
		
		
	}


	@Override
	public Button getLastButton() {
		return lastButton;
	}
}    
