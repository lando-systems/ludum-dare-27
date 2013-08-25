package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Flute extends BaseItem {
	public Flute() {
		super("Flute", "play a relaxing tune");
		this.setIcon(Assets.flute);
		
		setDefeats(GameSettings.Snake);
	}
}
