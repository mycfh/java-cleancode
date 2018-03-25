package cfh.simple2.afm;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class AfmPane extends StackPane{
	private TextField text;
	
	public AfmPane() {
		HBox hbox= new HBox();
		hbox.setSpacing(30);
		
		hbox.setStyle("-fx-padding: 30;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		
		Button btn = new Button();
        btn.setText("Check AFM");
        btn.setOnAction(e->checkAFM());
        hbox.getChildren().add(btn);
        
        text= new TextField();
        text.textProperty().addListener((obs, oldText, newText) -> {
        	text.setStyle("-fx-text-inner-color: #000000;");
        });
        text.setOnAction(e -> checkAFM());
        hbox.getChildren().add(text);
        
		getChildren().add(hbox);
	}
	
	private void checkAFM() {
		boolean valid= Afm.check(text.getText());
		if(valid) {
			text.setStyle("-fx-control-inner-background: green");
		}else {
			text.setStyle("-fx-control-inner-background: red");
		}
	}
	
	
}
