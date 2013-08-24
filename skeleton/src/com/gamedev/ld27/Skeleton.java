package com.gamedev.ld27;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gamedev.ld27.screens.GameScreen;
import com.gamedev.ld27.screens.TitleScreen;

public class Skeleton extends Game {

	public Map<String, GameScreen> screens;

	public Skeleton() {
		super();
		screens = new HashMap<String, GameScreen>();
	}

	@Override
	public void create() {
		screens.put("Title", new TitleScreen(this));

		setScreen(screens.get("Title"));
	}

	@Override
	public void dispose() {
		for (GameScreen screen : screens.values()) {
			screen.dispose();
		}
		Gdx.app.exit();
	}

}