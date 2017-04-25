package com.joe.game.model;

public interface Camera {

	public Position getFocus();
	
	public float getWidth();
	
	public float getHeight();
	
	public void setFocus(Position position);
}
