package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.OffensiveWeaponItem;

public class WetNoodle extends OffensiveWeaponItem {

	public WetNoodle() {
		super("Wet Noodle", "You can hit something with a wet noodle");
		setIcon(Assets.wetNoodle);
		
		setProperties(true, 1, 4);
		
		setDefeats(GameSettings.CastleGuards);
	}
	
	public TextureRegion getWeaponUseImage(int direction) {
		return ((direction % 2) == 0) ? Assets.wetNoodleVert : Assets.wetNoodleHor;
	}
}
