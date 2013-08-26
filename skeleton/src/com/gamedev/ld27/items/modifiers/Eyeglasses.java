package com.gamedev.ld27.items.modifiers;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.ModifierItem;

public class Eyeglasses extends ModifierItem {

	public Eyeglasses() {
		super("Eyeglasses", "Very useful for seeing clearly.");
		setIcon(Assets.eyeglasses);
	}

	public void use() {
		Game.player.StartWearingGlasses();
		Game.itemsBar.Remove(this);
	}
}
