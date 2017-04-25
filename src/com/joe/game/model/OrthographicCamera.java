package com.joe.game.model;

public class OrthographicCamera implements Camera {

	private float aspect;

	private float size;
	
	private Position position = new Position(0, 0, 0);

	public OrthographicCamera(float aspect, float size) {
		this.aspect = aspect;
		this.size = size;
	}

	public OrthographicCamera(float size) {
		this(16.0f / 9.0f, size);
	}

	public OrthographicCamera() {
		this(3.0f);
	}
	
	@Override
	public void setFocus(Position position) {
		this.position.set(position.getX(), position.getY(), position.getZ());
	}

	@Override
	public float getWidth() {
		return getHeight() * aspect;
	}

	@Override
	public float getHeight() {
		return 2.0f * size;
	}

	@Override
	public Position getFocus() {
		return position;
	}

}
