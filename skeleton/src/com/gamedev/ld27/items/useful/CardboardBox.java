package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class CardboardBox extends BaseItem {

	public CardboardBox() {
		super("Cardboard Box", "Things are essentially invisible once they are in a box.");
		
		setIcon(Assets.cardboardBox);
		setDefeats(GameSettings.CastleGuards);
	}

}
