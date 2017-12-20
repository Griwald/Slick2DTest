package gameOfLife;


import org.newdawn.slick.*;


public class Main extends BasicGame {
	
	public static final int width = 800;
	public static final int height = 800;
	private static final boolean fullscreen = false;
	private static final String name = "Game of life";
	
	public static int rows = 50;
	public static int cols = 50;
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
			app.setTargetFrameRate(20);
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
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		this.grid.render(gc, g);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

		Input input = gc.getInput();
		Integer[] collection = { Input.KEY_SPACE, Input.KEY_ENTER };
		for (Integer key : collection) {
			if (input.isKeyPressed(key)) {
				switch (key) {
					case Input.KEY_ENTER:
						gc.reinit();
				}
			}
		}

		this.launchGeneration(gc);
	}

	public void launchGeneration(GameContainer gc) throws SlickException {
		Grid next = new Grid(Main.rows, Main.cols);
		next.init(gc);

		for (int i = 0; i < Main.rows; i++) {
			for (int j = 0; j < Main.cols; j++) {
				int state = this.grid.getCell(i, j).getState();
				int neighbors = this.grid.getCell(i, j).countNeighbors(this.grid);

				if (state == 0 && neighbors == 3) {
					next.getCell(i, j).setState(1);
				} else if (state == 1 && (neighbors < 2 || neighbors > 3)) {
					next.getCell(i, j).setState(0);
				} else {
					next.getCell(i, j).setState(state);
				}

			}
		}
		
		this.grid = next;
	}
	
	
}
