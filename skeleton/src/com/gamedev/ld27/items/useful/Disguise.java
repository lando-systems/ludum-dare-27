package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Disguise extends BaseItem {

	public Disguise() {
		super("Disguise", "No one will stop you from crashing a party in this disguise!");
		
		setIcon(Assets.disguise);
		setDefeats(GameSettings.CastleGuards);
	}

}
