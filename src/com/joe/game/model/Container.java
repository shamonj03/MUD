package com.joe.game.model;

public interface Container {

	public void set(int slot, int id, int amount);
	
	public boolean add(int id, int amount);
	
	public boolean remove(int id, int amount);
	
	public int contains(int id, int amount);

}
