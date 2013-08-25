package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class Slinky extends Weapon {
	public Slinky() {
		super("Slinky", "A surprisingly effective grappling hook");
		this.setIcon(Assets.slinky);
		
		setProperties(4, 1);
		
		setDefeats(GameSettings.Abyss);
	}
}
