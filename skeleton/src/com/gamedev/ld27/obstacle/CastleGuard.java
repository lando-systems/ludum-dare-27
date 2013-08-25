package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.GameSettings;

public class CastleGuard extends BaseObstacle {

	public CastleGuard() {
		super("Castle guard", "The guard will prevent you from getting into the castle", GameSettings.CastleGuards);
	}

}
