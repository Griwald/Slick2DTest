package statedGame;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu extends BasicGameState {
	
	
	public Menu(int state) {
		
	}
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Menu Screen", 100, 50);
		g.drawString("Press (SPACE) to go to the Play screen", 100, 150);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			sbg.enterState(Game.play);
		}
	}
	
	@Override
	public int getID() {
		return Game.menu;
	}

}
