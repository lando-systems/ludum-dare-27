package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.RangeWeapon;

public class SillyString extends RangeWeapon {

	public SillyString() {
		super("Can of silly string", "Don't get it in your eyes");
		this.setIcon(Assets.sillyString);
		
		setProperties(3, 5, 2);
		setDefeats(GameSettings.CastleGuards);
	}
}
