package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.RangeWeapon;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class WeaponSystem {
	
	private Player _player;
	private Rectangle _weaponBounds;
	
	private float _time;
	private OffensiveWeaponItem _item;
	private Vector2 _playerPos;
	
	private ArrayList<RangeWeapon> _rangeWeapons = new ArrayList<RangeWeapon>(10);
	
	public WeaponSystem(Player player) {
		_player = player;
		_weaponBounds = new Rectangle(0, 0, _player.getWidth(), _player.getHeight());
	}
	
	public boolean useItem(OffensiveWeaponItem item) {
		if ((item == _item) && item.isSingleUse()) return false;
		
		_item = item;
		_time = 0;
		_playerPos = _player.getPosition();
		
		if (!item.isMeleeWeapon()) {
			_rangeWeapons.add(new RangeWeapon(_player, item));
		}
		
		return true;
	}
	
	public void update(float delta) {
		if (_item != null) {
			_time += delta;
			
			if (_time >= _item.animationTime()) {
				_item = null;
			}
		}
		
		ArrayList<RangeWeapon> removeList = new ArrayList<RangeWeapon>();
		for (RangeWeapon range : _rangeWeapons) {
			range.update(delta);
			if (range.isComplete()) {
				removeList.add(range);
			}
		}
		
		for (RangeWeapon range : removeList) {
			_rangeWeapons.remove(range);
		}
	}

	public void render(SpriteBatch batch, int walkingDir) {
		for (RangeWeapon range : _rangeWeapons) {
			range.render(batch);
		}
		
		if (_item == null) return;
		
		if (_item.isMeleeWeapon()) {
			renderMelee(batch, walkingDir);
		}
	}
	
	private void renderMelee(SpriteBatch batch, int walkingDir) {
		Rectangle weaponBounds = getMeleeBounds(walkingDir);
		batch.draw(_item.getWeaponUseImage(walkingDir),  
				weaponBounds.x - Config.screenHalfWidth,
				weaponBounds.y - Config.screenHalfHeight,
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
