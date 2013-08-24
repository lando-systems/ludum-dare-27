package com.gamedev.ld27.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

import com.gamedev.ld27.Skeleton;

public class PlayScreen extends GameScreen {

	public PlayScreen(Skeleton game) {
		super(game);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		if (Gdx.input.justTouched()) {
			game.setScreen(game.screens.get("Title"));
		}

		// TODO : update all the things...
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1.f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		// TODO : render all the things...
	}

	@Override
	public void dispose() {
		
	}

}
