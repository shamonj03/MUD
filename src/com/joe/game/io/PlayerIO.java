package com.joe.game.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joe.game.model.Player;

public class PlayerIO {

	public static final String PLAYER_SAVES = "./saves/players/";

	public static Player load(String name) throws FileNotFoundException {
		Player player = null;

		Gson gson = new Gson();

		File file = new File(PLAYER_SAVES);

		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(file + "/" + name + ".txt");
		
		FileReader reader = new FileReader(file);
		player = gson.fromJson(reader, Player.class);

		return player;
	}

	public static boolean save(Player player) {
		GsonBuilder builder = new GsonBuilder();
		builder = builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		File file = new File(PLAYER_SAVES);

		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(file + "/" + player.getName() + ".txt");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			gson.toJson(player, writer);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
