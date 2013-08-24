package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.items.OffensiveWeaponItem;
import com.gamedev.ld27.obstacle.CastleGuard;

public class BouncyBall extends OffensiveWeaponItem {

	public BouncyBall(Vector2 position)
	{
		super(position);
		this.setDescription("Can of Silly String");
		this.addDefeater(CastleGuard.class);
	}
	

}
