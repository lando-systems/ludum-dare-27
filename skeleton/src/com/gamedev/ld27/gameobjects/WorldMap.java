package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.gamedev.ld27.Assets;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.gamedev.ld27.Config;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class WorldMap extends GameObject {

	private Sprite[] mapTiles; 
	private static int TILE_SIZE = 32;
	private int tilesWide;
	private int tilesHigh;
	
	private TiledMap map;
	private int mapWidth = 100;
	private int mapHeight = 100;
	private int[] mapGrid; // this is the game map indexes
	private Vector2 charPos;
	
	private static float SPEED = 100.0f;
	
	public WorldMap(Rectangle bounds) {
		super(bounds);
		charPos = new Vector2();
		tilesWide = Assets.mapTiles.getWidth() / TILE_SIZE;
		tilesHigh = Assets.mapTiles.getHeight()/TILE_SIZE;
		mapTiles = new Sprite[tilesWide * tilesHigh]; 
		for (int y = 0; y < tilesHigh; y++){
			for (int x = 0; x < tilesWide; x++){
				mapTiles[x + (y * tilesWide)] = new Sprite(Assets.mapTiles, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
		
		
		//Load Map
		map = new TmxMapLoader().load("data/map.tmx");
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
		mapGrid = new int[layer.getWidth() * layer.getHeight()];
		mapWidth = layer.getWidth();
		mapHeight = layer.getHeight();
		for (int i =0; i < mapGrid.length; i ++)
		{
			mapGrid[i] = layer.getCell(i % mapWidth, i / mapWidth).getTile().getId()-1;
		}

	}

	@Override
	public void render(SpriteBatch batch) {
				
		for(int y = -100; y < mapHeight + 100; y++ ){
			for (int x = -100; x < mapWidth + 100; x++) {
				Sprite tile;
				Rectangle viewPort = new Rectangle(charPos.x, charPos.y, _bounds.width, _bounds.height);
				if (!viewPort.contains(x*32, y*32) && !viewPort.contains((x+1)*32, (y+1)*32) &&
					!viewPort.contains(x*32, (y+1)*32) && !viewPort.contains((x+1)*32, y*32)) continue;
				if (x < 0 || x >= mapWidth || y < 0 || y >= mapHeight)
				{
					tile = mapTiles[2]; // Make this Mountains
				}
				else {
					tile = mapTiles[mapGrid[x + (y *mapWidth)]];
				}
				
				tile.setPosition(_bounds.x -charPos.x -Config.screenHalfWidth + x * TILE_SIZE, _bounds.y - charPos.y -Config.screenHalfHeight + y * TILE_SIZE );
				tile.draw(batch);
			}
		}
	}

	@Override
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.W)){
			charPos.y += delta * SPEED;
		}
		if(Gdx.input.isKeyPressed(Keys.A)){
			charPos.x -= delta * SPEED;
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			charPos.y -= delta * SPEED;
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			charPos.x += delta * SPEED;
		}
	}
}
