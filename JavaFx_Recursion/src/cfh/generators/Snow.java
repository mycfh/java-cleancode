package cfh.generators;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;


public class Snow extends CanvasPane{
	private int level= 2;


	public Snow() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					if(level<6) {
						level++;
						snow();
					}
					event.consume();
					break;
				case DOWN:
					if(level>0) {
						level--;
						snow();
					}
					event.consume();
					break;
				case LEFT:
					event.consume();
					break;
				case RIGHT:
					event.consume();
					break;
				default:
					break;

				}
			}
		});
	}
	

	public void snow() {
		double w = canvas.getWidth();
		double h = canvas.getHeight();
		this.requestFocus();
		refresh();
		double side= w/3;
		
		double dx= side * Math.sin(Math.toRadians(30));
		double dy= side * Math.cos(Math.toRadians(30));
		double ay= side * Math.tan(Math.toRadians(30)/2);
		double by= dy - ay;

		double x1 = w/2;
		double y1 = h/2 - by;
				
		double x2= w/2 - dx;
		double y2= h/2 + ay;
		
		double x3= w/2 + dx;
		double y3= h/2 + ay;
		
		Point2D p1= new Point2D(x1, y1);
		Point2D p2= new Point2D(x2, y2);
		Point2D p3= new Point2D(x3, y3);

		snowNode(p1, p2, level);
		snowNode(p2, p3, level);
		snowNode(p3, p1, level);
	}    
    
	public void snowNode(Point2D p1, Point2D p2, int level) {
		final double ra= Math.toRadians(60);

		if(level==0){
			canvas.getGraphicsContext2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			return;
		}
		Point2D[] np= new Point2D[3];
		np[0]= new Point2D(p1.getX()+(p2.getX()-p1.getX())/3.0,     p1.getY()+(p2.getY()-p1.getY())/3.0);
		np[2]= new Point2D(p1.getX()+(p2.getX()-p1.getX())*2.0/3.0, p1.getY()+(p2.getY()-p1.getY())*2.0/3.0);
		double d= p1.distance(p2)/3.0;
		double a= Math.atan2((p2.getY()-p1.getY()),(p2.getX()-p1.getX()));
		double x= np[0].getX()+d*Math.cos(a+ra);
		double y= np[0].getY()+d*Math.sin(a+ra);
		np[1]= new Point2D(x,y);
		
		snowNode(p1,    np[0], level-1);
		snowNode(np[0], np[1], level-1);
		snowNode(np[1], np[2], level-1);
		snowNode(np[2], p2,    level-1);
	} 
	
}
