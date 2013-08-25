package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class SillyString extends OffensiveWeaponItem {

	public SillyString() {
		this.setDescription("Can of silly string: don't get it in your eyes");
		this.setIcon(Assets.sillyString);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
