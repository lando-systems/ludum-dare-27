package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class VegetarianGuy extends BaseObstacle {

	public VegetarianGuy() {
		super("Vegetarian Guy", "With the right incentive, he could be turned", GameSettings.Vegetarian);
		this.setIcon(Assets.cardboardBox);
	}

}
