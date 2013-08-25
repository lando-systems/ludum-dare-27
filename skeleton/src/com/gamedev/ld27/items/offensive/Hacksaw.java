package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Hacksaw extends OffensiveWeaponItem {

	public Hacksaw() {
		this.setDescription("Hacksaw");

		setDefeats(GameSettings.DragonChain);
	}
}
