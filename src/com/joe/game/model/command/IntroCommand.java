package com.joe.game.model.command;

import com.joe.game.Game;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class IntroCommand implements Command {

	@Override
	public void execute(Game game) {
		TextUtil.scrollText("Hello.", "What is your name adventurer?");
		
		game.setState(State.CREATION);
	}

}
