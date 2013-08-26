package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class BagOfJewels extends BaseItem {

	public BagOfJewels() {
		super("Bag of Jewels", "Diamonds, Saphires and Rubies, Oh My!");
		this.setIcon(Assets.bagOfJewels);
		setAdDescription("Money doesn't buy happiness, but it does cross bridges");
		
		setDefeats(GameSettings.TrollBridge);
	}
}
