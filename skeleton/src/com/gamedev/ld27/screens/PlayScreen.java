package com.gamedev.ld27.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.badlogic.gdx.math.Rectangle;

import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.gameobjects.*;

public class PlayScreen extends GameScreen {

	private ArrayList<GameObject> _gameObjects = new ArrayList<GameObject>();
	private OrthographicCamera camera;
	
	public PlayScreen(Skeleton game) {
		super(game);
		
		// grid sizes
		float leftWidth = Config.screenWidth * 0.9f;
		float rightWidth = Config.screenHeight - leftWidth;
		
		float topHeight = Config.screenHeight * 0.9f;
		float mapHeight = Config.screenHeight * 0.6f;
		float dialogHeight = topHeight - mapHeight;
		
		float adHeight = Config.screenHeight - topHeight;
		
		_gameObjects.add(new WorldMap(new Rectangle(0, 0, leftWidth, mapHeight)));
		_gameObjects.add(new DialogBox(new Rectangle(0, mapHeight, leftWidth, dialogHeight)));
		_gameObjects.add(new AdBar(new Rectangle(0, topHeight, Config.screenWidth, adHeight)));
		_gameObjects.add(new ItemsBar(new Rectangle(leftWidth, 0, rightWidth, topHeight)));		
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
		Assets.batch.begin();
		for (GameObject gameObject : _gameObjects) {
			gameObject.render(Assets.batch);
		}
		Assets.batch.end();
	}

	@Override
	public void dispose() {
		
	}

}
