package com.gamedev.ld27;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.gamedev.ld27.screens.GameScreen;
import com.gamedev.ld27.screens.PlayScreen;
import com.gamedev.ld27.screens.TitleScreen;

public class Skeleton extends Game {

	public Map<String, GameScreen> screens;

	public Skeleton() {
		super();
		screens = new HashMap<String, GameScreen>();
	}

	@Override
	public void create() {
		Assets.load();
		
		screens.put("Title", new TitleScreen(this));
		screens.put("Play", new PlayScreen(this));

		setScreen(screens.get("Title"));
	}

	@Override
	public void dispose() {
		for (GameScreen screen : screens.values()) {
			screen.dispose();
		}
		Assets.dispose();
		Gdx.app.exit();
	}

}