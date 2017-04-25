package com.joe.game.model;

import java.util.UUID;

public class Entity {

	private final UUID uuid;

	private Direction direction = Direction.NONE;
	
	private Position position = new Position(0, 0, 0);
	
	public Entity() {
		this.uuid = UUID.randomUUID();
	}
	
	public void move() {
		position.translate(direction.getDx(), direction.getDy(), 0);
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
	
	public UUID getUUID() {
		return uuid;
	}
	
	public Position getPosition() {
		return position;
	}
}
