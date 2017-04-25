package com.joe.game;

import com.joe.game.model.Camera;
import com.joe.game.model.CommandController;
import com.joe.game.model.Entity;
import com.joe.game.model.EntityController;
import com.joe.game.model.GameMap;
import com.joe.game.model.OrthographicCamera;
import com.joe.game.model.Player;
import com.joe.game.model.State;
import com.joe.game.util.TextUtil;

public class Game {

	private boolean running = true;

	private final EntityController<Entity> controller;

	private final CommandController commandCtroller;

	private Player player;

	private State state;

	private GameMap map;

	private Camera camera;

	public Game() {
		controller = new EntityController<>();
		//player = controller.addEntity(new Player());
		commandCtroller = new CommandController();
		map = new GameMap(this);
		camera = new OrthographicCamera();
	}

	public void initialize() {
		this.state = State.MAIN_MENU;
		this.commandCtroller.initialize();
	}

	public void process() {
		while (running) {
			commandCtroller.execute(this, state);
			System.out.println();
		}
		TextUtil.promptInput("Let's play again soon.");
		System.exit(0);
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public GameMap getMap() {
		return map;
	}

	public Camera getCamera() {
		return camera;
	}

	public EntityController<Entity> getController() {
		return controller;
	}
}
