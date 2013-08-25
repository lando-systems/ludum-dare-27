package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.UsefulItem;

public class Hammer extends UsefulItem {
	
	public Hammer() {
		this.setDescription("Hammer, mainly used for the smashing");
		setIcon(Assets.hammer);
		setDefeats(GameSettings.Rocks);
	}
}
