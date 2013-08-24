package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.items.OffensiveWeaponItem;
import com.gamedev.ld27.obstacle.DragonShackles;

public class Hacksaw extends OffensiveWeaponItem {

	public Hacksaw(Vector2 position)
	{
		super(position);
		this.setDescription("Hacksaw");
		this.addDefeater(DragonShackles.class);
	}
}
