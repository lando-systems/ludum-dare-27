package com.gamedev.ld27.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.Utils;
import com.badlogic.gdx.math.Rectangle;

import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.gameobjects.*;
import com.gamedev.ld27.items.offensive.*;
import com.gamedev.ld27.items.useful.*;
import com.gamedev.ld27.items.modifiers.*;

public class PlayScreen extends GameScreen {

	private ArrayList<GameObject> _gameObjects = new ArrayList<GameObject>();
	private OrthographicCamera camera;
	
	public PlayScreen(Skeleton game) {
		super(game);
		Utils.updateInput();
		// grid sizes
		float leftWidth = Config.screenWidth * 0.9f;
		float rightWidth = Config.screenWidth - leftWidth;
		
		float topHeight = Config.screenHeight * 0.8f;
		float mapHeight = Config.screenHeight * 0.6f;
		float dialogHeight = topHeight - mapHeight;
		
		float adHeight = Config.screenHeight - topHeight;
		
		float y = Config.screenHeight - mapHeight;
		
		Game.gameWorld = new WorldMap(new Rectangle(0, y, leftWidth, mapHeight));
		_gameObjects.add(Game.gameWorld);
		
		Game.player = new Player(new Rectangle((leftWidth/2.0f -16), y + (mapHeight/2.0f)-16, 32, 32));
		_gameObjects.add(Game.player);
		
		y -= dialogHeight;
		
		Game.dialogBox = new DialogBox(new Rectangle(0, y, leftWidth, dialogHeight));
		_gameObjects.add(Game.dialogBox);
	
		Game.adBar = new AdBar(new Rectangle(0, 0, Config.screenWidth, adHeight));
		_gameObjects.add(Game.adBar);
		
		Game.itemsBar = new ItemsBar(new Rectangle(leftWidth, Config.screenHeight - topHeight, rightWidth, topHeight));
		_gameObjects.add(Game.itemsBar);
		
		camera = new OrthographicCamera(Config.screenWidth, Config.screenHeight);
		
		TESTCODE();
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		for (GameObject gameObject : _gameObjects) {
			gameObject.update(delta);
		}
		
		if (Utils.isKeyJustPressed(Keys.DOWN)) {
			Game.itemsBar.selectNext(true);
		} 
		else if (Utils.isKeyJustPressed(Keys.UP)) {
			Game.itemsBar.selectNext(false);
		}
		else if (Utils.isKeyJustPressed(Keys.SPACE)) {
			Game.itemsBar.useItem();			
		}
				
//		if (Gdx.input.justTouched()) {
//			game.setScreen(game.screens.get("Title"));
//		}

		// TODO : update all the things...
		
		Utils.updateInput(); // Must be called last!!!
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
		
		Game.player.render(Assets.batch);
		Assets.batch.end();
	}

	@Override
	public void dispose() {
		
	}
	
	public void TESTCODE() {
		// test
//				Thread t = new Thread(new Runnable() {
//					public void run() {
//						try {
//							while (true) {
//								Game.dialogBox.AppendText("Text test" + Config.rand.nextInt(30));
//								Game.itemsBar.Add(new WetNoodle());
//								Thread.sleep(800);
//							}
//						} catch(Exception e) {
//						}
//					}
//				});
//				t.start();
		
		Game.itemsBar.Add(new WetNoodle(), 0);
		Game.itemsBar.Add(new BagOfJewels(), 1);
		Game.itemsBar.Add(new Hammer(), 2);
		Game.itemsBar.Add(new Boomerang(), 3);
		Game.itemsBar.Add(new Bombs(), 4);
		Game.itemsBar.Add(new Mushroom(), 5);
		Game.itemsBar.Add(new Bacon(), 6);
	}

}
