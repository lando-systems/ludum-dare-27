package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.obstacle.Rock;

public class Bombs extends BaseItem {
	
	private float _time;
	private float _maxTime = 3;
	
	public Bombs() {
		super("Bomb", "exploderific!");
		setIcon(Assets.bombs);
		PlaceOnUnWalkable = true;
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
		Alive = false;
		for (BaseItem item : Game.gameWorld.worldItems){
			if (Game.gameWorld.SameTile(pos, item.getPosition()) && item instanceof Rock) item.Alive = false;
		}
	}
}
