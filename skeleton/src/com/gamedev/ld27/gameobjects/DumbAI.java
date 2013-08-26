package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.ItemFactory;
import com.gamedev.ld27.items.Weapon;
import com.gamedev.ld27.items.useful.Boomerang;

public class DumbAI extends PlayerBase {

	private Weapon _weapon;
	private int _hitPoints;
	
	public DumbAI() {
		super(new Rectangle(0, 0, TILE_SIZE, TILE_SIZE), Assets.playerSheet);
		_weapon = new Boomerang();
		_hitPoints = 3;
	}
	
	private float _time;
	private float _moveTime = 2;
	
	public void takeDamage(int amount){
		_hitPoints -= amount;
		_immuneTime = 1f;
	}
	
	protected void handleInput(float delta) {
		if (_hitPoints <= 0) {
			if (Alive){
				BaseItem drop = ItemFactory.GetRandomKillItem();
				drop.setPosition(pos);
				Game.gameWorld.PlaceItem(drop, pos);
			}
			Alive = false;
			return;
		}
		_time += delta;
		if (_time > _moveTime) {
			_time = 0;
			
			
			switch(Config.rand.nextInt(4))
			{
			case Direction.North:
				moveNorth();
				break;
			case Direction.East:
				moveEast();
				break;
			case Direction.South:
				moveSouth();
				break;
			default:
				moveWest();
			}
			
			useWeapon(_weapon);
			
		}
	}
	
	@Override
	public void render(SpriteBatch batch){
		int animationFrame = (int)walkingAnimation % 4;
		Sprite tile = animTiles[animationFrame + (walkingDir * animLength)];
		Game.gameWorld.screenPositionFromWorld(tile, pos);
		//tile.setPosition(_bounds.x - Config.screenHalfWidth, _bounds.y - Config.screenHalfHeight);
		
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
		
//	public boolean updatePos(float delta) {
//		Vector2 pos = getPosition().cpy();
//		
//			
//			if ((int)pos.x == (int)targetPos.x &&
//				(int)pos.y == (int)targetPos.y)
//				return true;
//			
//			Vector2 dir = new Vector2(targetPos.x - pos.x, targetPos.y - pos.y);
//			dir.nor();
//			dir.scl(100*delta);
//			float dist = dir.len2();
//			float targetDist = targetPos.dst2(pos);
//			if (dist >= targetDist){
//				pos.x = targetPos.x;
//				pos.y = targetPos.y;
//			} else
//			{
//				pos.add(dir);
//			}
//			
//			setPosition(pos);
//			return false;
//		
//	}
}
