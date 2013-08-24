package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.math.Vector2;

public class DefensiveTower extends BaseObstacle {

	public DefensiveTower(Vector2 position) {
		super(position);
		setDescription("Tower Defense");
		setIcon("defensive_tower.png");
	}

}
