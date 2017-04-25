package com.joe.game.model;

import java.util.HashMap;
import java.util.Map;

import com.joe.game.Game;
import com.joe.game.model.command.Command;
import com.joe.game.model.command.ContinueGameCommand;
import com.joe.game.model.command.CreationCommand;
import com.joe.game.model.command.DefaultCommand;
import com.joe.game.model.command.IntroCommand;
import com.joe.game.model.command.MainMenuCommand;
import com.joe.game.model.command.PlayingGameCommand;

public class CommandController {

	
	private final Map<State, Command> commands = new HashMap<>();
		
	public void initialize() {
		commands.put(State.MAIN_MENU, new MainMenuCommand());
		commands.put(State.SELECT_CHARACTER, new ContinueGameCommand());
		commands.put(State.INTRO, new IntroCommand());
		commands.put(State.CREATION, new CreationCommand());
		commands.put(State.DEFAULT, new DefaultCommand());
		commands.put(State.PLAYING, new PlayingGameCommand());
	}
	
	public void execute(Game game, State state) {
		Command command = commands.get(state);
		
		if(command == null) {
			throw new NullPointerException("Unhandled Comman: " + state);
		}
		
		command.execute(game);
	}
}
