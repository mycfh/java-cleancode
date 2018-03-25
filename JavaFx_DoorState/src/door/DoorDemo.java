package door;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DoorDemo extends Application {
	private Button exitButton;
	private Button openButton;
	private Button closeButton;
	private Label messageLabel;
	private Door door= new Door(this);

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(800, 600);
		
		HBox buttonBox= new HBox();
		buttonBox.setStyle("-fx-background-color:orange;");
		buttonBox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
		buttonBox.setSpacing(20);
		
		exitButton = new Button("Exit");
		exitButton.setOnAction(e -> close());
		buttonBox.getChildren().add(exitButton);
		
		openButton = new Button("Open");
		openButton.setOnAction(e -> door.open());
		buttonBox.getChildren().add(openButton);
		
		closeButton= new Button("Close");
		closeButton.setOnAction(e -> door.close());
		buttonBox.getChildren().add(closeButton);

		root.setTop(buttonBox);
		
		messageLabel= new Label("Hello");
		messageLabel.setFont(Font.font(80));		
		root.setCenter(messageLabel);
		
		Scene scene= new Scene(root);
		
		primaryStage.setTitle("Door Console");		
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> close());
		primaryStage.show();
		
	}
	
	public void message(String s){
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				messageLabel.setText(s);
			}
		});
		
		
	}
	
	
	private void close(){
		Platform.exit(); 
		System.exit(0);
	}
	
    public static void main(String[] args) {launch(args);}
}