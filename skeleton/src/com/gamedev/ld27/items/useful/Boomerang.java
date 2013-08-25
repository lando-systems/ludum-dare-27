package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Boomerang extends OffensiveWeaponItem {
	public Boomerang() {
		super("Boomerang", "if you love something let it go, it'll come back");
		setIcon(Assets.boomerang);
		
		setProperties(false, 7, 30, 6);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
