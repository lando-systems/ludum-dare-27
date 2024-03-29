package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;

public class CastleGuard extends BaseObstacle {

	public CastleGuard() {
		super("Castle guard", "The guard will prevent you from getting into the castle", GameSettings.CastleGuards);
		this.setIcon(Assets.commonGuard);
	}

	@Override
	public void update(float delta) {
		if (Game.player.isWearingDisguise() || Game.player.isWearingBox()) {
			this._walkable = true;
		} else {
			this._walkable = false;
		}
	}
	
}
