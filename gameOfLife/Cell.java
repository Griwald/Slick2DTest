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


	public int countNeighbors(Grid grid) {
		int sum = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0)) {
					int col = (this.i + i + Main.cols) % Main.cols;
					int row = (this.j + j + Main.rows) % Main.rows;
					sum += grid.getCell(col, row).getState();
				}
			}
		}
		return sum;
	}


	@Override
	public String toString() {
		return "(" + this.i + ", " + this.j + ") : " + this.state;
	}

}
