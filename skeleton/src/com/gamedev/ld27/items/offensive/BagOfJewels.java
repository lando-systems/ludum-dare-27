package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BagOfJewels extends OffensiveWeaponItem {

	public BagOfJewels() {
		super("Bag of Jewels", "Diamonds, Saphires and Rubies, Oh My!");
		this.setIcon(Assets.bagOfJewels);		
		setDefeats(GameSettings.TrollBridge);
	}
}
