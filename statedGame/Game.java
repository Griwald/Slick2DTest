package statedGame;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame {
	
	public static final int width = 500;
	public static final int height = 500;
	private static final boolean fullscreen = false;
	private static final String gameName = "State based game";
	
	public static final int menu = 0;
	public static final int play = 1;
	
	
	public Game(String name) {
		super(name);
		this.addState(new Menu(Game.menu));
		this.addState(new Play(Game.play));
	}


	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game(Game.gameName));
			app.setDisplayMode(Game.width, Game.height, Game.fullscreen);
			app.setTitle("Grid");
			app.setForceExit(true);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(Game.menu).init(gc, this);
		this.getState(Game.play).init(gc, this);
		this.enterState(Game.menu);
	}

}
