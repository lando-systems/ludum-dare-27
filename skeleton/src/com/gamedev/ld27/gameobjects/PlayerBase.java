package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.Weapon;

public class PlayerBase extends GameObject {

	public Vector2 pos;
	protected Vector2 targetPos;
	protected float speed = 1.0f;
	protected int walkingDir = Direction.North; // N = 0; E = 1; S = 2; W = 3
	protected float walkingAnimation = 0f;
	
	protected Sprite[] animTiles;
	protected Sprite[] animTilesHelmet;
	protected static final int TILE_SIZE = 32;
	protected int animLength;
	
	protected boolean _livePlayer;
	protected float _immuneTime;
	protected boolean _wearingHelm = false;
	
	protected WeaponSystem weaponSystem;	
	
	public PlayerBase(Rectangle bounds, Texture textureSheet) {
		super(bounds);
		_immuneTime = 0f;
		animLength = textureSheet.getWidth() / TILE_SIZE;
		animTiles = new Sprite[4 * animLength]; 
		animTilesHelmet = new Sprite[4 * animLength];
		for (int y = 0; y < 4; y++){
			for (int x = 0; x < animLength; x++){
				animTiles[x + (y * animLength)] = new Sprite(textureSheet, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				animTilesHelmet[x + (y * animLength)] = new Sprite(Assets.playerHelmetSheet, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
		
		weaponSystem = new WeaponSystem(this);
	}
	
	public void init(float speed, int startTileX, int startTileY) {
		
		pos = new Vector2(startTileX*32,startTileY*32);
		targetPos = new Vector2(startTileX*32,startTileY*32);
		
		this.speed = speed;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		int animationFrame = (int)walkingAnimation % 4;
		Sprite tile;
		if (_wearingHelm){
			tile = animTilesHelmet[animationFrame + (walkingDir * animLength)];
		} else {
			tile = animTiles[animationFrame + (walkingDir * animLength)];
		}
		tile.setPosition(_bounds.x - Config.screenHalfWidth, _bounds.y - Config.screenHalfHeight);
		
		boolean south = (walkingDir == Direction.South);
		
		// need to render behind player
		if (!south) {
			weaponSystem.render(batch, walkingDir);
		}
		tile.draw(batch);	
		
		// render on player
		if (south) {
			weaponSystem.render(batch, walkingDir);
		}		
	}
	
	public boolean IgnoreInput;
	
	@Override
	public void update(float delta) {
		if (isImmune()) _immuneTime -= delta;
		walkingAnimation += delta * 4f;
		if (walkingAnimation > 5.0f) walkingAnimation -= 4.0f;
		if (IgnoreInput) return;
		if (updatePos(delta)){
			Vector2 prevTarget = targetPos.cpy();
			handleInput(delta);
			if (!Game.gameWorld.walkable(targetPos)) targetPos = prevTarget;
		} 
		
		weaponSystem.update(delta);
	}
	
	public boolean isImmune()
	{
		return _immuneTime > 0;
	}
	
	protected void handleInput(float delta) {
	
	}
	
	public void moveNorth() {
		targetPos.y += 32.0f;
		walkingDir = Direction.North;
	}
	
	public void moveWest() {
		targetPos.x -= 32.0f;
		walkingDir = Direction.West;
	}
	
	public void moveSouth() {
		targetPos.y -= 32.0f;
		walkingDir = Direction.South;
	}

	public void moveEast() {
		targetPos.x += 32.0f;
		walkingDir = Direction.East;
	}
	
	private boolean _moving = false;
	public boolean updatePos(float delta){
		if ((int)pos.x == (int)targetPos.x &&
			(int)pos.y == (int)targetPos.y) 
		{
			if (_moving) {
				finishMove(Game.gameWorld.getTileType(pos));
				_moving = false;
				return false;
			}
			
			return true;
		}
		
		_moving = true;
		
		Vector2 dir = new Vector2(targetPos.x - pos.x, targetPos.y - pos.y);
		dir.nor();
		dir.scl(speed*delta);
		float dist = dir.len2();
		float targetDist = targetPos.dst2(pos);
		if (dist >= targetDist){
			pos.x = targetPos.x;
			pos.y = targetPos.y;
		} else
		{
			pos.add(dir);
		}
		return false;
	}
	
	protected void finishMove(int tileType) {
		
	}

	public Vector2 getUsePosition() {
		Vector2 usePos = targetPos.cpy();
		switch (walkingDir){
		case 0:
			usePos.add(0, 32);
			break;
		case 1:
			usePos.add(32, 0);
			break;
		case 2:
			usePos.add(0, -32);
			break;
		case 3: 
			usePos.add(-32, 0);
			break;
		}
		return usePos;
	}

	public void takeKnockbackDamage(int dir){
		_immuneTime = 1f;
		Vector2 tempPos = targetPos.cpy();
		switch (dir){
		case 0:
			tempPos.add(0, 32);
			break;
		case 1:
			tempPos.add(32, 0);
			break;
		case 2:
			tempPos.add(0, -32);
			break;
		case 3: 
			tempPos.add(-32, 0);
			break;
		}
	
		if (Game.gameWorld.walkable(tempPos)){
			targetPos = tempPos;
		} // else stay there... can't move onto it
	}
	
	public boolean useWeapon(Weapon item) {
		return weaponSystem.useItem(item);	
	}
	
	public int getDirection() {
		return walkingDir;
	}
	
//	public Vector2 getPlayerPosition() {
//		return pos;
//	}
	
	@Override
	public Vector2 getPosition()
	{
		return pos;
	}
}
