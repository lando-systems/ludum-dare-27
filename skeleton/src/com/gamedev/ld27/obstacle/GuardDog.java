package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class GuardDog extends BaseObstacle {

	public GuardDog() {
		super("Guard Dog", "Dangerously fishy breath", GameSettings.GuardDog);
		this.setIcon(Assets.dog);
	}
}
