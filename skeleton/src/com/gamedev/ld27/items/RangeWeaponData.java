package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.gameobjects.DumbAI;
import com.gamedev.ld27.gameobjects.GameObject;
import com.gamedev.ld27.gameobjects.PlayerBase;

public class RangeWeaponData {

	private PlayerBase _player;
	private Vector2 _direction;
	private int _dir;
	private Vector2 _offset;
	private Vector2 _position;
	private float _maxTime;
	private float _time;
	private TextureRegion _texture;
	private float _scale;
	private float _rotationDr;
	private float _rotation;
	private boolean _isReturning;
	private RangeWeapon _weapon;
		
	public RangeWeaponData(PlayerBase player, RangeWeapon item) {
		_player = player;
		_direction = getDirection(player, item);
		_offset = player.getPosition().cpy();
		_position = new Vector2(player.getPosition());
		_maxTime = item.animationTime();
		_texture = item.getWeaponUseImage(player.getDirection());
		_scale = item.getRangeScale();
		_rotationDr = item.getRotation(player.getDirection());
		_isReturning = item.doesReturn();
		_weapon = item;
	}
	
	public boolean isWeapon(Weapon weapon) {
		return (_weapon == weapon);
	}
	
	private Vector2 getDirection(PlayerBase player, Weapon item) {
		
		float speed = (item.getRange() * item.getWidth()) / item.animationTime();
		_dir = player.getDirection();
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
	
	private float _returnSpeed = -1;
	
	public void update(float delta) {
		
		if (_time < _maxTime) {
			Vector2 playerPos = _player.pos.cpy();
			float dx = _offset.x - playerPos.x;
			float dy = _offset.y - playerPos.y;
			_offset = playerPos;
			
			_position.x += (_direction.x*delta + dx);
			_position.y += (_direction.y*delta + dy);
			_time += delta;	
		} else {
			Vector2 returnPath = _player.getPosition().cpy();
			returnPath.sub(_position);

			if (_returnSpeed < 0) {
				_returnSpeed = returnPath.len();
			} else {
				returnPath.nor().scl(_returnSpeed);
			}
				
			_position.add(returnPath.scl(delta));
			
			Vector2 dif = _player.getPosition().cpy().sub(_position);
			if (dif.len() < 2) {
				_isReturning = false;
			}
		}
		checkHitPlayer();
		checkHitAI();
		_rotation += _rotationDr*delta;
	}
	
	private void checkHitPlayer(){
		if (_player == Game.player) return; // don't hit ourselves
		Vector2 playerTile = Game.gameWorld.mapTileFromPosition(Game.player.pos);
		Vector2 weaponTile = Game.gameWorld.mapTileFromPosition(_position);
		if (playerTile.x == weaponTile.x && playerTile.y == weaponTile.y && !Game.player.isImmune()) {
			Game.player.takeKnockbackDamage(_dir);
			_time = _maxTime;
		}
	}
	
	private void checkHitAI() {
		if (_player != Game.player) return; //only from us
		for (GameObject obj : Game.playScreen.getGameObjects()){
			if(!(obj instanceof DumbAI))
				continue;
			DumbAI ai = (DumbAI) obj;
			Vector2 playerTile = Game.gameWorld.mapTileFromPosition(ai.pos);
			Vector2 weaponTile = Game.gameWorld.mapTileFromPosition(_position);
			if (playerTile.x == weaponTile.x && playerTile.y == weaponTile.y && !ai.isImmune()) {
				ai.takeKnockbackDamage(_dir);
				ai.takeDamage(_weapon.Damage);
				_time = _maxTime;
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		Vector2 screenPos = Game.gameWorld.worldPosToScreenMapPos(_position);
		batch.draw(_texture,  screenPos.x, 
				screenPos.y, 16, 16, 32, 32, _scale, _scale, _rotation);
	}
	
	public boolean isComplete() {
		return (_time >= _maxTime && !_isReturning);
	}
}
