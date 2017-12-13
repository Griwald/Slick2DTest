package aStar;


import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;


public class Cell {
	
	private int i;
	private int j;

	private double fScore;
	private double gScore;
	private double hScore;
	
	private ArrayList<Cell> neighbors;
	private Cell previous;

	private boolean wall;


	public Cell(int i, int j) {
		this.i = i;
		this.j = j;
		
		this.fScore = 0;
		this.gScore = 0;
		this.hScore = 0;
		
		this.neighbors = new ArrayList<>();
		this.previous = null;
		
		this.wall = false;
		if (Math.random() < 0.3) {
			this.wall = true;
		}
	}
	
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}

	public double getfScore() {
		return this.fScore;
	}
	
	public void setfScore(double fScore) {
		this.fScore = fScore;
	}
	
	public double getgScore() {
		return this.gScore;
	}
	
	public void setgScore(double gScore) {
		this.gScore = gScore;
	}

	public double gethScore() {
		return this.hScore;
	}

	public void sethScore(double hScore) {
		this.hScore = hScore;
	}
	
	public ArrayList<Cell> getNeighbors() {
		return this.neighbors;
	}
	
	public Cell getPrevious() {
		return this.previous;
	}

	public void setPrevious(Cell previous) {
		this.previous = previous;
	}
	
	public boolean isWall() {
		return this.wall;
	}
	
	public void setWall(boolean wall) {
		this.wall = wall;
	}


	public void addNeighbors(Grid grid) {
		int i = this.i;
		int j = this.j;
		if (j < Main.cols - 1) {
			this.neighbors.add(grid.getCell(i, j + 1));
		}
		if (j > 0) {
			this.neighbors.add(grid.getCell(i, j - 1));
		}
		if (i < Main.rows - 1) {
			this.neighbors.add(grid.getCell(i + 1, j));
		}
		if (i > 0) {
			this.neighbors.add(grid.getCell(i - 1, j));
		}
	}
	
	public void printNeighbors() {
		for (Cell cell : this.neighbors) {
			System.out.println("(" + cell.getI() + "," + cell.getJ() + ")");
		}
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
