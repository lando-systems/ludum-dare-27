package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;

public class WorldMap extends GameObject {

	private Sprite[] mapTiles; 
	private static int TILE_SIZE = 32;
	private int tilesWide;
	private int tilesHigh;
	
	private int mapWidth = 100;
	private int mapHeight = 100;
	private int[] mapGrid = new int[mapWidth * mapHeight]; // this is the game map indexes
	
	public WorldMap() {
		tilesWide = Assets.mapTiles.getWidth() / TILE_SIZE;
		tilesHigh = Assets.mapTiles.getHeight()/TILE_SIZE;
		mapTiles = new Sprite[tilesWide * tilesHigh]; 
		for (int y = 0; y < tilesHigh; y++){
			for (int x = 0; x < tilesWide; x++){
				mapTiles[x + (y * tilesWide)] = new Sprite(Assets.mapTiles, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
		
		
		//Load Map
		for (int i =0; i < mapGrid.length; i ++)
		{
			mapGrid[i] = Config.rand.nextInt(100);
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.begin();

		for(int y = 0; y < mapHeight; y++ ){
			for (int x = 0; x < mapWidth; x++) {
				Sprite tile = mapTiles[mapGrid[x + (y *mapWidth)]];
				//tile.setOrigin(tile.getWidth()/2, tile.getHeight()/2);
				tile.setPosition(-Config.screenHalfWidth + x * TILE_SIZE, -Config.screenHalfHeight + y * TILE_SIZE );
				tile.draw(batch);
			}
		}
		batch.end();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}



}
