package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class SillyString extends OffensiveWeaponItem {

	public SillyString(Vector2 position)
	{
		super(position);
		this.setDescription("Can of silly String");

		setDefeats(GameSettings.CastleGuards);
	}
}
