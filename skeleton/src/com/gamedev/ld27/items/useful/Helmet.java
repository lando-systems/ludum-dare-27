package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.UsefulItem;

public class Helmet extends UsefulItem {
	public Helmet() {
		this.setDescription("Helmet: protect your noggin");
		this.setIcon(Assets.helmet);
		
//		setDefeats(GameSettings.Avalanche);
	}
}
