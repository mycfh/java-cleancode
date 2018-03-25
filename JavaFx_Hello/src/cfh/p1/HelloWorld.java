package cfh.p1;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e->printHello());
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void printHello(){
    	System.out.println("Hello World!");
    }
    
    public static void main(String[] args) {
    	launch(args);
    }

}