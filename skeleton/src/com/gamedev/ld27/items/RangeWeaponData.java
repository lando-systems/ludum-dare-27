package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.gameobjects.Player;

public class RangeWeaponData {

	private Player _player;
	private Vector2 _direction;
	private Vector2 _offset;
	private Vector2 _position;
	private float _maxTime;
	private float _time;
	private TextureRegion _texture;
	private float _scale;
	private float _rotationDr;
	private float _rotation;
		
	public RangeWeaponData(Player player, RangeWeapon item) {
		_player = player;
		_direction = getDirection(player, item);
		_offset = new Vector2(player.getPlayerPosition());
		_position = new Vector2(player.getPosition());
		_maxTime = item.animationTime();
		_texture = item.getWeaponUseImage(player.getDirection());
		_scale = item.getRangeScale();
		_rotationDr = item.getRotation(player.getDirection());
	}
	
	private Vector2 getDirection(Player player, Weapon item) {
		
		float speed = (item.getRange() * item.getWidth()) / item.animationTime();
		
		switch (player.getDirection())
		{
		// fall through switch - gotta love java
		case Direction.South:
			speed = -speed;
		case Direction.North:
			return new Vector2(0, speed);
		case Direction.West:
			speed = -speed;
		default:
			return new Vector2(speed, 0);			
		}
	}
	
	public void update(float delta) {
		Vector2 playerPos = new Vector2(_player.getPlayerPosition());
		float dx = _offset.x - playerPos.x;
		float dy = _offset.y - playerPos.y;
		_offset = playerPos;
		
		_position.x += (_direction.x*delta + dx);
		_position.y += (_direction.y*delta + dy);
		_time += delta;	
		
		_rotation += _rotationDr*delta;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(_texture,  _position.x - Config.screenHalfWidth, 
				_position.y - Config.screenHalfHeight, 16, 16, 32, 32, _scale, _scale, _rotation);
	}
	
	public boolean isComplete() {
		return (_time >= _maxTime);
	}
}
