package cfh.generators;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class Tree extends CanvasPane{
	private int levels=5;

	public Tree() {
		super();
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					if(levels<6) {
						levels++;
						tree();
					}
					event.consume();
					break;
				case DOWN:
					if(levels>0) {
						levels--;
						tree();
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
	
	public void tree() {
		double w = canvas.getWidth();
		double h = canvas.getHeight();
		this.requestFocus();
		refresh();
		double xStart = w/2;
		double yStart = h/2;
		double len= (w>h)?h/5:w/5;
		double u= 30;
		treeNode(xStart, yStart, levels, len,   0, u);
		treeNode(xStart, yStart, levels, len, 120, u);
		treeNode(xStart, yStart, levels, len, 240, u);
	}

	// node calculates recursively left & right leaf of tree at each level.
	public void treeNode(double x0, double y0, int level, double len, double angle,	double u) {
		// Right branch
		double xright = x0 + len * Math.cos(Math.toRadians(angle-u));
		double yr = y0 + len * Math.sin(Math.toRadians(angle-u));
		// Left branch
		double xl = x0 + len * Math.cos(Math.toRadians(angle+u));
		double yl = y0 + len * Math.sin(Math.toRadians(angle+u));
		canvas.getGraphicsContext2D().setStroke(color(level));
		canvas.getGraphicsContext2D().strokeLine(x0, y0, xright, yr);
		canvas.getGraphicsContext2D().strokeLine(x0, y0, xl, yl);		
		if (level == 0) return;
		treeNode(xright, yr, level-1, 0.6 * len, angle-u, 0.8*u); // Right
		treeNode(xl, yl, level-1, 0.6 * len, angle+u, 0.8*u); // Left
	}
	
	private Color color(int level) {
		switch(level) {
		case 0: return Color.RED;
		case 1: return Color.YELLOW;
		case 2: return Color.YELLOWGREEN;
		case 3: return Color.GREEN;
		case 4: return Color.BLUE;
		
		}
		return Color.BLACK;
	}


}
