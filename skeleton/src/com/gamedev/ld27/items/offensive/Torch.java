package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Torch extends OffensiveWeaponItem {

	public Torch() {
		super("Oxy acetylene torch", "This torch can cut through metal");
		setDefeats(GameSettings.DragonChain);
	}
}
