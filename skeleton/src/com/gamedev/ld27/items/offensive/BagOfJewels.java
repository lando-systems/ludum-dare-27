package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BagOfJewels extends OffensiveWeaponItem {

	public BagOfJewels(Vector2 position)
	{
		super(position);
		this.setDescription("Diamonds, Saphires and Rubies, Oh My!");
		this.setIcon(Assets.bagOfJewels);
		
		setDefeats(GameSettings.TrollBridge);
	}
}
