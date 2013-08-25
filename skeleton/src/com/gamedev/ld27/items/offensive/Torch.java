package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Torch extends OffensiveWeaponItem {

	public Torch() {
		this.setDescription("Oxy acetylene torch");
		setDefeats(GameSettings.DragonChain);
	}
}
