package cfh.simple2.temperature;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class TemperaturePane extends StackPane{
	private TextField textCelcius;
	private TextField textFar;
	
	public TemperaturePane() {
		HBox hbox= new HBox();
		hbox.setSpacing(30);
		
		hbox.setStyle("-fx-padding: 30;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;"+ "-fx-border-color: blue;");
        
        textCelcius= new TextField();
        textCelcius.textProperty().addListener((obs, oldText, newText) -> {
        	textCelcius.setStyle("-fx-text-inner-color: #000000;");
        	
        });
        textCelcius.setOnAction(e -> toFar());

        hbox.getChildren().add(textCelcius);
        
        
        textFar= new TextField();
        textFar.textProperty().addListener((obs, oldText, newText) -> {
        	textFar.setStyle("-fx-text-inner-color: #000000;");
        	
        });
        textFar.setOnAction(e -> toCel());

        hbox.getChildren().add(textFar);
        
		getChildren().add(hbox);
	}
	
	private void toFar() {
		double far;
		try {
			double celcius= Double.parseDouble(textCelcius.getText());
			far= (9.0*celcius/5.0)+32.0;
			textFar.setText(String.format("%8.2f", far));
		}catch(NumberFormatException e) {
			textCelcius.setStyle("-fx-control-inner-background: red;");
			textFar.setText("");
		}
	}
	
	private void toCel() {
		double celcius;
		try {		
			double far= Double.parseDouble(textFar.getText());
			celcius= (far-32.0)*5.0/9.0;
			textCelcius.setText(String.format("%8.2f", celcius));
		}catch(NumberFormatException e){
			textFar.setStyle("-fx-control-inner-background: red;");
			textCelcius.setText("");
		}
	}
}
