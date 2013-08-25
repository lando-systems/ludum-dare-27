package com.gamedev.ld27.items.offensive;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class WetNoodle extends Weapon {

	public WetNoodle() {
		super("Wet Noodle", "You can hit something with a wet noodle");
		setIcon(Assets.wetNoodle);
		
		setProperties(1, 4);
		
		setDefeats(GameSettings.CastleGuards);
		Damage = 5;
	}
	
	public TextureRegion getWeaponUseImage(int direction) {
		return ((direction % 2) == 0) ? Assets.wetNoodleVert : Assets.wetNoodleHor;
	}
}
