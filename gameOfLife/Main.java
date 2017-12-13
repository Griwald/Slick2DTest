package gameOfLife;


import org.newdawn.slick.*;


public class Main extends BasicGame {

	public static final int width = 400;
	public static final int height = 400;
	private static final boolean fullscreen = false;
	private static final String name = "A* Algorithm";
	
	public static int rows = 5;
	public static int cols = 5;
	private Grid grid;


	public Main(String title) {
		super(title);
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Main(Main.name));
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

//		for (int i = 0; i < Main.rows; i++) {
//			for (int j = 0; j < Main.cols; j++) {
//				System.out.println(this.grid.getCell(i, j));
//			}
//		}
	
	
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		this.grid.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
