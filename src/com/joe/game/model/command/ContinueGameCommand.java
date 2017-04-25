package com.joe.game.model.command;

import java.io.File;
import java.io.FileNotFoundException;

import com.joe.game.Game;
import com.joe.game.io.PlayerIO;
import com.joe.game.model.Player;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class ContinueGameCommand implements Command {

	@Override
	public void execute(Game game) {
		File[] files = new File(PlayerIO.PLAYER_SAVES).listFiles();

		System.out.println("--Choose Your Character--");
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			name = name.replaceAll(".txt", "");
			System.out.println((i + 1) + ": " + name);
		}
		System.out.println("0: Exit");

		int optInt = TextUtil.promptInputInt("Enter option: ");
		
		while (optInt < 0 || optInt >= files.length + 1) {
			TextUtil.scrollText("Invalid input, try again.");
			optInt = TextUtil.promptInputInt("Enter option: ");
		}

		if (optInt == 0) {
			game.setRunning(false);
		} else if (optInt < files.length + 1) {
			String name = files[optInt - 1].getName();
			name = name.replaceAll(".txt", "");
			
			try {
				Player player = PlayerIO.load(name);
				
				game.setPlayer(player);
				game.getCamera().setFocus(player.getPosition());
				game.setState(State.PLAYING);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
