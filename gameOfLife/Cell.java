package gameOfLife;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;


public class Cell {
	
	private int i;
	private int j;
	private int state;


	public Cell(int i, int j) {
		this.i = i;
		this.j = j;
		
		this.state = 0;
		if (Math.random() < 0.5) {
			this.state = 1;
		}
	}
	
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}

	public int getState() {
		return this.state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	
	public void render(GameContainer gc, Graphics g) {
		if (this.state == 1) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.white);
		}
		
		int x = this.j * Grid.cellSize;
		int y = this.i * Grid.cellSize;
		Rectangle rect = new Rectangle(x + 1, y + 1, Grid.cellSize - 1, Grid.cellSize - 1);
		g.fill(rect);
	}
	
	
	@Override
	public String toString() {
		return "(" + this.i + ", " + this.j + ") : " + this.state;
		
	}
	
}
