package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.items.UsefulItem;

public class Boomerang extends UsefulItem {
	public Boomerang() {
		this.setDescription("Boomerang: if you love something let it go, it'll come back");
		setIcon(Assets.boomerang);
		
//		setDefeats(GameSettings.???);
	}
}
