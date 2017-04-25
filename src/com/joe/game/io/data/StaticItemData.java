package com.joe.game.io.data;

public class StaticItemData extends StaticData {

	private String name;
	private int[] baseStats;
	private boolean stackable;
	
	public final int[] getBaseStats() {
		return baseStats;
	}
	
	public final String getName() {
		return name;
	}
	
	public boolean isStackable() {
		return stackable;
	}
}
