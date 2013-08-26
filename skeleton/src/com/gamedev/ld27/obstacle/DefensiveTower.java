package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class DefensiveTower extends BaseObstacle {

	public DefensiveTower() {
		super("Defensive Tower", "This guy can't take a joke", GameSettings.DefensiveTower);
		this.setIcon(Assets.cardboardBox);
	}
}
