package com.joe.game.model;

import com.joe.game.Main;
import com.joe.game.io.data.StaticItemData;

public class Item {

	private final StaticItemData data;

	private int amount;

	private int id;

	private float durability = 1.0f;

	public Item(int id, int amount) {
		this.amount = amount;
		this.id = id;
		this.data = Main.itemDefinition.get(id);
	}

	public void setAmount(int amount) {
		if (amount < 0) {
			this.amount = 0;
		}
		this.amount = amount;
	}

	public void setDurability(float durability) {
		if (durability < 0) {
			this.durability = 0;
		}
		this.durability = durability;
	}

	public StaticItemData getData() {
		return data;
	}

	public int getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public float getDurability() {
		return durability;
	}
}
