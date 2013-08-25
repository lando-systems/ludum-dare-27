package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BouncyBall extends OffensiveWeaponItem {

	public BouncyBall() {
		super("Bouncy ball", "It's super bouncy and it's round");
		setIcon(Assets.bouncyBall);
		
		setProperties(false, 4, 1, 2);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
