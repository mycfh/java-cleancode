package cfh.simple2;


import cfh.simple2.afm.AfmPane;
import cfh.simple2.pizza.PizzaPane;
import cfh.simple2.temperature.TemperaturePane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleToolsGui extends Application {
    BorderPane layout= new BorderPane();
	AfmPane afm= new AfmPane();
	TemperaturePane temp= new TemperaturePane();
	PizzaPane pizza= new PizzaPane();
	
	
	public VBox buildCommands() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(20);
	    vbox.setStyle("-fx-background-color: #336699;");

	    Button buttonExit = new Button("Exit");
	    buttonExit.setPrefSize(100, 20);
	    buttonExit.setOnAction(e->Platform.exit());
	    vbox.getChildren().add(buttonExit);
	    
	    Button buttonAfm = new Button("AFM");
	    buttonAfm.setPrefSize(100, 20);
	    buttonAfm.setOnAction(e -> layout.setCenter(afm));
	    vbox.getChildren().add(buttonAfm);
	    
	    Button buttonTemp = new Button("Temp");
	    buttonTemp.setPrefSize(100, 20);
	    buttonTemp.setOnAction(e -> layout.setCenter(temp));
	    vbox.getChildren().add(buttonTemp);

	    Button buttonPizza = new Button("Pizza");
	    buttonPizza.setPrefSize(100, 20);
	    buttonPizza.setOnAction(e -> layout.setCenter(pizza));
	    vbox.getChildren().add(buttonPizza);
	    
	    return vbox;
	}
	
	public Pane buildCanvas(){
		Pane p= new Pane();
		Canvas canvas= new Canvas(p.getWidth(), p.getHeight());

		p.getChildren().add(canvas);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.strokeRect(0, 0, p.getWidth(), p.getHeight());
		return p;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        stage.setTitle("Gui Console");
    	Scene scene= new Scene(layout, 1000, 600);
    	
        layout.setLeft(buildCommands());

        stage.setScene(scene);
        stage.show();		
	}
	
    public static void main(String[] args) {launch(args);}
}