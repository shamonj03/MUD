package com.joe.game.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EntityController<E extends Entity> {

	private final Map<UUID, E> entities = new HashMap<UUID, E>();

	public <T extends E> T addEntity(T e) {
		if(entities.containsKey(e.getUUID())) {
			throw new IllegalStateException("Entity " + e.getUUID() + ": Already exists.");
		}
		entities.put(e.getUUID(), e);
		return e;
	}

	@SuppressWarnings("unchecked")
	public <T extends E> T getEntity(UUID id) {
		T val = (T) entities.get(id);

		if (val == null) {
			throw new NullPointerException("Entity " + id + ": Does not exist.");
		}
		return val;
	}
	
	public boolean removeEntity(UUID id) {
		E val = entities.get(id);

		if (val == null) {
			throw new NullPointerException("Entity " + id + ": Does not exist.");
		}
		return entities.remove(val.getUUID(), val);
	}
}
