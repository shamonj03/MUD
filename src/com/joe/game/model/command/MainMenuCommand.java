package com.joe.game.model.command;

import com.joe.game.Game;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class MainMenuCommand implements Command {

	
	private static final String[] LOGO = 
{" 			   _________ __                       .____                       .___	",
 "			  /   _____//  |_  ___________  _____ |    |   _____    ____    __| _/	",
 "			  \\_____   \\   __\\/  _ \\_  __ \\/     \\|    |   \\__  \\  /    \\  / __ |	", 
 "			  /        7|  | (  <_> )  | \\/  Y Y  \\    |___ / __ \\|   |  \\/ /_/ |	", 
 "			 /_______  /|__|  \\____/|__|  |__|_|  /_______ (____  /___|  /\\____ |	",
 "			         \\/                         \\/        \\/    \\/     \\/      \\/ 	",
 "																					"};			         
			         
			         @Override
	public void execute(Game game) {
		for(int i = 0; i < LOGO.length; i++) {
			System.out.println(LOGO[i]);
		}
		
		System.out.println("--Main Menu--");
		TextUtil.scrollText("1: Continue Game", 
				            "2: Create Character", 
				            "3: Exit");
		
		int optInt = TextUtil.promptInputInt("Enter option: ");
		
		if(optInt == 1) {
			game.setState(State.SELECT_CHARACTER);
		} else if(optInt == 2) {
			game.setState(State.INTRO);
		} else {
			game.setRunning(false);
		}
	}
}
