package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Hammer extends OffensiveWeaponItem {
	
	public Hammer() {
		super("Hammer", "Mainly used for the smashing");
		setIcon(Assets.hammer);
		setDefeats(GameSettings.Rocks);
	}
}
