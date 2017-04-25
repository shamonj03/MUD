package com.joe.game;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.joe.game.io.Definition;
import com.joe.game.io.data.StaticItemData;
import com.joe.game.io.data.StaticNpcData;

public class Main {

	public static Definition<StaticItemData> itemDefinition;
	public static Definition<StaticNpcData> npcDefinition;

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {	
		initialize();
		start();
	}

	private static void initialize() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();

		System.out.println("Loading item definitions...");
		StaticItemData[] data = gson.fromJson(new FileReader("./data/items.json"), StaticItemData[].class);
		itemDefinition = new Definition<>(data);
		System.out.println("Loaded " + data.length + " item definitions.");
		

		System.out.println("Loading npc definitions...");
		StaticNpcData[] npcData = gson.fromJson(new FileReader("./data/npcs.json"), StaticNpcData[].class);
		npcDefinition = new Definition<>(npcData);
		System.out.println("Loaded " + npcData.length + " npc definitions.");
	}
	
	private static void start() {
		Game game = new Game();
		game.initialize();
		game.process();
	}
	
	public static Definition<StaticNpcData> getNpcDefinition() {
		return npcDefinition;
	}

	public static Definition<StaticItemData> getItemDefinition() {
		return itemDefinition;
	}
}
