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
import com.badlogic.gdx.math.Vector2;

import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.gameobjects.*;
import com.gamedev.ld27.items.offensive.*;
import com.gamedev.ld27.items.useful.*;

public class PlayScreen extends GameScreen {

	private ArrayList<GameObject> _gameObjects = new ArrayList<GameObject>();
	private OrthographicCamera camera;
	private float aiSpawn = 0f;
	
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
		
		Game.playScreen = this;
		
		Game.gameWorld = new WorldMap(new Rectangle(0, y, leftWidth, mapHeight));
		_gameObjects.add(Game.gameWorld);
		
		Game.player = new Player(new Rectangle((leftWidth/2.0f -16), y + (mapHeight/2.0f)-16, 32, 32));
		Game.player.init(100,  10, 10);
		_gameObjects.add(Game.player);
		
		y -= dialogHeight;
		
		Game.dialogBox = new DialogBox(new Rectangle(0, y, leftWidth, dialogHeight));
		_gameObjects.add(Game.dialogBox);
	
		Game.adBar = new AdBar(new Rectangle(0, 0, Config.screenWidth, adHeight));
		_gameObjects.add(Game.adBar);
		
		Game.itemsBar = new ItemsBar(new Rectangle(leftWidth, Config.screenHeight - topHeight, rightWidth, topHeight));
		_gameObjects.add(Game.itemsBar);
		

		
		camera = new OrthographicCamera(Config.screenWidth, Config.screenHeight);
		
		// test
//		Thread t = new Thread(new Runnable() {
//			public void run() {
//				try {
//					while (true) {
//						Game.dialogBox.AppendText("Text test" + Config.rand.nextInt(30));
//						Game.itemsBar.Add(new WetNoodle());
//						Game.adBar.selectRandomAd();
//						Thread.sleep(800);
//					}
//				} catch(Exception e) {
//				}
//			}
//		});
//		t.start();
		TESTCODE();
	}
	
	public ArrayList<GameObject> getGameObjects()
	{
		return _gameObjects;
	}

	private void spawnAI(){
		Vector2 tempPos; 
		do {
			tempPos = Game.player.pos.cpy();
			int dx = Assets.random.nextInt(20) - 10;
			int dy = Assets.random.nextInt(20) - 10;
			tempPos.add(dx*32,dy*32);
		} while (!Game.gameWorld.walkable(tempPos));

		DumbAI dumbAi = new DumbAI();
		Vector2 mapTile = Game.gameWorld.mapTileFromPosition(tempPos);
		dumbAi.init(100,  (int)mapTile.x,  (int)mapTile.y);
		_gameObjects.add(dumbAi);
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		aiSpawn -= delta;
		if (aiSpawn < 0) {
			aiSpawn += 10.0f;
			spawnAI();
		}
		ArrayList<GameObject> keepObjs = new ArrayList<GameObject>();
		for (GameObject gameObject : _gameObjects) {
			gameObject.update(delta);
			if (gameObject.Alive){
				keepObjs.add(gameObject);
			}
		}
		_gameObjects = keepObjs;
		
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
		
		Game.itemsBar.Add(new WetNoodle());
		Game.itemsBar.Add(new Hammer());
		Game.itemsBar.Add(new Boomerang());
		Game.itemsBar.Add(new Bombs());
		Game.itemsBar.Add(new Slinky());
		Game.itemsBar.Add(new SillyString());
		Game.itemsBar.Add(new BagOfKittens());
		Game.itemsBar.Add(new BouncyBall());
		Game.itemsBar.Add(new Torch());
		Game.itemsBar.Add(new OffensiveTower());
		
		
		//For now this just places a single ad, the rotation and randomization still to come
		Game.adBar.selectRandomAd();
	}

}
