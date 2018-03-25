package cfh.simple2.pizza;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PizzaPane extends StackPane{
	private TextField numberOfPersonsTF    = new TextField();
	private TextField costPersonPizzaTF    = new TextField();
	private TextField costFamilyPizzaTF    = new TextField();
	private TextField diameterPersonPizzaTF= new TextField();
	private TextField diameterFamilyPizzaTF= new TextField();
	private TextField resultsTF= new TextField();
	
	private Pizza piz= new Pizza();
	
	public PizzaPane() {
		VBox vbox= new VBox();
		vbox.setSpacing(30);
		vbox.setStyle("-fx-padding: 30;" + "-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
		        + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        vbox.getChildren().add(input("NumOfPersons",          numberOfPersonsTF));
        vbox.getChildren().add(input("CostOfPersonPizza",     costPersonPizzaTF));
        vbox.getChildren().add(input("CostOfFamilyPizza",     costFamilyPizzaTF));
        vbox.getChildren().add(input("DiameterOfPersonPizza", diameterPersonPizzaTF));
        vbox.getChildren().add(input("DiameterOfFamilyPizza", diameterFamilyPizzaTF));
        vbox.getChildren().add(command("", resultsTF));
        
		getChildren().add(vbox);
		initPizza();
	}
	
	public HBox command(String name, TextField t) {
		HBox hbox= new HBox();
		hbox.setSpacing(20);
		hbox.setStyle("-fx-padding: 10;");
		
		Button btn = new Button();
        btn.setText("ChoosePizzaType");
        btn.setOnAction(e->choosePizzaType());
        hbox.getChildren().add(btn);
        
        t.setPrefColumnCount(40);
        t.setEditable(false);
        t.setDisable(true);
        hbox.getChildren().add(t);
		return hbox;
	}
	
	public HBox input(String name, TextField t) {
		HBox hbox= new HBox();
		hbox.setSpacing(30);
		hbox.setStyle("-fx-padding: 10;");
		
		Label label = new Label(name);
        label.setPrefWidth(160);
        t.setPrefColumnCount(40);
        hbox.getChildren().add(label);
        hbox.getChildren().add(t);
		return hbox;
	}
	
	public void choosePizzaType() {
		piz.setPersons(Integer.parseInt(numberOfPersonsTF.getText()));
		piz.setPriceOfPP(Double.parseDouble(costPersonPizzaTF.getText()));
		piz.setPriceOfFP(Double.parseDouble(costFamilyPizzaTF.getText()));
		piz.setDiameterOfPP(Double.parseDouble(diameterPersonPizzaTF.getText()));
		piz.setDiameterOfFP(Double.parseDouble(diameterFamilyPizzaTF.getText()));
		piz.process();
		resultsTF.setText(piz.results());
	}
	
	public void initPizza() {
		numberOfPersonsTF.setText(Integer.toString(piz.getPersons()));
		costPersonPizzaTF.setText(Double.toString(piz.getPriceOfPP()));
		costFamilyPizzaTF.setText(Double.toString(piz.getPriceOfFP()));
		
		diameterPersonPizzaTF.setText(Double.toString(piz.getDiameterOfPP()));
		diameterFamilyPizzaTF.setText(Double.toString(piz.getDiameterOfFP()));
	}

}
