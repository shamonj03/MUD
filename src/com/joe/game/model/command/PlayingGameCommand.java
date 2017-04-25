package com.joe.game.model.command;

import com.joe.game.Game;
import com.joe.game.io.PlayerIO;
import com.joe.game.model.Direction;
import com.joe.game.model.GameMap;
import com.joe.game.model.Player;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class PlayingGameCommand implements Command {

	@Override
	public void execute(Game game) {
		GameMap map = game.getMap();
		Player player = game.getPlayer();

		map.drawPerspective();
		System.out.println();

		System.out.println("--Controls--");
		System.out.println("Movement: North(w), West(a), South(s), East(d)");
		System.out.println("Character: Inventory(i), Equipment(e), Skills(x), Quests(q)");
		System.out.println("O: Main Menu(m), Logout(l)");
		
		char opt = TextUtil.promptInputChar("Enter Option: ");

		if (opt == 'w' || opt == 'a' || opt == 's' || opt == 'd') {
			if (opt == 'd') {
				player.setDirection(Direction.EAST);
			} else if (opt == 'w') {
				player.setDirection(Direction.NORTH);
			} else if (opt == 'a') {
				player.setDirection(Direction.WEST);
			} else if (opt == 's') {
				player.setDirection(Direction.SOUTH);
			}

			if (!map.checkCollision(player.getPosition(), player.getDirection())) {
				player.move();
			}
			game.getCamera().setFocus(player.getPosition());
		}
		
		if(opt == 'i') {
			
		}
		if(opt == 'e') {
			
		}
		if(opt == 'x') {
			
		}
		if(opt == 'q') {
			
		}
		
		if(opt =='m') {
			PlayerIO.save(player);
			game.setState(State.MAIN_MENU);
		}
		if(opt == 'l') {
			PlayerIO.save(player);
			System.exit(0);
		}
	}

}
