package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class ExplodingCigar extends BaseItem {

	public ExplodingCigar() {
		super("Exploding Cigar", "Smoking can be hazardous to your health");
		
		setIcon(Assets.explodingCigar);
		setDefeats(GameSettings.SmokingGuard);
	}

}
