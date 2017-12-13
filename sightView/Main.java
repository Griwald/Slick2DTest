package sightView;


import org.newdawn.slick.*;


public class Main extends BasicGame {
	
	public static final int width = 400;
	public static final int height = 400;
	private static final boolean fullscreen = false;
	private static final String gameName = "A* Algorithm";
	
	public static int rows = 15;
	public static int cols = 15;
	private Grid grid;
	private SightView sw;
	
	
	public Main(String title) {
		super(title);
	}
	
	
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Main(Main.gameName));
			app.setDisplayMode(Main.width, Main.height, Main.fullscreen);
			app.setForceExit(true);
//			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		this.grid = new Grid(Main.rows, Main.cols);
		this.grid.init(gc);
		System.out.println("Cell size : " + Grid.cellSize);
		
		Cell start = this.grid.getCell(7, 7);
		Cell end = this.grid.getCell(5, 14);
		this.sw = new SightView(this.grid, start, end);
		this.sw.init(gc);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		this.grid.render(gc, g);
		this.sw.render(gc, g);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		this.sw.showPath();
	}
	
}
