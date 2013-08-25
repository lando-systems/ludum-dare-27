package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class WetNoodle extends OffensiveWeaponItem {

	public WetNoodle() {
		this.setDescription("Wet Noodle");
		setIcon(Assets.wetNoodle);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
