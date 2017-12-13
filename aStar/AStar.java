package aStar;


import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class AStar {

	private Grid grid;
	private Cell start;
	private Cell end;

	private ArrayList<Cell> openSet;
	private ArrayList<Cell> closedSet;
	
	private ArrayList<Cell> path;


	public AStar(Grid grid, Cell start, Cell end) {
		this.grid = grid;
		this.start = start;
		this.end = end;
	}


	private double heuristic(Cell a, Cell b) {
		// double dist = Math.sqrt(Math.pow(a.getI() - b.getI(), 2) + Math.pow(a.getJ() - b.getJ(), 2));
		double dist = Math.abs(a.getI() - b.getI()) + Math.abs(a.getJ() - b.getJ());
		return dist;
	}
	
	
	public void init(GameContainer gc) throws SlickException {
		this.openSet = new ArrayList<>();
		this.closedSet = new ArrayList<>();
		this.path = new ArrayList<>();
		
		for (int i = 0; i < Main.rows; i++) {
			for (int j = 0; j < Main.cols; j++) {
				Grid.grid[i][j].addNeighbors(this.grid);
			}
		}
		
		System.out.println("Start location : (" + this.start.getI() + "," + this.start.getJ() + ")");
		System.out.println("End location : (" + this.end.getI() + "," + this.end.getJ() + ")");

		this.start.setWall(false);
		this.end.setWall(false);
		
		this.openSet.add(this.start);
	}
	
	public void render(GameContainer gc, Graphics g) {
		for (Cell openCell : this.openSet) {
			openCell.render(gc, g, Color.green);
		}
		for (Cell closedCell : this.closedSet) {
			closedCell.render(gc, g, Color.red);
		}
		for (Cell pathCell : this.path) {
			pathCell.render(gc, g, Color.blue);
		}
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {

		if (this.openSet.size() > 0) {
			// keep going
			int winner = 0;
			for (int i = 0; i < this.openSet.size(); i++) {
				if (this.openSet.get(i).getfScore() < this.openSet.get(winner).getfScore()) {
					winner = i;
				}
			}
			Cell current = this.openSet.get(winner);

			if (current == this.end) {
				// Find the path
				Cell temp = current;
				this.path.add(temp);
				while (temp.getPrevious() != null) {
					this.path.add(temp.getPrevious());
					temp = temp.getPrevious();
				}
				System.out.println("DONE !");
				// gc.exit();
			}

			this.openSet.remove(current);
			this.closedSet.add(current);
			
			ArrayList<Cell> neighbors = current.getNeighbors();
			for (Cell neighbor : neighbors) {
				if (!this.closedSet.contains(neighbor) && !neighbor.isWall()) {
					double tempgScore = current.getgScore() + 1;

					boolean newPath = false;
					if (this.openSet.contains(neighbor)) {
						if (tempgScore < neighbor.getgScore()) {
							neighbor.setgScore(tempgScore);
							newPath = true;
						}
					} else {
						neighbor.setgScore(tempgScore);
						newPath = true;
						this.openSet.add(neighbor);
					}

					if (newPath) {
						neighbor.sethScore(this.heuristic(neighbor, this.end));
						neighbor.setfScore(neighbor.getgScore() + neighbor.gethScore());
						neighbor.setPrevious(current);
					}
				}
			}
		} else {
			System.out.println("No solution");
			// gc.exit();
		}

	}
	
}
