package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class SmokingGuard extends BaseObstacle {

	public SmokingGuard() {
		super("Smoking Guard", "Remember kids, smoking kills!", GameSettings.GuardDog);
		this.setIcon(Assets.smokingGuard);
	}

}
