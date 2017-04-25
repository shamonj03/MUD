package com.joe.game.model;

public class Player extends Entity {
	
	private final Inventory inventory = new Inventory();
	
	private String name;
	
	public boolean setName(String name) {
		this.name = name;
		
		return name.length() >= 3 && !name.isEmpty() && name != null;
	}

	public String getName() {
		return name;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}
