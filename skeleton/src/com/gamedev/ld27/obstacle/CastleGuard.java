package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.math.Vector2;

public class CastleGuard extends BaseObstacle {

	public CastleGuard(Vector2 position) {
		super(position);
		setDescription("The guard will prevent you from getting into the castle");
	}

}
