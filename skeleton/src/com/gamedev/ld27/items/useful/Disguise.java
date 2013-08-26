package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Disguise extends BaseItem {

	public Disguise() {
		super("Disguise", "No one will stop you from crashing a party in this disguise!");
		
		setIcon(Assets.disguise);
		setDefeats(GameSettings.CastleGuards);
	}

	public void use() {
		Game.player.ToggleDisguise();
		Game.itemsBar.Remove(this);
	}
	
}
