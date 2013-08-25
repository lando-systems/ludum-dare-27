package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class BouncyBall extends OffensiveWeaponItem {

	public BouncyBall(Vector2 position)
	{
		super(position);
		this.setDescription("Super bouncy ball!");

		setDefeats(GameSettings.CastleGuards);
	}
	

}
