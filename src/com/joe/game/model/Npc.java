package com.joe.game.model;

import com.joe.game.Main;
import com.joe.game.io.data.StaticNpcData;

public class Npc extends Entity {

	private final int ID;

	public Npc(int ID) {
		this.ID = ID;
	}
	
	
	public StaticNpcData getData() {
		return Main.npcDefinition.get(ID);
	}
	
	public int getID() {
		return ID;
	}
}
