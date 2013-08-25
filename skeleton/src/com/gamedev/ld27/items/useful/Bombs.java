package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Bombs extends BaseItem {
	public Bombs() {
		super("Bomb", "exploderific!");
		setIcon(Assets.bombs);
		
		setDefeats(GameSettings.Rocks | GameSettings.CastleGuards);
	}
}
