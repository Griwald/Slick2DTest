package gameOfLife;


import org.newdawn.slick.*;


public class Grid {
	
	private int rows;
	private int cols;
	public static int cellSize;
	public Cell[][] grid;


	public Grid(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		if (rows >= cols) {
			Grid.cellSize = Main.height / this.rows;
		} else {
			Grid.cellSize = Main.width / this.cols;
		}
	}
	
	
	public int getRows() {
		return this.rows;
	}

	public int getCols() {
		return this.cols;
	}

	public Cell getCell(int i, int j) {
		return this.grid[i][j];
	}


	public void init(GameContainer gc) throws SlickException {
		this.grid = new Cell[this.rows][this.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.grid[i][j] = new Cell(i, j);
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.grid[i][j].render(gc, g);
			}
		}
	}
	
}
