package com.joe.game.model;

import com.joe.game.Game;
import com.joe.game.io.data.StaticGameMapData;

public class GameMap {

	private Game game;

	public GameMap(Game game) {
		this.game = game;
	}

	public void drawMap() {
		String[][] data = StaticGameMapData.map;

		int height = data.length;
		int width = data[0].length;

		Player player = game.getPlayer();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				String e = data[y][x];

				if (x == player.getPosition().getX() && y == player.getPosition().getY()) {
					System.out.print("P\t");
				} else {
					System.out.print(e + "\t");
				}
			}
			System.out.println();
		}
	}

	public void drawPerspective() {
		String[][] data = StaticGameMapData.map;

		Camera camera = game.getCamera();
		Player player = game.getPlayer();

		int width = Math.round(camera.getWidth() / 2.0f);
		int height = Math.round(camera.getHeight() / 2.0f);
		
		Position focus = camera.getFocus();
		
		for (int y = -height; y < height; y++) {
			for (int x = -width; x < width; x++) {

				int posY = (int) (focus.getY() + y);
				int posX = (int) (focus.getX() + x);
				
				if(posY < 0 || posX < 0 || posY >= data.length || posX >= data[0].length) {
					continue;
				}
				
				String e = data[posY][posX];

				if (posX == player.getPosition().getX() && posY == player.getPosition().getY()) {
					printToMap("P\t");
				} else {
					printToMap(e + "\t");
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public void printToMap(String entity) {
		System.out.printf("%1s", entity);
	}
	
	public boolean checkCollision(Position position, Direction direction) {
		int nX = (int) (position.getX() + direction.getDx());
		int nY = (int) (position.getY() + direction.getDy());
		
		String[][] data = StaticGameMapData.map;

		if(nY < 0 || nY < 0 || nY >= data.length || nX >= data[0].length) {
			return false;
		}
		
		String e = data[nY][nX];
		
		if(e.equalsIgnoreCase("w")) {
			return true;
		}
		return false;	
	}
}
