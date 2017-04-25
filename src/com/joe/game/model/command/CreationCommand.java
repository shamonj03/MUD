package com.joe.game.model.command;

import com.joe.game.Game;
import com.joe.game.io.PlayerIO;
import com.joe.game.model.Player;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class CreationCommand implements Command {

	@Override
	public void execute(Game game) {
		String name = "";
		
		Player player = game.getPlayer();
		
		boolean cont = false;
		while (!cont) {
			name = TextUtil.promptInput("Enter your name: ");
			cont = player.setName(name);
			
			if(!cont) {
				TextUtil.scrollText("Invalid name, try again..");
			}
		}
		TextUtil.scrollText("Hello " + player.getName() + ".");
		
		PlayerIO.save(player);
		
		game.setState(State.PLAYING);
	}

}
