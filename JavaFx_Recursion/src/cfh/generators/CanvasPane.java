package cfh.generators;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

abstract class CanvasPane extends Pane {
	private AppManager appManager;
	private static final double SPACING_X = 25;
    private static final double SPACING_Y = 20;
    private static final double RADIUS = 1.5;
    protected double w;
    protected double h;
    protected Canvas canvas = new Canvas();

    
    public AppManager getAppManager() {
		return appManager;
	}

	public void setAppManager(AppManager appManager) {
		this.appManager = appManager;
	}   
            
    public CanvasPane() {
        getChildren().add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    protected void layoutChildren() {
    	final double x = snappedLeftInset();
        final double y = snappedTopInset();
        
        w = snapSize(getWidth()) - x - snappedRightInset();
        h = snapSize(getHeight())- y - snappedBottomInset();
        canvas.setLayoutX(x);
        canvas.setLayoutY(y);
         
        if (w != canvas.getWidth() || h != canvas.getHeight()) {
            canvas.setWidth(w);
            canvas.setHeight(h);
            refresh();
            if(appManager.getLastButton() != null) {appManager.getLastButton().fire();}
        }
    }

    public void refresh() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.clearRect(0, 0, w, h);
        g.setFill(Color.gray(0,0.2));

        for (int xc = 0; xc < w; xc += SPACING_X) {
            for (int yc = 0; yc < h; yc += SPACING_Y) {
            	g.fillOval(xc-RADIUS, yc-RADIUS, RADIUS+RADIUS, RADIUS+RADIUS);
            }
        }
    }
}