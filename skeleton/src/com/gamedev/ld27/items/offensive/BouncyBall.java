package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.RangeWeapon;

public class BouncyBall extends RangeWeapon {

	public BouncyBall() {
		super("Bouncy ball", "It's super bouncy and it's round");
		setIcon(Assets.bouncyBall);
		
		setProperties(4, 1, 1);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
