package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.UsefulItem;

public class Slinky extends UsefulItem {
	public Slinky() {
		this.setDescription("Slinky: a surprisingly effective grappling hook");
		this.setIcon(Assets.slinky);
		
		setDefeats(GameSettings.Abyss);
	}
}
