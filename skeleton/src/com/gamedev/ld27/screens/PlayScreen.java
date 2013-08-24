package com.gamedev.ld27.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.gameobjects.GameObject;
import com.gamedev.ld27.gameobjects.WorldMap;

public class PlayScreen extends GameScreen {

	private ArrayList<GameObject> _gameObjects = new ArrayList<GameObject>();
	private OrthographicCamera camera;
	
	public PlayScreen(Skeleton game) {
		super(game);
		
		_gameObjects.add(new WorldMap());
		camera = new OrthographicCamera(Config.screenWidth, Config.screenHeight);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		for (GameObject gameObject : _gameObjects) {
			gameObject.update(delta);
		}
		
		
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
		
		Assets.batch.setProjectionMatrix(camera.combined);
		for (GameObject gameObject : _gameObjects) {
			gameObject.render(Assets.batch);
		}
	}

	@Override
	public void dispose() {
		
	}

}
