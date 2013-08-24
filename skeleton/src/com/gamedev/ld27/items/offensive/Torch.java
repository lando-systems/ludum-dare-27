package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.items.OffensiveWeaponItem;
import com.gamedev.ld27.obstacle.DragonShackles;

public class Torch extends OffensiveWeaponItem {

	public Torch(Vector2 position)
	{
		super(position);
		this.setDescription("Oxy acetylene torch");
		this.addDefeater(DragonShackles.class);
	}
}
