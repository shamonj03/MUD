package com.joe.game.model;

public enum Direction {
	
	NORTH(0, -1),
	SOUTH(0, 1),
	EAST(1, 0),
	WEST(-1, 0),
	NONE(0, 0);
	
	private int dx, dy;
	
	private Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
}
