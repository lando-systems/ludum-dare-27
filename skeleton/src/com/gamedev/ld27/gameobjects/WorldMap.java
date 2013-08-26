package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.ItemFactory;
import com.gamedev.ld27.obstacle.*;

public class WorldMap extends GameObject {

	private Sprite[] mapTiles; 
	private Sprite[] mapTilesMushroom;
	private Sprite[] mapTilesGlasses;
	private static int TILE_SIZE = 32;
	private int tilesWide;
	private int tilesHigh;
	
	private TiledMap map;
	private int mapWidth = 100;
	private int mapHeight = 100;
	private int[] mapGrid; // this is the game map indexes
	
	public BaseItem RandomDropItem;
	private float RandomItemTimer = 0f;
	public boolean DrawBridgeDropped = false;
	
	public ArrayList<BaseItem> worldItems = new ArrayList<BaseItem>(20);
	
	public WorldMap(Rectangle bounds) {
		super(bounds);

		tilesWide = Assets.mapTiles.getWidth() / TILE_SIZE;
		tilesHigh = Assets.mapTiles.getHeight()/TILE_SIZE;
		mapTiles = new Sprite[tilesWide * tilesHigh]; 
		mapTilesMushroom = new Sprite[tilesWide * tilesHigh];
		mapTilesGlasses = new Sprite[tilesWide * tilesHigh];
		for (int y = 0; y < tilesHigh; y++){
			for (int x = 0; x < tilesWide; x++){
				mapTiles[x + (y * tilesWide)] = new Sprite(Assets.mapTiles, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				mapTilesMushroom[x + (y * tilesWide)] = new Sprite(Assets.mapTilesMushroom, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				mapTilesGlasses[x + (y * tilesWide)] = new Sprite(Assets.mapTilesGlasses, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
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
		
		
		BaseItem slinky = ItemFactory.getItem("Slinky");
		PlaceItem(slinky, new Vector2(2912, 288));
		BaseItem flute = ItemFactory.getItem("Flute");
		PlaceItem(flute, new Vector2(1536, 256));
		BaseItem helmet = ItemFactory.getItem("Helmet");
		PlaceItem(helmet, new Vector2(992, 224));
		BaseItem OT = ItemFactory.getItem("OffensiveTower");
		PlaceItem(OT, new Vector2(1888, 1920));
		BaseItem hack = ItemFactory.getItem("Hacksaw");
		PlaceItem(hack, new Vector2(2816, 3040));
		Game.snake = (Snake) ItemFactory.getItem("Snake");
		PlaceItem(Game.snake, new Vector2(0*32,81*32));
		Game.knight = new KnightWhoSaysNi();
		PlaceItem(Game.knight, new Vector2(10*32,94*32));
		
		Game.smokingGuard = new SmokingGuard();
		PlaceItem(Game.smokingGuard, new Vector2(26*32,95*32));
		Game.guardDog = new GuardDog();
		PlaceItem(Game.guardDog, new Vector2(37*32,91*32));
		Game.castleguard1 = new CastleGuard();
		PlaceItem(Game.castleguard1, new Vector2(30*32,92*32));
		Game.castleguard2 = new CastleGuard();
		PlaceItem(Game.castleguard2, new Vector2(31*32,92*32));
		Game.defensiveTower = new DefensiveTower();
		PlaceItem(Game.defensiveTower, new Vector2(22*32,92*32));
		Game.VegHippie = new VegetarianGuy();
		PlaceItem(Game.VegHippie, new Vector2(26*32,12*32));
		Game.dragonShackles = new DragonShackles();
		PlaceItem(Game.dragonShackles, new Vector2(35*32,95*32));
		
	}
	
	@Override
	public void update(float delta) {
		RandomItemTimer -= delta;
		if (RandomItemTimer <= 0 ){
			placeNewRandom();
			RandomItemTimer += 10.0f;
		}
		ArrayList<BaseItem> itemsToRemove= new ArrayList<BaseItem>();
		for (BaseItem item:worldItems) {
			item.update(delta);
			
			if (item.isAutoPickup() || Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
				if (PickUpItem(item)) {
					itemsToRemove.add(item);
					Game.dialogBox.AppendText("You picked up the " + item.getName());
				}
				if (!item.Alive) itemsToRemove.add(item);
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
				Sprite[] activeTextures = mapTiles;
				if (Game.player.IsWearingGlasses()) activeTextures = mapTilesGlasses;
				if (Game.player.isOnMushrooms()) activeTextures = mapTilesMushroom;
				if (x < 0 || x >= mapWidth || y < 0 || y >= mapHeight)
				{

					tile = activeTextures[2]; // Make this Mountains
				}
				else {
					tile = activeTextures[mapGrid[x + (y *mapWidth)]];
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
	
	public void SetMapTile(int x, int y, int type){
		mapGrid[x + (y *mapWidth)] = type;
	}
	
	private void placeNewRandom()
	{
		worldItems.remove(RandomDropItem);
		RandomDropItem = ItemFactory.GetRandomItem();
		Vector2 tempPos; 
		do {
			tempPos = Game.player.pos.cpy();
			int dx = Assets.random.nextInt(20) - 10;
			int dy = Assets.random.nextInt(20) - 10;
			tempPos.add(dx*32,dy*32);
		} while (!Game.gameWorld.Spawnable(tempPos));
		PlaceItem(RandomDropItem, tempPos);
	}
	
	public void screenPositionFromWorld(Sprite tile, Vector2 pos){
		if (pos == null || Game.player == null) return; // No idea why this sometimes happens
		if (tile == null) {
			tile = null;
		}
		tile.setPosition(_bounds.x + (_bounds.width/2.0f) - 16 - Game.player.pos.x -Config.screenHalfWidth + pos.x, _bounds.y + (_bounds.height/2.0f) - 16 - Game.player.pos.y -Config.screenHalfHeight + pos.y );
	}
	
	public Vector2 worldPosToScreenMapPos(Vector2 pos){
		return new Vector2(_bounds.x + (_bounds.width/2.0f) - 16 - Game.player.pos.x -Config.screenHalfWidth + pos.x, _bounds.y + (_bounds.height/2.0f) - 16 - Game.player.pos.y -Config.screenHalfHeight + pos.y );
	}
	
	public boolean walkable(Vector2 worldPos) {
		int tileType = getTileType(worldPos);
		Vector2 tileVec = mapTileFromPosition(worldPos);
		for (BaseItem item: worldItems){
			Vector2 tileItem = mapTileFromPosition(item.getPosition());
			if (!item.getWalkable() && tileItem.x == tileVec.x && tileItem.y == tileVec.y) return false;
		}
		
		//nothing laid on the map, now the real map tiles
		if (tileType == 0 || tileType == 3 || tileType == 4 || tileType == 5 || tileType == 6|| tileType == 8 || tileType == 9 || tileType == 14) return true;
		return false;
	}
	
	public boolean Spawnable(Vector2 worldPos) {
		int tileType = getTileType(worldPos);
		Vector2 tileVec = mapTileFromPosition(worldPos);
		for (BaseItem item: worldItems){
			Vector2 tileItem = mapTileFromPosition(item.getPosition());
			if (!item.getWalkable() && tileItem.x == tileVec.x && tileItem.y == tileVec.y) return false;
		}
		
		//nothing laid on the map, now the real map tiles
		if (tileType == 0 || tileType == 3 || tileType == 5 || tileType == 6|| tileType == 8 || tileType == 9 || tileType == 14) return true;
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
	
	public boolean SameTile(Vector2 first, Vector2 second){
		Vector2 firstMapTile = mapTileFromPosition(first);
		Vector2 secondMapTile = mapTileFromPosition(second);
		return (firstMapTile.x == secondMapTile.x && firstMapTile.y == secondMapTile.y);
	}
	
	
	public void PlaceItem(BaseItem item, Vector2 position) {
		if (item.PlaceOnUnWalkable || walkable(position)) {
			if (Game.itemsBar != null)
				Game.itemsBar.Remove(item);
			item.setPosition(position);
			item.setInWorld(true);
			worldItems.add(item);
		}
	}
}
