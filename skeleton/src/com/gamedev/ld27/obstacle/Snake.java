package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class Snake extends BaseObstacle {
	
	public Snake() {
		super("Snake", "Hisssssss", GameSettings.Snake);
		this.setIcon(Assets.snake);
	}

}
