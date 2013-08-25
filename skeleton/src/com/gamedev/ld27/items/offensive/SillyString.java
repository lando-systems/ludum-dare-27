package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class SillyString extends OffensiveWeaponItem {

	public SillyString() {
		this.setDescription("Can of silly String");

		setDefeats(GameSettings.CastleGuards);
	}
}
