package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class Hacksaw extends Weapon {

	public Hacksaw() {
		super("Hacksaw", "Able to cut the mightiest of chains!");
		setIcon(Assets.hacksaw);
		
		setProperties(1, 10);
		
		setDefeats(GameSettings.DragonChain);
	}
}
