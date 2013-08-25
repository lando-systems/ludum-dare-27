package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class Boomerang extends OffensiveWeaponItem {
	public Boomerang() {
		super("Boomerang", "if you love something let it go, it'll come back");
		setIcon(Assets.boomerang);
		
		setProperties(false, 7, 30, 1);
		
		setDefeats(GameSettings.CastleGuards);
	}
	
	public float getRotation(int direction)
	{
		float rotationSpeed = 1280f;
		if (direction == Direction.North || direction == Direction.East) {
			rotationSpeed = -rotationSpeed;
		}
		return rotationSpeed;
	}
	
	public boolean isSingleUse() {
		return true;
	}
}
