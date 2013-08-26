package com.gamedev.ld27.items.modifiers;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.ModifierItem;;

public class Mushroom extends ModifierItem {

	public Mushroom() {
		super("Mushroom", "Tasty and enlightening - remember kids, don't use drugs");
		setIcon(Assets.mushroom);
	}
	
	public void use() {
		Game.player.StartTripping();
		Game.itemsBar.Remove(this);
	}
}
