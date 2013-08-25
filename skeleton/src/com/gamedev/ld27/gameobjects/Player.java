package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Player extends GameObject {

	public Vector2 pos;
	private Vector2 targetPos;
	private static float SPEED = 100.0f;
	private int startTileX = 10;
	private int startTileY = 10;
	private int walkingDir = Direction.North; // N = 0; E = 1; S = 2; W = 3
	private float walkingAnimation = 0f;
	
	private Sprite[] animTiles; 
	private static int TILE_SIZE = 32;
	private int animLength;
	
	private WeaponSystem weapon;	
	
	public Player(Rectangle bounds) {
		super(bounds);
		
		animLength = Assets.playerSheet.getWidth() / TILE_SIZE;
		animTiles = new Sprite[4 * animLength]; 
		for (int y = 0; y < 4; y++){
			for (int x = 0; x < animLength; x++){
				animTiles[x + (y * animLength)] = new Sprite(Assets.playerSheet, x*TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			}
		}
		
		pos = new Vector2(startTileX*32,startTileY*32);
		targetPos = new Vector2(startTileX*32,startTileY*32);
		
		weapon = new WeaponSystem(this);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		int animationFrame = (int)walkingAnimation % 4;
		Sprite tile = animTiles[animationFrame + (walkingDir * animLength)];
		tile.setPosition(_bounds.x - Config.screenHalfWidth, _bounds.y - Config.screenHalfHeight);
		
		boolean south = (walkingDir == Direction.South);
		
		// need to render behind player
		if (!south) {
			weapon.render(batch, walkingDir);
		}
		tile.draw(batch);	
		
		// render on player
		if (south) {
			weapon.render(batch, walkingDir);
		}
		
	}
	
	@Override
	public void update(float delta) {
		if (Utils.isKeyJustPressed(Keys.B)) System.out.println("Pressed");
		walkingAnimation += delta * 4f;
		if (walkingAnimation > 5.0f) walkingAnimation -= 4.0f;
		if (updatePos(delta)){
			Vector2 prevTarget = targetPos.cpy();
			if(Gdx.input.isKeyPressed(Keys.W)){
				targetPos.y += 32.0f;
				walkingDir = Direction.North;
			}
			else if(Gdx.input.isKeyPressed(Keys.A)){
				targetPos.x -= 32.0f;
				walkingDir = Direction.West;
			}
			else if(Gdx.input.isKeyPressed(Keys.S)){
				targetPos.y -= 32.0f;
				walkingDir = Direction.South;
			}
			else if(Gdx.input.isKeyPressed(Keys.D)){
				targetPos.x += 32.0f;
				walkingDir = Direction.East;
			}
			if (!Game.gameWorld.walkable(targetPos)) targetPos = prevTarget;
		} 
		
		weapon.update(delta);
	}
	
	public boolean updatePos(float delta){
		if ((int)pos.x == (int)targetPos.x &&
			(int)pos.y == (int)targetPos.y)
			return true;
		
		Vector2 dir = new Vector2(targetPos.x - pos.x, targetPos.y - pos.y);
//		if (pos.x < targetPos.x) dir.x = 1.0f;
//		if (pos.x > targetPos.x) dir.x = -1.0f;
//		if (pos.y < targetPos.y) dir.y = 1.0f;
//		if (pos.y > targetPos.y) dir.y = -1.0f;
		dir.nor();
		dir.scl(SPEED*delta);
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

	public boolean useWeapon(OffensiveWeaponItem item) {
		return weapon.useItem(item);	
	}
	
	public int getDirection() {
		return walkingDir;
	}
}
