package cfh.p2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game2 extends Application {
	private Canvas canvas = new Canvas(980, 720);
	private AnimationTimer animationTimer;
	private final double TWIDTH=4;
	private final double THIGHT=4;
	private double px, x=0.0, py, y=0.0;
	private double a=0;
	private long past=0;
	
	@Override
	public void start(Stage stage) {
		Group gameNode = new Group(canvas);
		stage.setScene(new Scene(gameNode));
		stage.show();

		animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				long t= (now-past)/1_000_000;	//msec
				if(t>200){
					past= now;
					gameLoop();
					System.out.println(t);
				}
			}
		};
		// Start running game loop in javafx application Thread
		animationTimer.start();
		
	}


	public void gameLoop() {
		// update your game logics here
		px= x; py= y;
		a += 5; if(a>360) a= 0;
		x += 2; if(x>800) {x= 0; a= 0;}
		y= 200 + 190*Math.sin(Math.toRadians(a));
		//=================================================
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.ORANGE);
		gc.fillRect(px-1, py-1, TWIDTH+2, THIGHT+2);
		
		gc.setFill(Color.BLUE);
		gc.fillRect(x, y, TWIDTH, THIGHT);
	}


	public static void main(String arg[]) {	launch(arg); }
}
