package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BouncyBall extends OffensiveWeaponItem {

	public BouncyBall()
	{
		this.setDescription("Super bouncy ball!");
		
		this.addDefeater(com.gamedev.ld27.obstacle.CastleGuard.class);
	}
	

}
