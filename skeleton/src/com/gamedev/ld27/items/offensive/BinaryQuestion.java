package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BinaryQuestion extends OffensiveWeaponItem {

	public BinaryQuestion(Vector2 position)
	{
		super(position);
		this.setDescription("There are 10 types of people in the world.  Those who understand this riddle and those that don't.");

		setDefeats(GameSettings.TrollBridge);
	}
}
