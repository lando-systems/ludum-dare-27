package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Torch extends OffensiveWeaponItem {

	public Torch(Vector2 position)
	{
		super(position);
		this.setDescription("Oxy acetylene torch");

		setDefeats(GameSettings.DragonChain);
	}
}
