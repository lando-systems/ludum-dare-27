package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Slinky extends OffensiveWeaponItem {
	public Slinky() {
		super("Slinky", "A surprisingly effective grappling hook");
		this.setIcon(Assets.slinky);
		
		setProperties(true, 4, 1, 1);
		
		setDefeats(GameSettings.Abyss);
	}
}
