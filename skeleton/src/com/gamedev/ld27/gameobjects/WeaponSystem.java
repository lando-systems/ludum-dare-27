package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.RangeWeapon;
import com.gamedev.ld27.items.Weapon;
import com.gamedev.ld27.items.RangeWeaponData;

public class WeaponSystem {
	
	private PlayerBase _player;
	private Rectangle _weaponBounds;
	
	private float _time;
	private Weapon _item;
	private Vector2 _playerPos;
	
	private ArrayList<RangeWeaponData> _rangeWeapons = new ArrayList<RangeWeaponData>(10);
	
	public WeaponSystem(PlayerBase player) {
		_player = player;
		_weaponBounds = new Rectangle(0, 0, _player.getWidth(), _player.getHeight());
	}
	
	public boolean useItem(Weapon item) {
		if ((item == _item) && item.isSingleUse()) return false;
		item.playUseSound();
		_item = item;
		_time = 0;
		_playerPos = _player.getPosition();
		
		if (item instanceof RangeWeapon) {
			_rangeWeapons.add(new RangeWeaponData(_player, (RangeWeapon)item));
		}
		
		if (item.isMeleeWeapon()){
			Vector2 tile = _player.getUsePosition();
			checkHitPlayer(tile);
			checkHitAI(tile);
		}
		
		return true;
	}
	
	private void checkHitPlayer(Vector2 pos){
		if (_player == Game.player) return; // don't hit ourselves
		Vector2 playerTile = Game.gameWorld.mapTileFromPosition(Game.player.pos);
		Vector2 weaponTile = Game.gameWorld.mapTileFromPosition(pos);
		if (playerTile.x == weaponTile.x && playerTile.y == weaponTile.y && !Game.player.isImmune()) {
			Game.player.takeKnockbackDamage(_player.getDirection());
			
		}
	}
	
	private void checkHitAI(Vector2 pos) {
		if (_player != Game.player) return; //only from us
		for (GameObject obj : Game.playScreen.getGameObjects()){
			if(!(obj instanceof DumbAI))
				continue;
			DumbAI ai = (DumbAI) obj;
			Vector2 playerTile = Game.gameWorld.mapTileFromPosition(ai.pos);
			Vector2 weaponTile = Game.gameWorld.mapTileFromPosition(pos);
			if (playerTile.x == weaponTile.x && playerTile.y == weaponTile.y && !ai.isImmune()) {
				ai.takeKnockbackDamage(_player.getDirection());
				ai.takeDamage(_item.Damage);
			}
		}
	}
	
	public void update(float delta) {
		if (_item != null) {
			_time += delta;
			
			if (_time >= _item.animationTime()) {
				if (!isInUse(_item)) {
					_item = null;
				}
			}
		}
		
		ArrayList<RangeWeaponData> removeList = new ArrayList<RangeWeaponData>();
		for (RangeWeaponData range : _rangeWeapons) {
			range.update(delta);
			if (range.isComplete()) {
				removeList.add(range);
			}
		}
		
		for (RangeWeaponData range : removeList) {
			_rangeWeapons.remove(range);
		}
	}
	
	private boolean isInUse(Weapon weapon) {
		if (weapon.isSingleUse()) {
			for (RangeWeaponData rwd : _rangeWeapons) {
				if (rwd.isWeapon(weapon)) {
					return true;
				}
			}
		}
		return false;
		
		
	}

	public void render(SpriteBatch batch, int walkingDir) {
		for (RangeWeaponData range : _rangeWeapons) {
			range.render(batch);
		}
		
		if (_item == null) return;
		
		if (_item.isMeleeWeapon()) {
			renderMelee(batch, walkingDir);
		}
	}
	
	private void renderMelee(SpriteBatch batch, int walkingDir) {
		Rectangle weaponBounds = getMeleeBounds(walkingDir);
		Vector2 screenPos = Game.gameWorld.worldPosToScreenMapPos(new Vector2(weaponBounds.x, weaponBounds.y));
		batch.draw(_item.getWeaponUseImage(walkingDir),  
				screenPos.x,
				screenPos.y,
				0, 0, _item.getWidth(), _item.getHeight(), weaponBounds.width / _item.getWidth(),
				weaponBounds.height / _item.getHeight(), 0);
	}

	private Rectangle getMeleeBounds(int direction) {
		
		float max = _player.getWidth() * _item.getRange();
		
		float downOffset = 8;
		
		if (direction == Direction.South) {
			max -= downOffset;
		}
		
		float renderTime = _item.animationTime() / 2;		
		float size = (_time < renderTime) ? _time : (2*renderTime - _time);
		size = size / renderTime * max;
		if (size < 0) {
			size = 0;
		}
				
		// N = 0; E = 1; S = 2; W = 3
		Vector2 playerPos = _player.getPosition();
		switch (direction) {
			case Direction.North:
			case Direction.South:
				_weaponBounds.set(playerPos.x, _playerPos.y + (_player.getHeight()/2), 
						_player.getWidth(), size);
				
				if (direction == Direction.South) {
					_weaponBounds.y -= (size + downOffset);
				}
				break;
			case Direction.East: 
			case Direction.West:
				_weaponBounds.set(playerPos.x + (_player.getWidth()/2), playerPos.y, size, _player.getHeight());
				if (direction == Direction.West) {
					_weaponBounds.x -= size;
				}
				break;
			
		}
		
		return _weaponBounds;
	}

}
