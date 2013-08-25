package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Bombs extends BaseItem {
	
	private float _time;
	private float _maxTime = 10;
	
	public Bombs() {
		super("Bomb", "exploderific!");
		setIcon(Assets.bombs);
		
		setDefeats(GameSettings.Rocks | GameSettings.CastleGuards);
	}
	
	public void update(float delta) {
		if (isInWorld()) {
			_time += delta;
			if (_time >= _maxTime) {
				explode();				
			}
		}
	}
	
	private void explode() {
	}
}
