package cfh.p2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game1 extends Application {
	private Canvas canvas = new Canvas(980, 720);
	private double x=0.0, y=200.0;
	private double a=0;
	private long now=0, past=0;
	private Thread my;
	
	@Override
	public void start(Stage stage) {
		Group gameNode = new Group(canvas);
		stage.setScene(new Scene(gameNode));
		stage.show();
		
		my= new Thread() {
			@Override
			public void run() {
				while(true) {
					now++;
					try {
						Thread.sleep(10);
						if(now-past > 20) {
							past= now;
							gameLoop();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}//while
			}
		};
		
		my.start();
	}


	public void gameLoop() {
		a += 5; if(a>360) {a= 0;}
		x += 2; if(x>800) {x= 0; a= 0;}
		y= 200 + 190*Math.sin(Math.toRadians(a));
		plot(x-2, y-2, 4, 4, Color.BLUE);
	}

	public void plot(double x, double y, double w, double h, Color color) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.fillRect(x, y, w, h);
	}
	
	public static void main(String arg[]) {	launch(arg); }
}
