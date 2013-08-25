package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BouncyBall extends OffensiveWeaponItem {

	public BouncyBall() {
		super("Bouncy ball", "It's super bouncy and it's round");
		setDefeats(GameSettings.CastleGuards);
	}
}
