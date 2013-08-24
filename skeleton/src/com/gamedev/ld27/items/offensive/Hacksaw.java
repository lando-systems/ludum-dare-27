package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Hacksaw extends OffensiveWeaponItem {

	public Hacksaw(Vector2 position)
	{
		super(position);
		this.setDescription("Hacksaw");

		setDefeats(GameSettings.DragonChain);
	}
}
