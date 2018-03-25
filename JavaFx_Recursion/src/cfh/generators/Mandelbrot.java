package cfh.generators;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Mandelbrot extends CanvasPane{
    // Values for the Mandelbrot set Real=[-2.0 .. +1.0] and Im=[-1.2 .. +1.2]
    private static double RE_MIN = -2.0;
    private static double RE_MAX = -1.0;
    private static double IM_MIN = -1.2;
    private static double IM_MAX =  1.2;
    private double xs, ys, xe, ye;

    private double reMin, reMax;
    private double imMin, imMax;
    
    private double reMin2, reMax2;
    private double imMin2, imMax2;
    
	public Mandelbrot(){
		super();
		
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
            	xs= event.getX();
            	ys= event.getY();
            }
        });
        
        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
            	xe= event.getX();
            	ye= event.getY();
            	System.out.format("%8.3f %8.3f %8.3f %8.3f\n", xs, ys, xe, ye);
            	reMin2= reMin+(reMax-reMin)*xs/w;
            	reMax2= reMin+(reMax-reMin)*xe/w;
            	imMin2= imMin+(imMax-imMin)*ys/h;
            	imMax2= imMin+(imMax-imMin)*ye/h;
            	
            	reMin= reMin2;
            	reMax= reMax2;
            	imMin= imMin2;
            	imMax= imMax2;
            	
            	System.out.format("%8.3f %8.3f %8.3f %8.3f w=%8.2f h=%8.2f\n", reMin, reMax, imMin, imMax, w,h);
            	paintSet(canvas, reMin, reMax, imMin, imMax);
            }
        });
	}
	

	public void mandelbrot() {
		reMin= RE_MIN;
	    reMax= RE_MAX;
	    imMin= IM_MIN;
	    imMax= IM_MAX;
		paintSet(canvas, reMin, reMax, imMin, imMax);
	}    
    
    private void paintSet(Canvas canvas, double reMin, double reMax, double imMin, double imMax) {
    	GraphicsContext gc= canvas.getGraphicsContext2D();
    	double precision = Math.max( (reMax-reMin)/w, (imMax-imMin)/h );
        int convergenceSteps = 50;
        
        for(double cr=reMin, xR=0; xR<w; cr += precision, xR++) {
            for(double ci=imMin, yR=0; yR<h; ci += precision, yR++) {
                double convergenceValue = checkConvergence(ci, cr, convergenceSteps);
                double t1 = (double) convergenceValue / convergenceSteps;
                double c1 = Math.min(255 * 2 * t1, 255);
                double c2 = Math.max(255 * (2 * t1 - 1), 0);
 
                if (convergenceValue != convergenceSteps) {
                    gc.setFill(Color.color(c2/255.0, c1/255.0, c2/255.0));
                } else {
                    gc.setFill(Color.PURPLE); // Convergence Colour
                }
                gc.fillRect(xR, yR, 1, 1);
            }
        }
    }
 
    /**
     * Checks the convergence of a coordinate (c, ci) The convergence factor
     * determines the colour of the point.
     */
    private int checkConvergence(double ci, double c, int convergenceSteps) {
        double z = 0, zi = 0;
        for (int i = 0; i < convergenceSteps; i++) {
            double ziT = 2 * (z * zi);
            double zT = z * z - (zi * zi);
            z = zT + c;
            zi= ziT + ci;
 
            if (z * z + zi * zi >= 4.0) {
                return i;
            }
        }
        return convergenceSteps;
    }

}
