package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.gamedev.ld27.Config;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.items.BaseItem;

public class WorldMap extends GameObject {

	private Sprite[] mapTiles; 
	private static int TILE_SIZE = 32;
	private int tilesWide;
	private int tilesHigh;
	
	private TiledMap map;
	private int mapWidth = 100;
	private int mapHeight = 100;
	private int[] mapGrid; // this is the game map indexes
	
	private ArrayList<BaseItem> worldItems = new ArrayList<BaseItem>(20);
	
	public WorldMap(Rectangle bounds) {
		super(bounds);

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
	public void update(float delta) {
		ArrayList<BaseItem> itemsToRemove= new ArrayList<BaseItem>();
		for (BaseItem item:worldItems) {
			item.update(delta);
			
			if (item.isAutoPickup() || Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
				if (PickUpItem(item)) {
					itemsToRemove.add(item);
					Game.dialogBox.AppendText("You picked up the " + item.getName());
				}
			}
		}
		for (BaseItem item : itemsToRemove) {
			worldItems.remove(item);
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		int playerTileX = (int)Game.player.pos.x/32;
		int playerTileY = (int)Game.player.pos.y/32;
		
		for(int y = playerTileY - 40; y < playerTileY + 40; y++ ){
			for (int x = playerTileX - 40; x < playerTileX + 40; x++) {
				Sprite tile;
				Rectangle viewPort = new Rectangle(Game.player.pos.x - (_bounds.width/2.0f), Game.player.pos.y - (_bounds.height/2.0f), _bounds.width, _bounds.height);
				
				// Not on screen
				if (!viewPort.contains((x-2)*32, (y-2)*32) && !viewPort.contains((x+2)*32, (y+2)*32) &&
					!viewPort.contains((x-2)*32, (y+2)*32) && !viewPort.contains((x+2)*32, (y-2)*32)) continue;
				
				if (x < 0 || x >= mapWidth || y < 0 || y >= mapHeight)
				{
					tile = mapTiles[2]; // Make this Mountains
				}
				else {
					tile = mapTiles[mapGrid[x + (y *mapWidth)]];
				}
				screenPositionFromWorld(tile, new Vector2(x*TILE_SIZE, y * TILE_SIZE));
				tile.draw(batch);
			}
		}
		
		for (BaseItem item: worldItems){
			Sprite tile = item.getIcon();
			screenPositionFromWorld(tile, item.getPosition());
			tile.draw(batch);
		}
	}
	
	public void screenPositionFromWorld(Sprite tile, Vector2 pos){
		tile.setPosition(_bounds.x + (_bounds.width/2.0f) - 16 - Game.player.pos.x -Config.screenHalfWidth + pos.x, _bounds.y + (_bounds.height/2.0f) - 16 - Game.player.pos.y -Config.screenHalfHeight + pos.y );
	}
	
	public Vector2 worldPosToScreenMapPos(Vector2 pos){
		return new Vector2(_bounds.x + (_bounds.width/2.0f) - 16 - Game.player.pos.x -Config.screenHalfWidth + pos.x, _bounds.y + (_bounds.height/2.0f) - 16 - Game.player.pos.y -Config.screenHalfHeight + pos.y );
	}
	
	public boolean walkable(Vector2 worldPos) {
		int tileType = getTileType(worldPos);
		if (tileType == 0 || tileType == 3 || tileType == 4 || tileType == 5 || tileType == 6) return true;
		return false;
	}
	
	public int getTileType(Vector2 worldPos) {
		int tileX = (int)(worldPos.x / 32);
		int tileY = (int)(worldPos.y / 32);
		if (tileX < 0 || tileX >= mapWidth || tileY < 0 || tileY >= mapHeight) return -1;
		return mapGrid[tileX + (tileY *mapWidth)];
	}
	
	public Vector2 mapTileFromPosition(Vector2 pos){
		return new Vector2((int)(pos.x/32), (int)(pos.y/32));
	}
	
	public boolean PickUpItem(BaseItem item)
	{
		Vector2 playerMapTile = mapTileFromPosition(Game.player.pos);
		Vector2 itemMapTile = mapTileFromPosition(item.getPosition());
		if (playerMapTile.x == itemMapTile.x && playerMapTile.y == itemMapTile.y && Game.itemsBar.Add(item)){
			item.setInWorld(false);
			return true;
		}
		return false;
	}
	
	public void PlaceItem(BaseItem item, Vector2 position) {
		if (walkable(position)) {
			Game.itemsBar.Remove(item);
			item.setPosition(position);
			item.setInWorld(true);
			worldItems.add(item);
		}
	}
}
