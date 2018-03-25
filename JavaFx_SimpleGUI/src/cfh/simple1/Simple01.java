package cfh.simple1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Simple01 extends Application {
    BorderPane layout= new BorderPane();

	VBox buildLeft(){
    	VBox lt= new VBox();
	    lt.setPadding(new Insets(15, 12, 15, 12));
	    lt.setSpacing(20);
    	Text leftText= new Text("My Left Text");
    	Text leftText2= new Text("Hello World");
    	lt.getChildren().add(leftText);
    	lt.getChildren().add(leftText2);
    	lt.setStyle("-fx-background-color: #336699;");
		return lt;
	}
	
	VBox buildRight(){
    	VBox lt= new VBox();
	    lt.setPadding(new Insets(15, 12, 15, 12));
	    lt.setSpacing(20);
    	Text leftText= new Text("My Right Text");
    	Text leftText2= new Text("Hello World");
    	lt.getChildren().add(leftText);
    	lt.getChildren().add(leftText2);
    	lt.setStyle("-fx-background-color: #336699;");
		return lt;
	}
	
	HBox buildTop(){
    	HBox boxtop= new HBox();
	    boxtop.setPadding(new Insets(10, 10, 10, 10));
	    boxtop.setSpacing(20);
    	Text topText= new Text("Top People");
    	Text topText2= new Text("Morning");
    	boxtop.getChildren().add(topText);
    	boxtop.getChildren().add(topText2);
    	boxtop.setStyle("-fx-background-color: #0066ff;");
		return boxtop;
	}	
    
	HBox buildBottom(){
    	HBox bt= new HBox();
	    bt.setPadding(new Insets(10, 10, 10, 10));
	    bt.setSpacing(20);
    	Text bottomText= new Text("Bottom");
    	Text bottomText2= new Text("Night");
    	bt.getChildren().add(bottomText);
    	bt.getChildren().add(bottomText2);
    	bt.setStyle("-fx-background-color: #0066ff;");
		return bt;
	}
	
    
	@Override
	public void start(Stage stage) throws Exception {
        stage.setTitle("My Gui");
    	Scene scene= new Scene(layout, 800, 600);
    	
    	layout.setTop(buildTop());
    	layout.setLeft(buildLeft());
        layout.setRight(buildRight());
        layout.setCenter(new Text("Center"));
        layout.setBottom(buildBottom());
        
        stage.setScene(scene);
        stage.show();		
	}
    public static void main(String[] args) {launch(args);}
}