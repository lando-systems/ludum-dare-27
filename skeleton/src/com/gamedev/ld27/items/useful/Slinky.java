package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Slinky extends BaseItem {
	public Slinky() {
		super("Slinky", "A surprisingly effective grappling hook");
		this.setIcon(Assets.slinky);
		
		setDefeats(GameSettings.Abyss);
	}
}
