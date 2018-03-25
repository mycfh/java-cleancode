package cfh.snow;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Snow {
	private int level=3;
	private double w= 300.0;
	private double x1=250,  y1=50;
	private GraphicsContext gc;
	
	
	public void snow() {
		double dx= w* Math.sin(Math.toRadians(30));
		double dy= w* Math.cos(Math.toRadians(30));

		double x2=x1+dx, y2=y1+dy;
		double x3=x1-dx, y3=y1+dy;
		
		Point2D p1= new Point2D(x1, y1);
		Point2D p2= new Point2D(x2, y2);
		Point2D p3= new Point2D(x3, y3);
		
		
		
		snowNode(p1, p2, level);
		snowNode(p2, p3, level);
		snowNode(p3, p1, level);
	}    
    
	public void snowNode(Point2D p1, Point2D p2, int level) {
		final double ra= -60 * Math.PI / 180.0;
		if(level==0){
			gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
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
	
	
	public CanvasPane buildCanvas(){
		CanvasPane cp= new CanvasPane(500, 500);
		Canvas canvas = cp.getCanvas();
		gc = canvas.getGraphicsContext2D();
		return cp;
	}
	
}
