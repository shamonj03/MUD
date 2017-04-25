package com.joe.game.model.command;

import com.joe.game.Game;
import com.joe.game.util.TextUtil;

public class DefaultCommand implements Command {

	@Override
	public void execute(Game game) {
		String input = TextUtil.promptInput("Type exit to quit: ");
		
		if(input.equalsIgnoreCase("exit")) {
			game.setRunning(false);
		}
	}

}
