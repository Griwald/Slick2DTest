package sightView;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;


public class Cell {

	private int i;
	private int j;
	
	private boolean wall;
	
	
	public Cell(int i, int j) {
		this.i = i;
		this.j = j;

		this.wall = false;
//		if (Math.random() < 0.3) {
//			this.wall = true;
//		}
	}


	public int getI() {
		return this.i;
	}

	public int getJ() {
		return this.j;
	}
	
	public boolean isWall() {
		return this.wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}


	public void render(GameContainer gc, Graphics g, Color c) {
		if (this.wall) {
			g.setColor(Color.black);
		} else {
			g.setColor(c);
		}

		int x = this.j * Grid.cellSize;
		int y = this.i * Grid.cellSize;
		Rectangle rect = new Rectangle(x + 1, y + 1, Grid.cellSize - 1, Grid.cellSize - 1);
		g.fill(rect);
	}

}
