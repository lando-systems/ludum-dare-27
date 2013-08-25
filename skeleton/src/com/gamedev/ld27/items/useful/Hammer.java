package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class Hammer extends Weapon {
	
	public Hammer() {
		super("Hammer", "Mainly used for the smashing");
		setIcon(Assets.hammer);
		
		setProperties(1, 10);
		
		setDefeats(GameSettings.Rocks);
	}
}
