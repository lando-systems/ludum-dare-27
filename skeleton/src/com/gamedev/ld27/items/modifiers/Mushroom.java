package com.gamedev.ld27.items.modifiers;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.items.ModifierItem;;

public class Mushroom extends ModifierItem {

	public Mushroom() {
		super("Mushroom", "Tasty and enlightening - remember kids, don't use drugs");
		setIcon(Assets.mushroom);
	}
}
