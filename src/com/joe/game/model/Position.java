package com.joe.game.model;

public class Position {

	private float x;
	private float y;
	private float z;
	
	public Position(float x, float y, float z) {
		set(x, y, z);
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void translate(float dx, float dy, float dz) {
		this.x += dx;
		this.y += dy;
		this.z += dz;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
}
