package com.joe.game.model;

import com.joe.game.Main;
import com.joe.game.io.data.StaticItemData;

public class Inventory implements Container {

	public static final int SIZE = 32;

	public static final int ANY_AMOUNT = 1;
	
	public static final int DNE = -1;

	private final Item[] inventory = new Item[SIZE];

	@Override
	public void set(int slot, int id, int amount) {
		if (slot < 0 | slot >= SIZE) {
			throw (new ArrayIndexOutOfBoundsException("Item @ slot " + slot + " must be between slot 0 and " + SIZE));
		}
		inventory[slot] = new Item(id, amount);
	}

	@Override
	public boolean add(int id, int amount) {
		StaticItemData data = Main.getItemDefinition().get(id);
		int slot = getOpenSlot();

		if (slot == DNE) {
			return false;
		}

		if (data.isStackable()) {
			int current_slot = contains(id, ANY_AMOUNT);

			if (current_slot == DNE) {
				inventory[slot] = new Item(id, amount);
			} else {
				Item item = inventory[current_slot];
				
				inventory[current_slot] = new Item(id, item.getAmount() + amount);
			}
		} else {
			inventory[slot] = new Item(id, amount);
		}
		return true;
	}

	@Override
	public boolean remove(int id, int amount) {
		return false;
	}

	public int getOpenSlot() {
		for (int i = 0; i < SIZE; i++) {
			if (inventory[i] == null) {
				return i;
			}
		}
		return DNE;
	}

	@Override
	public int contains(int id, int amount) {
		for (int i = 0; i < SIZE; i++) {
			Item item = inventory[i];

			if (item == null) {
				continue;
			}

			if (item.getId() == id && item.getAmount() >= amount) {
				return i;
			}
		}
		return DNE;
	}
}
