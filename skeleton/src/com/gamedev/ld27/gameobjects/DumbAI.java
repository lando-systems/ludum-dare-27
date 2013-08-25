package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.items.Weapon;
import com.gamedev.ld27.items.useful.Boomerang;

public class DumbAI extends PlayerBase {

	private Weapon _weapon;
	
	public DumbAI() {
		super(new Rectangle(0, 0, TILE_SIZE, TILE_SIZE), Assets.playerSheet);
		_weapon = new Boomerang();
	}
	
	private float _time;
	private float _moveTime = 2;
	
	protected void handleInput(float delta) {
		
		_time += delta;
		if (_time > _moveTime) {
			_time = 0;
			useWeapon(_weapon);
			
			switch(Config.rand.nextInt(3))
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
			
		}
	}
		
	public boolean updatePos(float delta) {
		Vector2 pos = getPosition().cpy();
		
			
			if ((int)pos.x == (int)targetPos.x &&
				(int)pos.y == (int)targetPos.y)
				return true;
			
			Vector2 dir = new Vector2(targetPos.x - pos.x, targetPos.y - pos.y);
			dir.nor();
			dir.scl(100*delta);
			float dist = dir.len2();
			float targetDist = targetPos.dst2(pos);
			if (dist >= targetDist){
				pos.x = targetPos.x;
				pos.y = targetPos.y;
			} else
			{
				pos.add(dir);
			}
			
			setPosition(pos);
			return false;
		
	}
}
