package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.math.Vector2;

public class TrollBridge extends BaseObstacle {

	public TrollBridge(Vector2 position) {
		super(position);
		
		setDescription("The troll has a question for you before you can cross");
	}

}
