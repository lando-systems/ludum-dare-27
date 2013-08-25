package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.UsefulItem;

public class Flute extends UsefulItem {
	public Flute() {
		this.setDescription("Flute: play a relaxing tune");
		this.setIcon(Assets.flute);
		
		setDefeats(GameSettings.CastleGuards);
	}
}
