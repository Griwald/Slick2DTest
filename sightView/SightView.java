package sightView;


import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class SightView {
	
	private Grid grid;
	private Cell start;
	private Cell end;

	private ArrayList<Cell> path;
	
	
	public SightView(Grid grid, Cell start, Cell end) {
		this.grid = grid;
		this.start = start;
		this.end = end;
	}


	public void init(GameContainer gc) throws SlickException {
		this.path = new ArrayList<>();
		
		System.out.println("Start location : (" + this.start.getI() + "," + this.start.getJ() + ")");
		System.out.println("End location : (" + this.end.getI() + "," + this.end.getJ() + ")");
		
		this.start.setWall(false);
		this.end.setWall(false);
	}

	public void render(GameContainer gc, Graphics g) {
		for (Cell cell : this.path) {
			cell.render(gc, g, Color.blue);
		}
	}

	public void update(GameContainer gc, int delta) throws SlickException {
	}


	public void showPath() {
		int dx, dy, dp, deltaE, deltaNE, x, y, ybas, yhaut, xbas, xhaut;
		
		if (this.start.getI() < this.end.getI()) {
			yhaut = this.start.getI();
			ybas = this.end.getI();
			xhaut = this.start.getJ();
			xbas = this.end.getJ();
		} else {
			ybas = this.start.getI();
			yhaut = this.end.getI();
			xbas = this.start.getJ();
			xhaut = this.end.getJ();
		}
		
		if (xhaut >= xbas) {
			dx = xhaut - xbas;
			dy = ybas - yhaut;
			if (dx >= dy) {
				dp = 2 * dy - dx;
				deltaE = 2 * dy;
				deltaNE = 2 * (dy - dx);
				x = xbas;
				y = ybas;
				this.path.add(this.grid.getCell(y, x));
				while (x < xhaut) {
					if (dp <= 0) {
						dp = dp + deltaE;
						x++;
					} else {
						dp = dp + deltaNE;
						x++;
						y--;
					}
					this.path.add(this.grid.getCell(y, x));
				}
			} else {
				dp = 2 * dx - dy;
				deltaE = 2 * dx;
				deltaNE = 2 * (dx - dy);
				x = xbas;
				y = ybas;
				
				this.path.add(this.grid.getCell(y, x));
				while (x < xhaut) {
					if (dp <= 0) {
						dp = dp + deltaE;
						y--;
						
					} else {
						dp = dp + deltaNE;
						x++;
						y--;
					}
					this.path.add(this.grid.getCell(y, x));
				}
			}
		} else {
			dx = xbas - xhaut;
			dy = ybas - yhaut;
			if (dx >= dy) {
				dp = 2 * dy - dx;
				deltaE = 2 * dy;
				deltaNE = 2 * (dy - dx);
				x = xhaut;
				y = yhaut;
				
				this.path.add(this.grid.getCell(y, x));
				while (x < xbas) {
					if (dp <= 0) {
						dp = dp + deltaE;
						x++;
						
					} else {
						dp = dp + deltaNE;
						x++;
						y++;
					}
					this.path.add(this.grid.getCell(y, x));
				}
			} else {
				dp = 2 * dx - dy;
				deltaE = 2 * dx;
				deltaNE = 2 * (dx - dy);
				x = xhaut;
				y = yhaut;
				
				this.path.add(this.grid.getCell(y, x));
				while (x < xbas) {
					if (dp <= 0) {
						dp = dp + deltaE;
						y++;
						
					} else {
						dp = dp + deltaNE;
						x++;
						y++;
					}
					this.path.add(this.grid.getCell(y, x));
				}
			}
		}
	}

}
