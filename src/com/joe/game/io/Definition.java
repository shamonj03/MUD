package com.joe.game.io;

import java.io.FileNotFoundException;

import com.joe.game.io.data.StaticData;

public class Definition<T extends StaticData> {

	private final T[] data;
	
	public Definition(T[] data) throws FileNotFoundException {
		for(int i = 0; i < data.length; i++) {
			if(data[i].getID() != i) {
				throw(new NullPointerException("Data: " + i + " is missing or out of order."));
			}
		}
		this.data = data;
	}

	public T get(int id) {
		if(id < 0 || id > data.length) {
			throw(new ArrayIndexOutOfBoundsException("Data: " + id + " is out of bounds."));
		}
		if(data[id] == null) {
			throw(new NullPointerException("Data: " + id + " does not exist."));
		}
		return data[id];
	}
}
