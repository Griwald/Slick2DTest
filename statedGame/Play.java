package statedGame;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import statedGame.Game;


public class Play extends BasicGameState {


	public Play(int state) {
		
	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Play Screen", 100, 50);
		g.drawString("Press (SPACE) to go to the Menu screen", 100, 150);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			sbg.enterState(Game.menu);
		}
	}

	@Override
	public int getID() {
		return Game.play;
	}
	
}
