package cfh.grid;

/**
* Test app for DotGrid
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
/**
 * Test app for DotGrid
 */
public class DotGridTest extends Application {
 
    @Override public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new DotGrid(), Color.WHITE));
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
